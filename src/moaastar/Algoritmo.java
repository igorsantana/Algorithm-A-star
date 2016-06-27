/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moaastar;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {
    
    public static final Integer run(Estado inic, Integer which){
        List<Estado> A = new ArrayList<> (); 
        // Estados Finais
        List<Estado> T = new ArrayList<> ();         
        // Estados Fechados
        List<Estado> F = new ArrayList<> ();  
        
        A.add(inic);
        
        Integer numeroMovimentos = 0;
        
        while(!A.isEmpty() && !T.contains(A.get(0))){
            Estado menor = A
                            .stream()
                            .reduce(A.get(0),(ac, v) -> (v.fN(which) < ac.fN(which)) ? v : ac);
            
            if(Heuristica.isFinal(menor)){
                numeroMovimentos = menor.getNumeroMovimentos();
                break;
            }
            
            A.remove(menor);

            F.add(menor);
            List<Estado> filhos = menor.geraFilhos();
            
            for (Estado filho : filhos) {
                filhos
                    .stream()
                    .filter(f -> f.getNumeroMovimentos() > filho.getNumeroMovimentos())
                    .forEach(e -> A.remove(e));
                
                if(!A.contains(filho) && !F.contains(filho)){
                    A.add(filho);
                }
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
