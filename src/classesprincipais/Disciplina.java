package classesprincipais;

import java.util.Objects;

public class Disciplina implements Comparable<Disciplina> {
    private String codigo;
    private String nomeDisciplina;
    
    public Disciplina(String codigo, String nomeDisciplina) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    @Override
    public String toString(){
    
        return "Disciplina[Codigo=" + codigo + ", Nome=" + nomeDisciplina + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        Disciplina outra = (Disciplina) obj; 
        
        return Objects.equals(codigo, outra.codigo);
    }
    
    @Override
    public int hashCode(){
       
       return Objects.hash(codigo);
    }

    @Override
    public int compareTo(Disciplina outra){
        
        return this.codigo.compareTo(outra.codigo);
    }
}