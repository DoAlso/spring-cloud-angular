package com.cloud.sample.abstractfactory;

/**
 * @ClassName FuGuangCupFactory
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/16 17:50
 */
public class FuGuangCupFactory  implements CupFactory{

    @Override
    public Cup createCup() {
        return new FuGuangCup();
    }
}
