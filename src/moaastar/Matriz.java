package moaastar;

public class Matriz {
    
    private Integer[][] valores;

    public Matriz() {}
    
    public Integer[][] getValores() {
        return valores;
    }

    public void setValores(String[] values) {
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
    
}
