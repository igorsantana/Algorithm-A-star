package moaastar;

public class Estado {
    
    private Matriz valor;
    private Integer numeroMovimentos;
    private Estado pai;

    public Estado(Matriz valor, Integer numeroMovimentos, Estado pai) {
        this.valor = valor;
        this.numeroMovimentos = numeroMovimentos;
        this.pai = pai;
    }
    
    public Integer fN(){
        return this.numeroMovimentos + Heuristica.h1(valor);
    }

    public Matriz getValor() {
        return valor;
    }

    public void setValor(Matriz valor) {
        this.valor = valor;
    }

    public Integer getNumeroMovimentos() {
        return numeroMovimentos;
    }

    public void setNumeroMovimentos(Integer numeroMovimentos) {
        this.numeroMovimentos = numeroMovimentos;
    }

    public Estado getPai() {
        return pai;
    }

    public void setPai(Estado pai) {
        this.pai = pai;
    }

   

    
   
    
        
    
}
