package com.cloud.sample.designpatterns.abstractfactory;

/**
 * @ClassName LeKouCupFactroy
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/16 17:42
 */
public class LeKouCupFactroy implements CupFactory {

    @Override
    public Cup createCup() {
        return new LeKouCup();
    }
}
