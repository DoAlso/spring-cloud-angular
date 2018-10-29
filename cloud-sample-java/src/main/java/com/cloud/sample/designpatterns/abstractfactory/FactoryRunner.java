package com.cloud.sample.designpatterns.abstractfactory;

/**
 * @ClassName FactoryRunner
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 9:12
 */
public class FactoryRunner {

    public static void main(String[] args) {
        System.out.println(getCup(new FaceCupFactory()));
    }


    public static Cup getCup(CupFactory factory){
        return factory.createCup();
    }
}
