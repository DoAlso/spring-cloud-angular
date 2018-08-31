package com.cloud.sample.abstractfactory;

import com.cloud.sample.bean.Rectangle;
import com.cloud.sample.bean.Shape;

public class RectangleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
