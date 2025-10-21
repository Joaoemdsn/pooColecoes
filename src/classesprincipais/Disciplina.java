package classesprincipais;

public class Disciplina {
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

}
