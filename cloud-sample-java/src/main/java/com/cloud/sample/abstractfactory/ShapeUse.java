package com.cloud.sample.abstractfactory;

import com.cloud.sample.bean.Shape;

public class ShapeUse {

    public static Shape getShape(Factory factory){
        return factory.getShape();
    }

    public static void main(String[] args) {
        Shape circle = getShape(new CircleFactory());
        circle.draw();
        Shape rectange = getShape(new RectangleFactory());
        rectange.draw();
    }
}
