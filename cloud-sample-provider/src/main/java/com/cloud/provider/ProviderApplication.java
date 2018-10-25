package com.cloud.provider;

import com.cloud.provider.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author doalso
 */
@EnableScheduling
@SpringCloudApplication
public class ProviderApplication implements ApplicationRunner {

    @Autowired
    private RabbitSender sender;

    public static void main( String[] args ) {
        SpringApplication.run(ProviderApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.send();
    }
}
