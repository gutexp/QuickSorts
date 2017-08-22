/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Gute
 */
public class SelectionInsertionSort {

     public static void startArray(int[] ar){ //dois métodos para geração de um array de inteiros randomicos
        for(int j = 0; j < ar.length; j++)
            ar[j] = randomArray();
    }
    
    private static int randomArray(){
        Random rand = new Random();
        return rand.nextInt(5000);
    }
    
    public static void main(String[] args) {
        int[] ar= new int[1000]; //array do selection
        int[] ar2= new int[1000]; //array do insertion
        
        startArray(ar); //randomizando ambos vetores
        startArray(ar2);
        
        String op = null;
        int i  , j , k = 0 , buff,z;
        i = ar[0];
        boolean al = true;
        
        JOptionPane.showInputDialog("S para selection sort I para insertion sort",op);
        
        //Selection Sort
        if(op =="S"){
           while(k < 999){
            for(j=k; j< ar.length; j++){ //percorre todo o array
                if(i > ar[j]){  //caso i seja maior que o número sendo analisado do array no indice j
                    buff = i;
                    i = ar[j];
                    ar[j] = buff;
                }
            }
            ar[k] = i;  // Substitui
            k++;
            i = ar[k];
           }
        }
     
        
        //Insertion Sort
        if(op == "I"){
           for (i = 1; i < ar2.length; i++){
			
            int key = ar2[i];
            j = i;
			
            while ((j > 0) && (ar2[j-1] > key)){
		ar2[j] = ar2[j-1];
		j -= 1;
            }
            ar2[j] = key;
            } 
        }
        
        
        
        
    }
    
}
