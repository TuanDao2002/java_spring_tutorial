package com.cosc2440.week5;

import com.cosc2440.week5.service.FacebookService;
import com.cosc2440.week5.service.HangoutService;
import com.cosc2440.week5.service.MessageService;
import com.cosc2440.week5.service.SMSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
// add @ComponentScan here so AppConfig can find the Beans that it does not include but have @Component at the top
@ComponentScan
public class AppConfig {
    @Bean
    @Scope("singleton") // all Beans of ChatApplication can only have 1 scope
    ChatApplication chatApplication() {
        return new ChatApplication();
    }

    @Bean
    // the later Bean can override the scope of all other Beans of the same class
    @Scope("prototype") // the Bean must have scope "prototype" to be able to add parameter when initialize Bean
    ChatApplication chatApplication(ArrayList<MessageService> messageServiceArrayList) {
        return new ChatApplication(messageServiceArrayList);
    }

    // use ComponentScan for AppConfig class to find FacebookService bean instead of creating bean here
//    @Bean
//    // use @Scope here to specify the scope of FacebookService to prototype when config with annotation
//    @Scope("prototype")
//    MessageService facebookService() {
//        return new FacebookService();
//    }

    // use ComponentScan for AppConfig class to find SMSService bean instead of creating bean here
//    @Bean
//    MessageService smsService() {
//        return new SMSService();
//    }

    @Bean
    MessageService hangoutService() {
        return new HangoutService();
    }
}
