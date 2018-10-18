package com.cloud.sample.visitor;

/**
 * @ClassName MouseVisitor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:51
 */
public interface MouseVisitor extends ComputerPartvisitor{

    void visit(Mouse mouse);
}
