package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName keyboard
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:07
 */
public class keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartvisitor computerpartvisitor) {
        if(computerpartvisitor instanceof KeyBoardVisotor){
            ((KeyBoardVisotor) computerpartvisitor).visit(this);
        }
    }
}
