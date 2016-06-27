package moaastar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estado {
    
    private final Matriz valor;
    private final Integer movimentos;
    private final Estado pai;
    private final String hash;

    public Estado(Matriz valor, Integer numeroMovimentos, Estado pai, String hash) {
        this.hash =  hash;
        this.valor = valor;
        this.movimentos = numeroMovimentos;
        this.pai = pai;
    }
    
    public List<Estado> geraFilhos (){
        List<Estado> filhos = new ArrayList<>();

        Integer[] indexes = this.valor.returnIndexFromValue(0);
        Integer i = indexes[0];
        Integer j = indexes[1];
        
        if(i != 0){
            Integer value = this.valor.getValores()[(4 * (i - 1)) + (j)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i - 1, j, value);
            filhos.add(new Estado(m , this.movimentos + 1, this, (this.hash + filhos.size())));
        }
        if(i != 3){
            Integer value = this.valor.getValores()[(4 * (i + 1)) + (j)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i + 1, j, value);
            filhos.add(new Estado(m , this.movimentos + 1, this, (this.hash + filhos.size())));
        }
        if(j != 0){
            Integer value = this.valor.getValores()[(4 * i) + (j - 1)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i, j - 1, value);
            filhos.add(new Estado(m , this.movimentos + 1, this, (this.hash + filhos.size())));
        }
        if(j != 3){
            Integer value = this.valor.getValores()[(4 * i) + (j + 1)];
            Matriz m = this.valor.criaMatrizPermutada(i, j, i, j + 1, value);
            filhos.add(new Estado(m , this.movimentos + 1, this, (this.hash + filhos.size())));
        }
        return filhos;
    }
    
    public Integer fN(Integer which){
        switch(which){
            case 1:
                return this.movimentos + Heuristica.h1(this.valor);
            case 2:
                return this.movimentos + Heuristica.h2(this.valor);
            case 3:
                return this.movimentos + Heuristica.h3(this.valor);
            case 4:
                return this.movimentos + Heuristica.h4(this.valor);
            case 5:
                return this.movimentos + Heuristica.h5(this.valor);
        }  
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.valor);
        hash = 83 * hash + Objects.hashCode(this.movimentos);
        hash = 83 * hash + Objects.hashCode(this.pai);
        hash = 83 * hash + Objects.hashCode(this.hash);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.hash, other.hash)) {
            return false;
        }
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    

    public Matriz getValor() {
        return valor;
    }

    public Integer getMovimentos() {
        return movimentos;
    }

    public Estado getPai() {
        return pai;
    }

    public String getHash() {
        return hash;
    }
    
    
}
