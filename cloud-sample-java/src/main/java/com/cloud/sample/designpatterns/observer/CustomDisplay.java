package com.cloud.sample.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName CustomDisplay
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/8 14:54
 */
public class CustomDisplay implements Observer,DisplayElement {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomDisplay.class);

    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Subject subject;

    public CustomDisplay(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        LOGGER.info("ClassName:{}[Temperature:{},Humidity:{},Pressure:{}]",this.getClass().getName(),temperature,humidity,pressure);
    }

    @Override
    public void update(Double temperature, Double humidity, Double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
