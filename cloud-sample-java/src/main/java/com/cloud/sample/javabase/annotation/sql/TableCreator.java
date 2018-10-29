package com.cloud.sample.javabase.annotation.sql;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TableCreator
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/29 13:29
 */
public class TableCreator {

    public static void main(String[] args) throws Exception{
        if(args.length < 1){
            System.out.println("arguments：annotated classes");
            System.exit(0);
        }

        for(String className:args){
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getDeclaredAnnotation(DBTable.class);
            if(dbTable == null){
                System.out.println("No DBTable annotations in class "+className);
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for(Field field:cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length < 1){
                    continue;
                }
                if(anns[0] instanceof SQLInteger){
                    SQLInteger sInt = (SQLInteger)anns[0];
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT"+ getConstraints(sInt.constraints()));
                }
                if(anns[0] instanceof SQLString){
                    SQLString sStr = (SQLString)anns[0];
                    if(sStr.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sStr.name();
                    }
                    columnDefs.add(columnName + " VARCHAR("+ sStr.value()+")" + getConstraints(sStr.constraints()));
                }
            }
            StringBuilder createCommand = new StringBuilder("CREATE TABLE")
                    .append(tableName)
                    .append("(");
            for (String columnDef:columnDefs){
                createCommand.append("\n  "+columnDef + ",");
            }
            String tableCreate = createCommand.substring(createCommand.length() - 1) +");";
            System.out.println("Table Creation SQL for "+ className +" is:\n"+tableCreate);
        }

    }


    private static String getConstraints(Constraints constraints){
        String cons = "";
        if(!constraints.allowNull()){
            cons += " NOT NULL";
        }
        if(constraints.primaryKey()){
            cons += " PRIMARY KEY";
        }
        if(constraints.unique()){
            cons += " UNIQUE";
        }
        return cons;
    }
}
