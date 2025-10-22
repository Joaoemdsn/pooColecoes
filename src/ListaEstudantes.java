import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaEstudantes{
    private List<Estudantes> estudantes;

    public ListaEstudantes(){
        this.estudantes = new ArrayList<>();
    }

    public void adicionarEstudante(Estudantes e){
        if (e==null) {
            throw new IllegalArgumentException("Estudante nao pode ser nulo");
        }
        estudantes.add(e);
        System.out.println("Estudante adicionado: " + e.getNome());
    }

    public boolean removerEstudanteporID(int id){
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getId()==id){
                Estudantes removido = estudantes.remove(i);
                System.out.println("Estudante removido: " + removido.getNome());
                return true;
            }
        }
        System.out.println("Estudante com ID: " + id + " não encontrado");
        return false;
    }

    public Estudantes obterEstudantePorIndice(int indice){
        if (indice < 0 || indice >= estudantes.size()){
            throw new IndexOutOfBoundsException("Indice inválido: " + indice);
        }
        return estudantes.get(indice);
    }

    public void ordenarEstudantesPorNome(){
        Collections.sort(estudantes, new Comparator<Estudantes>() {
            @Override
            public int compare(Estudantes e1, Estudantes e2){
                return e1.getNome().compareToIgnoreCase(e2.getNome());
            }
        });
        System.out.println("Lista Ordenada por nome");
    
    }

    public List<Estudantes> obterTodos(){
        return new ArrayList<>(estudantes);
    }

    public List<Estudantes> buscarEstudantesPorNome(String substring) {
        List<Estudantes> resultados = new ArrayList<>();
        for (Estudantes e : estudantes) {
            if (e.getNome().toLowerCase().contains(substring.toLowerCase())) {
                resultados.add(e);
            }
        }
        return resultados;
    }

    public void exibirTodos() {
        System.out.println("\n=== LISTA DE ESTUDANTES ===");
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado");
        } else {
            for (int i = 0; i < estudantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudantes.get(i));
            }
        }
        System.out.println("Total: " + estudantes.size() + " estudantes\n");
    }
}
