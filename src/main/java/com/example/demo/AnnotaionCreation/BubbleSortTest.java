package com.example.demo.AnnotaionCreation;


import java.util.Random;

// Test class for BubbleSort class
public class BubbleSortTest {
    public int[] smallArray;
    public int[] bigArray;
    public int[] emptyArray;
    @Init
    public void initialiseArrays(){
        smallArray = new int[1000];
        bigArray = new int[10000];
        Random random = new Random();
        for(int i=0;i<smallArray.length;i++)
            smallArray[i] = random.nextInt();
        for(int i=0;i<bigArray.length;i++)
            bigArray[i] = random.nextInt();
    }
    @TestLatency(latencyInMillis = 50)
    public void testingWithSmallArray(){
        BubbleSort.sort(smallArray);
    }
    @TestLatency(latencyInMillis = 190)
    public void testingWithBigArray(){
        BubbleSort.sort(bigArray);
    }
    @TestLatency(latencyInMillis = 10)
    @ExpectedErrorMessage(errorMessage = "Arrays can't be Empty")
    public void testingWithEmptyArray_1(){

        BubbleSort.sort(emptyArray);
    }
}
