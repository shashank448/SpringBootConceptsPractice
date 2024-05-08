package com.example.demo.AnnotaionCreation;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    @MyFirstAnnotation(message = "Hello World")
    public void test_scenario1(){

    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Method[] declaredMethods = Main.class.getDeclaredMethods();
        for(Method m : declaredMethods){
            if(m.isAnnotationPresent(MyFirstAnnotation.class)){
                System.out.println(m.getName()+ " "+m.getAnnotation(MyFirstAnnotation.class).message());
            }
        }

        // Testing the MyJunit
        MyJunit.executeTests(Arrays.asList(BubbleSortTest.class));

    }
}
