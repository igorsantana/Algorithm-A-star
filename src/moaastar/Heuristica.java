package moaastar;


public class Heuristica {
    
    static final Integer[][] estadoFinal = {{1, 12, 11, 10},
                                            {2, 13, 00, 9 },
                                            {3, 14, 15, 8 }, 
                                            {4, 5 , 6 , 7 }};
    
    public static final Integer h1(Matriz m){
        Integer[][] matriz = m.getValores();
        Integer count = 0;
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(matriz[i][j] != estadoFinal[i][j]){
                    count++;
                }
            }
            
        }
        return count;
    }
    
    
    
    
    
    
    
    
    
    
    
}
