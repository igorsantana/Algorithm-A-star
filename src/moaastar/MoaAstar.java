
package moaastar;

import java.util.Scanner;

public class MoaAstar {

    public static void main(String[] args) {
        
        System.out.println("Digite o estado inicial da matriz");
        
        Scanner scan = new Scanner(System.in);
        
        String[] rawData = scan.nextLine().split(" ");
        
        scan.close();
        
        Matriz initialMatrix = new Matriz(rawData);
              
        System.out.println(Heuristica.h1(initialMatrix));
        
    }
}
