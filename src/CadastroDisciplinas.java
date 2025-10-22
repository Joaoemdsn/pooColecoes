import java.util.LinkedHashSet;
import java.util.Set;

public class CadastroDisciplinas {
    private Set<Disciplina> disciplinas;

    public CadastroDisciplinas(){
        this.disciplinas = new LinkedHashSet<>();
    }

    public boolean adicionarDisciplina(Disciplina d){
        if (d==null){
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }

        boolean adicionada = disciplinas.add(d);

        if (adicionada){
            System.out.println("Disciplina adicionada: " + d.getNome());
        } else {
        System.out.println("Disciplina duplicada ignorada: " + d.getCodigo());
    }

    return adicionada;
    }

    public boolean verificarDisciplina(String codigo) {
        for(Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean removerDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)){
                disciplinas.remove(d);
                System.out.println("Disciplina removida: " + d.getNome());
                return true;
            }
        }

        System.out.println("Disciplina não encontrada!" + codigo);
        return false;
    }

    public Set<Disciplina> obterTodasDisciplinas(){
        return new LinkedHashSet<>(disciplinas);
    }

    public Disciplina buscaPorCodigo(String codigo){
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)){
                return d;
            }
        }
        return null;
    }

    public void exibirTodasAsDisciplinas(){
        System.out.println("\n=== LISTA DE DISCIPLINAS ===");
            if (disciplinas.isEmpty()) {
                System.out.println("Nenhuma disciplina cadastrada");
            } else {
                int contador = 1;
                for (Disciplina d : disciplinas) {
                    System.out.println(contador + ". " + d);
                    contador++;
                }
            }
            System.out.println("Total: " + disciplinas.size() + " disciplinas\n");
    }
}