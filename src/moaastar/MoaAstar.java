
package moaastar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoaAstar {

    public static void main(String[] args) {
        
        System.out.println("Digite o estado inicial da matriz");
        
        String[] rawData;
        try (Scanner scan = new Scanner(System.in)) {
            rawData = scan.nextLine().split(" ");
        }
        
        Estado inic = new Estado(new Matriz(rawData), 0, null);
        // Estados Abertos
        List<Estado> A = new ArrayList<> (); 
        // Estados Finais
        List<Estado> T = new ArrayList<> ();         
        // Estados Fechados
        List<Estado> F = new ArrayList<> ();         
        A.add(inic);
        
        Estado menorInicio = A.stream()
                        .reduce(inic, (ac, v) ->  (v.fN() < ac.fN()) ? v : ac);
        Integer numeroMovimentos;
        while(!A.isEmpty() && !T.contains(menorInicio)){
            Estado menor = A
                            .stream()
                            .reduce(A.get(0),(ac, v) -> (v.fN() < ac.fN()) ? v : ac);
            if(Heuristica.isFinal(menor)){
                numeroMovimentos = menor.getNumeroMovimentos();
                break;
            }
            A.remove(menor);
            F.add(menor);
            List<Estado> filhos = menor.geraFilhos();
            for (Estado filho : filhos) {
                if(!A.contains(filho) && !F.contains(filho)){
                    A.add(filho);
                }
            }
        }
    }
}
