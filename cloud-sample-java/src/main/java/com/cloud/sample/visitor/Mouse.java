package com.cloud.sample.visitor;

/**
 * @ClassName Mouse
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:07
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartvisitor computerpartvisitor) {
        if(computerpartvisitor instanceof MouseVisitor){
            ((MouseVisitor) computerpartvisitor).visit(this);
        }
    }
}
