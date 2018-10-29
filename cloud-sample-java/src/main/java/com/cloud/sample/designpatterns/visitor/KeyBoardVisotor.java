package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName KeyBoardVisotor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:51
 */
public interface KeyBoardVisotor extends ComputerPartvisitor{

    void visit(keyboard keyboard);

}
