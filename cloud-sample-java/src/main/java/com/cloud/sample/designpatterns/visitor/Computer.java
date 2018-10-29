package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:07
 */
public class Computer implements ComputerPart {

    @Override
    public void accept(ComputerPartvisitor computerpartvisitor) {
        if(computerpartvisitor instanceof ComputerVisitor){
            ((ComputerVisitor) computerpartvisitor).visit(this);
        }
    }


    public void calculate(){
        System.out.println("I can perform some computing tasks");
    }

}
