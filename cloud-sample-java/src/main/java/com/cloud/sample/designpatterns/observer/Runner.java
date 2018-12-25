package com.cloud.sample.designpatterns.observer;

/**
 * @ClassName Runner
 * @Description 观察者模式示例代码
 * @Author Administrator
 * @DATE 2018/11/8 14:56
 */
public class Runner {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay display = new CurrentConditionDisplay(weatherData);
        CustomDisplay customDisplay = new CustomDisplay(weatherData);
        weatherData.setMeasurements(12.1,46.23,69.21);
    }
}
