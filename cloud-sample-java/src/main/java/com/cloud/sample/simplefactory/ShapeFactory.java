package com.cloud.sample.simplefactory;

import com.cloud.sample.bean.Cricle;
import com.cloud.sample.bean.Rectangle;
import com.cloud.sample.bean.Shape;
import com.cloud.sample.bean.Square;

/**
 * @author doalso
 * 这是一个简单工厂模式的示例
 * 简单工厂模式又称为静态工厂
 * 放法
 *
 * 简单工厂模式包含如下角色
 *
 * Factory:工厂角色
 * 工厂角色负责实现创建所有实例的内部逻辑
 *
 * Product:抽象产品角色
 *  抽象产品角色是所创建的所有对象的父类，负责描述所有的公共接口
 *
 * ConcreteProduct:具体产品角色
 * 具体产品是创建的目标，所有创建的对象
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Cricle();
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
