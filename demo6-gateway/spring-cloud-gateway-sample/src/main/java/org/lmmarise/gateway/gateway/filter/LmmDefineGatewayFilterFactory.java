package org.lmmarise.gateway.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器类名必须以 GatewayFilterFactory 结尾，name 以 GatewayFilterFactory 的前缀命名
 *
 * 例如，LmmDefineGatewayFilterFactory name为 LmmDefine
 *
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 9:43 下午
 */
@Service
@Slf4j
public class LmmDefineGatewayFilterFactory extends AbstractGatewayFilterFactory<LmmDefineGatewayFilterFactory.LmmConfig> {

    public LmmDefineGatewayFilterFactory() {
        super(LmmConfig.class);
    }

    @Override
    public GatewayFilter apply(LmmConfig config) {
        // 配置 spring.cloud.gateway.routes[0].filters[0].args.name 属性对应 LmmConfig.name
        return ((exchange, chain) -> {
            log.info("[Pre] Filter Request,name:" + config.getName());
            return chain
                    .filter(exchange)
                    .then(Mono.fromRunnable(() -> log.info("[Post] Response Filter")));
        });
    }

    public static class LmmConfig {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
