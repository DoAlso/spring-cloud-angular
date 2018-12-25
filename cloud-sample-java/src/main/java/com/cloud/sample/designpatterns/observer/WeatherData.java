package com.cloud.sample.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @ClassName WeatherData
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/8 14:40
 */
public class WeatherData extends Observable implements Subject {
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private List<Observer> observers = new ArrayList<>();

    public void measurementsChanged(){
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.update(temperature,humidity,pressure);
        }
    }

    public void setMeasurements(Double temperature,Double humidity,Double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
