package com.cloud.sample.test;

public abstract class SampleTemplate {

    public final void println(){
        run();
    }

    protected abstract void run();
}
