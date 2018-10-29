package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName MonitorVisitor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:52
 */
public interface MonitorVisitor extends ComputerPartvisitor {
    void visit(Monitor monitor);
}
