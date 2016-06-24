package moaastar;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    
    private final Matriz valor;
    private final Integer numeroMovimentos;
    private final Estado pai;

    public Estado(Matriz valor, Integer numeroMovimentos, Estado pai) {
        this.valor = valor;
        this.numeroMovimentos = numeroMovimentos;
        this.pai = pai;
    }
    
    public List<Estado> geraFilhos (){
        List<Estado> filhos = new ArrayList<>();

        Integer[] indexes = this.valor.returnIndexFromValue(0);
        Integer i = indexes[0];
        Integer j = indexes[0];
        if(i != 0){
            Integer value = this.valor.getValores()[(4 * (i- 1)) + (j)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i - 1, j, value);
            filhos.add(new Estado(m , this.numeroMovimentos + 1, this));
        }
        if(i != 3){
            Integer value = this.valor.getValores()[(4 * (i + 1)) + (j)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i + 1, j, value);
            filhos.add(new Estado(m , this.numeroMovimentos + 1, this));
        }
        if(j != 0){
            Integer value = this.valor.getValores()[(4 * i) + (j - 1)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i, j - 1, value);
            filhos.add(new Estado(m , this.numeroMovimentos + 1, this));
        }
        if(j != 3){
            Integer value = this.valor.getValores()[(4 * i) + (j + 1)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i, j + 1, value);
            filhos.add(new Estado(m , this.numeroMovimentos + 1, this));
        }
        return filhos;
    }
    
    public Integer fN(){
        return this.numeroMovimentos + Heuristica.h1(this.valor);
    }
    
    public Boolean isFinal(){
        return true;
    }
    
    public Matriz getValor() {
        return valor;
    }

    public Integer getNumeroMovimentos() {
        return numeroMovimentos;
    }

    public Estado getPai() {
        return pai;
    }
}
