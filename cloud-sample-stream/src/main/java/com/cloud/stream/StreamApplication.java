package com.cloud.stream;

import com.cloud.stream.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Hello world!
 * @author doalso
 */
@SpringCloudApplication
@EnableBinding(Sink.class)
public class StreamApplication {
    public static void main( String[] args ) {
        SpringApplication.run(StreamApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void handle(Person person){
        System.out.println("收到：" + person);
    }

}
