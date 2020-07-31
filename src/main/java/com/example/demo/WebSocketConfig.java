package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @since 参考 https://www.cnblogs.com/nosqlcoco/p/5860730.html
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler(), "/websocket/demo").setAllowedOrigins("*");
        registry.addHandler(myWebSocketHandler(), "/sockjs").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    MyWebSocketHandler myWebSocketHandler() {
        return new MyWebSocketHandler();
    }
}
