package org.lmmarise.gateway.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 设置限流请求的key
 *
 * 默认实现 PrincipalNameKeyResolver，会从 ServerWebExchange 检索 Principal name 作为 key。
 *
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 9:41 下午
 */
@Service
public class IpAddressKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono
                .just(exchange
                        .getRequest()
                        .getRemoteAddress()
                        .getAddress()
                        .getHostAddress()
                );
    }
}
