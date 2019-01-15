package com.artisan.microservice.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;
// 添加注解#Component使其成为Spring管理的bean
@Component
public class MyFallbackProvider  implements FallbackProvider {

    @Override
    public String getRoute() {
    	// 为哪个微服务提供提供回退服务，返回微服务的名字,必须和注册在Eureka Server上的名字一致
        return "microservice-provider-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        // fallback时的状态码
    	if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
            	// 响应体
                return new ByteArrayInputStream(("【 " +getRoute() + " 】fallback").getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
            	// headers设置
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
