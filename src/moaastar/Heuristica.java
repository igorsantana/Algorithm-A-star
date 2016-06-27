package moaastar;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Heuristica {
    
    private static final String[] rawData = { "1", "12", "11", "10" ,
                                        "2", "13", "0", "9",
                                        "3", "14", "15", "8",
                                        "4", "5", "6", "7" };
    
    public  static final Matriz estadoFinal = new Matriz(rawData);
    
    private static final Integer[][] caminho = { 
                                                    {0,0}, {1,0}, {2,0}, {3,0}, 
                                                    {3,1}, {3,2}, {3,3}, {2,3},
                                                    {1,3}, {0,3}, {0,2}, {0,1},
                                                    {1,1}, {2,1}, {2,2}, {1,2}
                                                };
    
    public static final Boolean isFinal(Estado e){
        return Arrays.equals(estadoFinal.getValores(), e.getValor().getValores());
    }
    
    public static final Integer h1(Matriz m){
        Integer count = 0;
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(!Objects.equals(estadoFinal.getIndexValue(i, j), m.getIndexValue(i, j))){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static final Integer h2(Matriz m){
        Integer ocorrencias = 0;
        for (int k = 0; k < caminho.length - 1; k++) {
            Integer actualValue = m.getIndexValue(caminho[k][0], caminho[k][1]);
            Integer nextValue = m.getIndexValue(caminho[k + 1][0], caminho[k + 1][1]);
            if(nextValue != (actualValue + 1) && actualValue != 0 || (actualValue == 15 && nextValue != 0)){
                ocorrencias++;
            }
        }
        return ocorrencias;
    }
    
    public static final Integer h3(Matriz m){
        Integer distanciaRetangular = 0;
        Integer[] results = {0,0};
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(!Objects.equals(estadoFinal.getIndexValue(i, j), m.getIndexValue(i, j))){
                    results = estadoFinal.returnIndexFromValue(m.getIndexValue(i, j));
                    distanciaRetangular += Math.abs(results[0] - i) + Math.abs(results[1] - j);
                }
            }
        }
        return distanciaRetangular;
    }
    
    public static final Integer h4(Matriz m){
        Double r1 = 0.2 * h1(m);
        Double r2 = 0.0 * h2(m);
        Double r3 = 0.8 * h3(m);
        Double result = (r1 + r2 + r3);
        return result.intValue();
    }
    
    public static final Integer h5(Matriz m){
        return Math.max(Math.max(h1(m), h2(m)), h3(m));
    }
    
}
