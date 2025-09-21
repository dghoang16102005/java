/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Duong Hoang
 */
public class BubbleSort {
    private int[] array;


    
    public void displArray(){
        System.out.println("Display Array: ");
        for(int i =0; i<array.length;i++){
            if(i != array.length -1) System.out.print(array[i] +" ,");
            else System.out.println(array[i]);
            
        }
        System.out.println("End. ");
    }
    
    public void insertionSort(){
      
       
        for(int i = 1; i < array.length  ;i++){
            int key = array[i];
            int j = i -1;
           while(j>=0 && array[j] > key ){
                        array[j+1] = array[j];
                        j= j-1;
               
                }
           array[j+1]=key;
            }
            
    }
    
    public void bubbleSort(){
        int temp; 
        for(int i =0; i< array.length -1; i++){
            for(int nextI = i+1; nextI<array.length; nextI ++){
                if(array[i] > array[nextI] ){
                    temp = array[nextI];
                    array[nextI] = array[i];
                    array[i]= temp;
                }
            }
        }
    }
    
    public void selectionSort(){
        int temp;
        
        for(int i = 0; i< array.length;i++){
            int min = i;
            for(int nextI = i; nextI< array.length; nextI++){
                if(array[nextI] < array[min]) min = nextI;
            }
            
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
        
        
    
    
        public static int getInteger(String msg, int min, int max) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String inputInt = scan.nextLine().trim();
            try {
                int convertInt = Integer.parseInt(inputInt);
                
                if(convertInt < min || convertInt > max){
                    System.out.println("Plase value input only from " + min +" to " + max);
                    
                }else{
                    return convertInt;
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Vui lòng nhập lại!");
            }
        }
    }

        
public void randomInt(){
    Random randomInt = new Random();
    for(int i =0; i<array.length;i++){
        array[i]= randomInt.nextInt(9);
    }
    
    
}
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BubbleSort arrayNew = new BubbleSort();
        int size = BubbleSort.getInteger("Input Number of array: ", 1, Integer.MAX_VALUE);
        arrayNew.array = new int[size];
        arrayNew.randomInt();
        arrayNew.displArray();
        arrayNew.selectionSort();
        arrayNew.displArray();
        // TODO code application logic here
    }
    
}
