package com.cloud.sample.javabase.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName UseCaseTracker
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/29 10:28
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for(Method method:cl.getDeclaredMethods()){
            UseCase uc = method.getDeclaredAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer i:useCases){
            System.out.println("Warning:Missing use case - "+i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PasswordUtils.class);
    }
}
