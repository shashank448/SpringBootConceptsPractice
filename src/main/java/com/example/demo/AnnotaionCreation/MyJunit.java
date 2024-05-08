package com.example.demo.AnnotaionCreation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyJunit {

    private static Throwable exception;

    public static void executeTests(List<Class> classesToTest) throws InstantiationException, IllegalAccessException {
        for(Class classToTest : classesToTest){
            Method[] methods = classToTest.getDeclaredMethods();
            Object objUnderTest  = classToTest.newInstance();
            initialise(objUnderTest, methods); // this method will check what are the methods which contains init Annotation
            // and just invoke them
            for(Method method : methods){

                if(method.isAnnotationPresent(TestLatency.class)){
                    TestLatency testLatencyAnnotation = method.getAnnotation(TestLatency.class);
                    long desiredLatency = testLatencyAnnotation.latencyInMillis();
                    long start = System.currentTimeMillis(), end;
                    try {
                        method.invoke(objUnderTest);
                    } catch (Exception e) {
                        exception = e.getCause();
                    }
                    end = System.currentTimeMillis();
                    if(end-start<=desiredLatency){
                        if(exception!=null){
                            if(!method.isAnnotationPresent(ExpectedErrorMessage.class)){
                                System.out.println(method.getName()+" failed due to ");
                                exception.printStackTrace();
                            }else{
                                String expected = method.getAnnotation(ExpectedErrorMessage.class).errorMessage();
                                if(!exception.getMessage().equals(expected)){
                                    System.out.println(method.getName() + " failed due to error message mismatch");
                                }
                            }
                        }
                        System.out.println(method.getName() + " has successfully Passed");
                    }else {
                        System.out.println(method.getName()+" failed, desired latency "+desiredLatency+
                                " actual Latency "+(end-start));
                    }
                }
            }
        }

    }

    private static void initialise(Object objUnderTest, Method[] methods) {
        for(Method method : methods){
            if(method.isAnnotationPresent(Init.class)){
                try {
                    method.invoke(objUnderTest);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
