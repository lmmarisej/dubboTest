package org.lmmarise.rocketmq.producer.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.lmmarise.rocketmq.producer.domain.Order;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:47 上午
 */
@Component
@RocketMQTransactionListener(txProducerGroup = "OrderTransactionGroup")
public class TransactionMsgListener implements RocketMQLocalTransactionListener {

    /**
     * 消息发送成功执行本地事务
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {
            // 拿到前面生成的事务ID
            String transactionId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
            // 以事务ID为主键，执行本地事务
            Order order = (Order) message.getPayload();
            boolean result = this.saveOrder(order, transactionId);
            return result ? RocketMQLocalTransactionState.COMMIT : RocketMQLocalTransactionState.ROLLBACK;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    private boolean saveOrder(Order order, String transactionId){
        // 事务ID 设置为 唯一键
        // 调用数据库 insert into 订单表
        return true;
    }

    /**
     * 检查本地事务状态，未知状态默认在1m后由Broker通知producer检查本地事务
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        // 拿到事务ID
        String transactionId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        // 以事务ID为主键，查询本地事务执行情况
        if (isSuccess(transactionId)) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    private boolean isSuccess(String transactionId) {
        // 查询数据库 select from 订单表
        return true;
    }
}

