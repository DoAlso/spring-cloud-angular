package com.cloud.sample.abstractfactory;

import com.cloud.sample.bean.Cricle;
import com.cloud.sample.bean.Shape;

public class CircleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Cricle();
    }
}
