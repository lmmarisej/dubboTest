package org.lmmarise.seata.order.convert;

import org.lmmarise.seata.common.dto.OrderDto;
import org.lmmarise.seata.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:04 下午
 */
@Component
@Mapper(componentModel = "spring")
public interface OrderConvert {

    @Mappings({
            @Mapping(source = "orderCount", target = "count"),
            @Mapping(source = "orderAmount", target = "amount")
    })
    Order dto2Order(OrderDto orderDto);
}
