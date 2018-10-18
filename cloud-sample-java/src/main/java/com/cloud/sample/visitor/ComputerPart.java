package com.cloud.sample.visitor;

/**
 * @ClassName ComputerPart
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/17 10:41
 */
public interface ComputerPart {

    void accept(ComputerPartvisitor computerpartvisitor);
}
