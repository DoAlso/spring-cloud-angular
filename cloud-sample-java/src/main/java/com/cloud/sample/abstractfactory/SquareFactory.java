package com.cloud.sample.abstractfactory;

import com.cloud.sample.bean.Shape;
import com.cloud.sample.bean.Square;

public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
