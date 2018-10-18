package com.cloud.sample.abstractfactory;

/**
 * @ClassName FaceCupFactory
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 9:11
 */
public class FaceCupFactory implements CupFactory {

    @Override
    public Cup createCup() {
        return new FaceCup();
    }
}
