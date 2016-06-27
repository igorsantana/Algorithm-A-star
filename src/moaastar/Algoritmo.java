/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moaastar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algoritmo {
   
    
    public static final Integer run(Estado inic, Integer which){
        List<Estado> A = new ArrayList<> (); 
        List<Estado> T = new ArrayList<> ();         
        List<Estado> F = new ArrayList<> ();  
        
        A.add(inic);
        Integer numeroMovimentos = 0;
        
        while(!A.isEmpty() && !T.contains(A.get(0))){
            Estado menor = A.get(0);
            
            for (Estado estado : A) menor = estado.fN(which) < menor.fN(which) ? estado : menor;
            
            if(Heuristica.isFinal(menor)){
                numeroMovimentos = menor.getMovimentos();
                break;
            }
            
            A.remove(menor);
            F.add(menor);
            
            List<Estado> filhos = menor.geraFilhos();
            
            for (Estado filho : filhos) {
                List<Estado> toRemove = new ArrayList<>();
                for (Estado e : A){
                    if(e.getValor().equals(filho.getValor()) && e.getMovimentos() > filho.getMovimentos()){
                        toRemove.add(e);
                    }
                } 
                for(Estado e : toRemove) A.remove(e);
                if(!A.contains(filho) && !F.contains(filho)) A.add(filho);
            }
        }
        return numeroMovimentos;
    }
    
    public static final void executaNVezes(Integer n, String[] data, Integer[] which ){
        for (Integer integer : which) {
            System.out.println("---------- Heuristica 0" + integer + " ----------");
            final long startTime = System.nanoTime();
            Integer numeroMovimentos = 0;
            for (int i = 0; i <= n; i++) {
                numeroMovimentos = Algoritmo.run(new Estado(new Matriz(data), 0, null, "0."), integer);
            }
            final double duration1 = System.nanoTime() - startTime;
            System.out.println("Tempo médio de cada execução: " + String.format("%.5f", ((duration1 / 1000000000) / n)) + " segundos.");
            System.out.println(numeroMovimentos == 0 ? "Não foi possível encontrar." : ("Número de movimentos: " + numeroMovimentos));
            System.out.println("---------- Heuristica 0" + integer + " ----------\n"); 
        }
        
    }
        
}
