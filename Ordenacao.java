/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;
import java.util.Random;
/**
 *
 * @author Gustavo Da Cunha Costa Franco Fraga MAT:11218645
 */
public class Ordenacao {
        
    private long comparacao;
    private long trocas;
    private long tempoNulo;
    
    Ordenacao(long trocas , long tempoNulo ,long comparacao){
        this.comparacao = comparacao;
        this.trocas = trocas;
        this.tempoNulo = tempoNulo;
        
    }
    
    private static void bubbleSort(int[] arrayInt){
        boolean troca = false;
        int temp = 0;
        
        for(int i = 0; i < arrayInt.length; i++){
            for(int j = 1; j < arrayInt.length - 1; j++){
                if(arrayInt[j] > arrayInt[j+1]){
                    temp = arrayInt[j];
                    arrayInt[j] = arrayInt[j+1];
                    arrayInt[j+1] = temp;
                }
                if(!troca)
                    break;
            }
        }
    }
    
    public void quickSort(int[] arrayInt, int inicio, int fim, int modo) {
        long tempComeco = 0;
        
        tempComeco = System.currentTimeMillis();
        
        int pivo = 0;
        int i = 0;
        int j = 0;
        i = inicio;
        j = fim;
        int y = 0;
        long tempo = 0;
        long trocas = 0;
        long end = 0;
        
        if(modo == 1){
            pivo = arrayInt[inicio];
        }
        
        if(modo == 2){
            pivo = arrayInt[fim];
        }
        
        if(modo == 3){
             int moda[] = new int[5001];
             pivo = arrayInt[inicio];

             for (int k = inicio; k <= fim; k++) {
                int aux = arrayInt[k];
                moda[aux] += 1;
             }

             for (int k = 0; k < moda.length - 1; k++) {
                if (pivo < moda[k]) {
                    pivo = k;
                }
             }
        }
        
        if(modo == 4){
            Random rand = new Random();
            int[] mediana = new int[5];
            for (int c = 0; c < 5; c++) {
                mediana[c] = arrayInt[((rand.nextInt(fim - inicio)) + inicio)];
            }
            bubbleSort(mediana);
            pivo = mediana[2];
        }
        
        if(modo == 5){
            Random rand2 = new Random();
            pivo = arrayInt[((rand2.nextInt(fim - inicio)) + inicio)];
        }
        
        end = System.currentTimeMillis();
        tempoNulo += (end - tempComeco);
        
        while(i <= j){
            this.comparacao++;
            while (arrayInt[i] < pivo && i < fim){ 
                i++;
            }
            this.comparacao++;
            while (arrayInt[j] > pivo && j > inicio){
                j--;
            }
            this.comparacao++;
            if(i <= j){
                this.trocas++;
                y = arrayInt[i];
                arrayInt[i] = arrayInt[j];
                arrayInt[j] = y;
                i++;
                j--;
            }
            this.comparacao++;
        }
        if (j > inicio){
            quickSort(arrayInt, inicio, j, modo);
        }
        this.comparacao++;
        if (i < fim){
            quickSort(arrayInt, i, fim, modo);        
        }
        this.comparacao++;
    }

    public long getTrocas() {
        return trocas;
    }

    public void setTrocas(long permutas) {
        this.trocas = trocas;
    }

    public long getTempoNulo() {
        return tempoNulo;
    }

    public void setTempoNulo(long tempoNulo) {
        this.tempoNulo = tempoNulo;
    }
    public void setComparacao(long comparacao){
        this.comparacao = comparacao;
    }
    public long getComparacao(){
        return comparacao;
    }
}
