public class Estudantes {
    private int id;
    private String nome;

    public Estudantes(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Nome: " + nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estudantes outro = (Estudantes) obj;
        return id == outro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}