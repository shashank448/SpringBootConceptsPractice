package com.example.demo.ReflectionDemo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Object o = new Vehicle(new Motor(new Tube()), new GasChamber());
        List<String> deps = getDependency(o);
        for(String s : deps){
            System.out.println(s);
        }
        
    }
    public static List<String> getDependency(Object object){
        Class c = object.getClass();
        List<String> dependencies = new ArrayList<>();
        DFS(dependencies, c);
        return dependencies;

    }
    private static void DFS(List<String> dependencies, Class curr){
        dependencies.add(curr.getName());
        Field[] declaredFields = curr.getDeclaredFields();
        for(Field f : declaredFields){
            //System.out.println(f.getType().getClass());
            DFS(dependencies, f.getType());
        }

    }
}
