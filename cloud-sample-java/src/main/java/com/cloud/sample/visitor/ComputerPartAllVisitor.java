package com.cloud.sample.visitor;

/**
 * @ClassName ComputerPartAllVisitor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 11:03
 */
public class ComputerPartAllVisitor implements AllVisitor {


    @Override
    public void visit(Computer computer) {
        System.out.println("I am a computer visitor");
        computer.calculate();
    }

    @Override
    public void visit(keyboard keyboard) {
        System.out.println("I am a keyboard visitor");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("I am a monitor visitor");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("I am a mouse visitor");
    }
}
