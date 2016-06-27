
package moaastar;

import java.util.Scanner;

public class MoaAstar {

    public static void main(String[] args) {
        
//      Submissão para o run.codes
//        String[] rawData;
//        try (Scanner scan = new Scanner(System.in)) {
//            rawData = scan.nextLine().split(" ");
//        }
//        final long startTime = System.nanoTime();
//        Matriz m = new Matriz(rawData);
//        Integer num = Algoritmo.run(new Estado(m, 0, null, "0."), 3);
//        final double duration1 = System.nanoTime() - startTime;
//        System.out.println("Tempo de execução: " + String.format("%.5f", (duration1 / 1000000000)) + " segundos.");
//        System.out.println(num);
        
//      Testes

        Integer[] heuristicas = {1, 2, 3, 4, 5};
        Integer qtdTestes = 1;
//        String[] dadosTeste01 = {"1", "12", "11", "10", "0", "13", "15", "9", "2", "14", "6", "8", "3", "4", "5", "7"};
//        Matriz m1 = new Matriz(dadosTeste01);
//          String[] dadosTeste02 = {"12", "11", "10", "9", "1", "13", "15", "0", "2", "14", "6", "8", "3", "4", "5", "7"};
//          Matriz m2 = new Matriz(dadosTeste02);
//        String[] dadosTeste03 = {"1", "12", "0", "11", "2", "13", "15", "10", "3", "14", "6", "9", "4", "5", "7", "8"};
//        Matriz m3 = new Matriz(dadosTeste03);
//        String[] dadosTeste04 = {"2", "1", "12", "11", "3", "0", "15", "10", "4", "13", "6", "9", "5", "14", "7", "8"};
//        Matriz m4 = new Matriz(dadosTeste04);
        String[] dadosTeste05 = {"2", "1", "12", "11", "3", "15", "6", "10", "4", "0", "7", "9", "5", "13", "14", "8"};
        Matriz m5 = new Matriz(dadosTeste05);
//          
//        System.out.println(m1.toString());
//        Algoritmo.executaNVezes(qtdTestes, dadosTeste01 , heuristicas);
//        System.out.println(m2.toString());
//        Algoritmo.executaNVezes(qtdTestes, dadosTeste02 , heuristicas);
//        System.out.println(m3.toString());
//        Algoritmo.executaNVezes(qtdTestes, dadosTeste03 , heuristicas);
//        System.out.println(m4.toString());
//        Algoritmo.executaNVezes(qtdTestes, dadosTeste04 , heuristicas);
        System.out.println(m5.toString());
        Algoritmo.executaNVezes(qtdTestes, dadosTeste05 , heuristicas);

    }
}
