package com.cloud.sample.designpatterns.visitor;

/**
 * @ClassName Monitor
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:08
 */
public class Monitor implements ComputerPart{

    @Override
    public void accept(ComputerPartvisitor computerpartvisitor) {
        if(computerpartvisitor instanceof MonitorVisitor){
            ((MonitorVisitor) computerpartvisitor).visit(this);
        }
    }

}
