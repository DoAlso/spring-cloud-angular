package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName ComputerVisitor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:50
 */
public interface ComputerVisitor  extends ComputerPartvisitor{
    void visit(Computer computer);
}
