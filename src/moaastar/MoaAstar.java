
package moaastar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.Global;

public class MoaAstar {

    public static void main(String[] args) {
        
        System.out.println("Digite o estado inicial da matriz");
        
        String[] rawData;
        try (Scanner scan = new Scanner(System.in)) {
            rawData = scan.nextLine().split(" ");
        }
        
        Estado estadoInicial = new Estado(new Matriz(rawData), 0, null);
        
        List<Estado> A = new ArrayList<> (); 
        List<Estado> F = new ArrayList<> ();         
        
        A.add(estadoInicial);
        
        Estado minorFn = A.stream()
                            .reduce(estadoInicial, (acumulador, valor) -> {
                                return (valor.fN() < acumulador.fN()) ? valor : acumulador;
                            });
                            
        
        while(!A.isEmpty() && !F.contains(minorFn)){
            Estado removerDeAeAdicioanrEmF = A
                                    .stream()
                                    .reduce(A.get(0),(acumulador, valor) -> {
                                        return (valor.fN() < acumulador.fN()) ? valor : acumulador;
                                    });
            A.remove(removerDeAeAdicioanrEmF);
            F.add(removerDeAeAdicioanrEmF);
        }
        
    }
}
