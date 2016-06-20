package moaastar;

import java.util.Objects;

public class Matriz {
    
    private Integer[][] valores;

    public Matriz(String[] values) {
        int i = 0, j = 0;
        
        Integer[][] raw = new Integer[4][4];
        for (String val : values) {
            if(j == 4){
                j = 0;
                i++;
            }
            raw[i][j] = Integer.parseInt(val);
            j++;
        }
        
        this.valores = raw;
    }
    
    public Integer[][] getValores() {
        return valores;
    }
    
    public Integer getIndexValue(Integer i, Integer j){
        return valores[i][j];
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                str += "[";
                str += (this.valores[i][j] < 10 ? "0" : "");
                str += this.valores[i][j] + "]";
            }
            str += "\n";
        }
        return str;
    }
    
    public Integer[] returnIndexFromValue(Integer value){
        
        Integer Result[] = {0,0};
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(Objects.equals(this.getIndexValue(i, j), value)){
                    Result[0] = i;
                    Result[1] = j;
                    break;
                }
            }
        }
        return Result;
    }
    
}
