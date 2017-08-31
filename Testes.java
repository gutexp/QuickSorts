/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Gustavo Da Cunha Costa Franco Fraga MAT:11218645
 */
public class Testes {
    public static void startArray(int[] ar){
        for(int j = 0; j < ar.length; j++)
            ar[j] = randomArray();
    }
    
    private static int randomArray(){
        Random rand = new Random();
        return rand.nextInt(5000);
    }
    
    public static void iniciaTeste(int[] ar){
        long tempoInicial;
        long tempoFinal;
        long tempoIni = 0;
        long tempoFim = 0;
        long tempoModa = 0;
        long tempoMediana = 0;
        long tempoRand = 0;
        
        int[] arCopia;
        Ordenacao ordenaIni = new Ordenacao(0,0,0);
        Ordenacao ordenaFim = new Ordenacao(0,0,0);
        Ordenacao ordenaModa = new Ordenacao(0,0,0);
        Ordenacao ordenaMediana = new Ordenacao(0,0,0);
        Ordenacao ordenaRand = new Ordenacao(0,0,0);
        
        
        for(int i = 0; i < 5000; i++){
            Testes.startArray(ar);
            
            arCopia = Arrays.copyOf(ar, ar.length);
            tempoInicial = System.currentTimeMillis();
            ordenaIni.quickSort(arCopia, 0, arCopia.length-1, 1);
            tempoFinal = System.currentTimeMillis();
            tempoIni = tempoIni + (tempoFinal - tempoInicial);
            
            arCopia = Arrays.copyOf(ar, ar.length);
            tempoInicial = System.currentTimeMillis();
            ordenaFim.quickSort(arCopia, 0, arCopia.length-1, 2);
            tempoFinal = System.currentTimeMillis();
            tempoFim = tempoFim + (tempoFinal - tempoInicial);
            
            arCopia = Arrays.copyOf(ar, ar.length);
            tempoInicial = System.currentTimeMillis();
            ordenaModa.quickSort(arCopia, 0, arCopia.length-1, 3);
            tempoFinal = System.currentTimeMillis();
            tempoModa = tempoModa + (tempoFinal - tempoInicial);
            
            arCopia = Arrays.copyOf(ar, ar.length);
            tempoInicial = System.currentTimeMillis();
            ordenaMediana.quickSort(arCopia, 0, arCopia.length-1, 4);
            tempoFinal = System.currentTimeMillis();
            tempoMediana = tempoMediana + (tempoFinal - tempoInicial);
            
            arCopia = Arrays.copyOf(ar, ar.length);
            tempoInicial = System.currentTimeMillis();
            ordenaRand.quickSort(arCopia, 0, arCopia.length-1, 5);
            tempoFinal = System.currentTimeMillis();
            tempoRand = tempoRand + (tempoFinal - tempoInicial);
        }
        tempoIni -= ordenaIni.getTempoNulo();
        tempoFim -= ordenaFim.getTempoNulo();
        tempoModa -= ordenaModa.getTempoNulo();
        tempoMediana -= ordenaMediana.getTempoNulo();
        tempoRand -= ordenaRand.getTempoNulo();
        
        System.out.println("\nUsando Pivô no Começo");
        System.out.println("Número de Trocas: "+ ordenaIni.getTrocas());
        System.out.println("Número de Comparações: "+ ordenaIni.getComparacao());
        System.out.println("Tempo total decorrido: "+ (tempoIni)+"ms");
        System.out.println("\n************************");
        
        System.out.println("\nUsando Pivô no Final");
        System.out.println("Número de Trocas: "+ ordenaFim.getTrocas());
        System.out.println("Número de Comparações: "+ ordenaFim.getComparacao());
        System.out.println("Tempo total decorrido: "+ (tempoFim)+"ms");
        System.out.println("\n************************");
        
        System.out.println("\nUsando Pivô da moda");
        System.out.println("Número de Trocas: "+ ordenaModa.getTrocas());
        System.out.println("Número de Comparações: "+ ordenaModa.getComparacao());
        System.out.println("Tempo total decorrido: "+ (tempoModa)+"ms");
        System.out.println("\n************************");
        
        System.out.println("\nUsando Pivô da mediana");
        System.out.println("Número de Trocas: "+ ordenaMediana.getTrocas());
        System.out.println("Número de Comparações: "+ ordenaMediana.getComparacao());
        System.out.println("Tempo total decorrido: "+ (tempoMediana)+"ms");
        System.out.println("\n************************");
        
        System.out.println("\nUsando Pivô o randomizado");
        System.out.println("Número de Trocas: "+ ordenaRand.getTrocas());
        System.out.println("Número de Comparações: "+ ordenaRand.getComparacao());
        System.out.println("Tempo total decorrido: "+ (tempoRand)+"ms");
        
    }
}
