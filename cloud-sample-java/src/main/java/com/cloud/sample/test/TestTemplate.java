package com.cloud.sample.test;

public class TestTemplate {

    public static void main(String[] args) {
        SampleTemplate t1 = new SampleTemplate() {
            @Override
            protected void run() {
                System.out.println("t1 running ...");
            }
        };
        t1.println();
    }
}
