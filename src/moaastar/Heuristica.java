package moaastar;

import java.util.Objects;

public class Heuristica {
    
    private static String[] rawData = { "1", "12", "11", "10" ,
                                        "2", "13", "0", "9",
                                        "3", "14", "15", "8",
                                        "4", "5", "6", "7" };
    static final Matriz estadoFinal = new Matriz(rawData);
    
    public static final Boolean isFinal(Estado e){
        return true;
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
        Integer count = 0;
        Integer[][] caminho = { {0,0}, {1,0}, {2,0}, {3,0}, 
                                {3,1}, {3,2}, {3,3}, {2,3},
                                {1,3}, {0,3}, {0,2}, {0,1},
                                {1,1}, {2,1}, {2,2}, {1,2}
                                };
        
        for (Integer[] passo : caminho) {
            if(Objects.equals(m.getIndexValue(passo[0], passo[1]), estadoFinal.getIndexValue(passo[0], passo[1]))){
                count = 0;
            } else {
                count++;
            }
        }
        return count;
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
    
}
