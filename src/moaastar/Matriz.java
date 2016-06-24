package moaastar;

import java.util.Objects;

public class Matriz {
    
    private Integer[] valores = new Integer [16];

    public Matriz(String[] values) {
        int i = 0;
        for (String val : values) {
            this.valores[i] = Integer.parseInt(val);
            i++;
        }
    }
    
    public Matriz(Integer[] values){
        this.valores = values;
    }
    
    public Matriz criaMatrizPermutada(Integer i,Integer j, Integer novoI, Integer novoJ, Integer valor){
        Integer [] aux = this.valores.clone();
        aux[(4*i) + j] = valor;
        aux[(4*novoI) + novoJ] = 0;
        return new Matriz(aux);
    }
    
    public Integer[]getValores() {
        return valores;
    }
    
    public Integer getIndexValue(Integer i, Integer j){
        return this.valores[(4*i) + j];
    }

    @Override
    public String toString() {
        String str = "";
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                str += "[";
                str += (this.valores[(4*i) + j] < 10 ? "0" : "");
                str += this.valores[(4*i) + j] + "] ";
            }
            str += "\n";
        }            
        return str;
    }
    
    public Integer[] returnIndexFromValue(Integer value){
        Integer Result[] = {0,0};
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.getIndexValue(i, j) == value){
                    Result[0] = i;
                    Result[1] = j;
                    break;
                }
            }
        }
        return Result;
    }
    
}
