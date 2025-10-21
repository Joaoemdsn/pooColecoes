package classesprincipais;
import java.util.*;

public class HistoricoNotas {
    
    private Map<Integer, List<Matricula>> historico;
    
    public HistoricoNotas() {
        this.historico = new HashMap<>();
    }
    
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        
        if (!historico.containsKey(idEstudante)) {
            historico.put(idEstudante, new ArrayList<>());
        }
        
        List<Matricula> matriculas = historico.get(idEstudante);
        for (Matricula m : matriculas) {
            if (m.getCodigoDisciplina().equals(codigoDisciplina)) {
                System.out.println("Atualizando nota existente de " + 
                                   m.getNota() + " para " + nota);
                m.setNota(nota);
                return;
            }
        }
        
        Matricula nova = new Matricula(codigoDisciplina, nota);
        matriculas.add(nova);
        System.out.println("Matrícula adicionada: Estudante " + idEstudante + 
                           " - " + codigoDisciplina + " - Nota: " + nota);
    }

    public List<Matricula> obterMatriculas(int idEstudante) {
        List<Matricula> matriculas = historico.get(idEstudante);
        if (matriculas == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(matriculas);
    }
    
    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        List<Matricula> matriculas = historico.get(idEstudante);
        if (matriculas == null) {
            return Optional.empty();
        }
        
        for (Matricula m : matriculas) {
            if (m.getCodigoDisciplina().equals(codigoDisciplina)) {
                return Optional.of(m.getNota());
            }
        }
        
        return Optional.empty();
    }
    
    public boolean removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> matriculas = historico.get(idEstudante);
        if (matriculas == null) {
            return false;
        }
        
        for (int i = 0; i < matriculas.size(); i++) {
            if (matriculas.get(i).getCodigoDisciplina().equals(codigoDisciplina)) {
                matriculas.remove(i);
                System.out.println("Matrícula removida");
                return true;
            }
        }
        
        return false;
    }
    
    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> matriculas = historico.get(idEstudante);
        if (matriculas == null || matriculas.isEmpty()) {
            return 0.0;
        }
        
        double soma = 0;
        for (Matricula m : matriculas) {
            soma += m.getNota();
        }
        
        return soma / matriculas.size();
    }
    
    public double mediaDaDisciplina(String codigoDisciplina) {
        double soma = 0;
        int contador = 0;
        
        for (List<Matricula> matriculas : historico.values()) {
            for (Matricula m : matriculas) {
                if (m.getCodigoDisciplina().equals(codigoDisciplina)) {
                    soma += m.getNota();
                    contador++;
                }
            }
        }
        
        return contador == 0 ? 0.0 : soma / contador;
    }
 
    public List<Map.Entry<Integer, Double>> topNEstudantesPorMedia(int N) {
    
        List<Map.Entry<Integer, Double>> ranking = new ArrayList<>();
        
        for (Integer idEstudante : historico.keySet()) {
            double media = mediaDoEstudante(idEstudante);
            ranking.add(new AbstractMap.SimpleEntry<>(idEstudante, media));
        }
        
        Collections.sort(ranking, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
                return Double.compare(e2.getValue(), e1.getValue());
            }
        });

        if (N < ranking.size()) {
            return ranking.subList(0, N);
        }
        return ranking;
    }

    public void exibirHistorico(int idEstudante) {
        System.out.println("\n--- Histórico do Estudante " + idEstudante + " ---");
        List<Matricula> matriculas = obterMatriculas(idEstudante);
        
        if (matriculas.isEmpty()) {
            System.out.println("Nenhuma matrícula encontrada");
        } else {
            for (Matricula m : matriculas) {
                System.out.println("  " + m);
            }
            System.out.printf("  Média Geral: %.2f\n", mediaDoEstudante(idEstudante));
        }
    }
}