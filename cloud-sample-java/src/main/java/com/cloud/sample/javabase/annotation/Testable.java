package com.cloud.sample.javabase.annotation;

/**
 * @ClassName Testable
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/29 10:02
 */
public class Testable {

    public void execute(){
        System.out.println("Executing......");
    }

    @Test
    void TestExecute(){
        execute();
    }
}
