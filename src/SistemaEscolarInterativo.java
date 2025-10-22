import java.util.Scanner;
import java.util.List;
import java.util.Optional;


public class SistemaEscolarInterativo {
    
    // Gerenciadores globais
    private static ListaEstudantes listaEstudantes;
    private static CadastroDisciplinas cadastroDisciplinas;
    private static HistoricoNotas historicoNotas;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        // Inicializa os gerenciadores
        listaEstudantes = new ListaEstudantes();
        cadastroDisciplinas = new CadastroDisciplinas();
        historicoNotas = new HistoricoNotas();
        
        exibirBanner();
        
        // Pergunta se quer carregar dados de exemplo
        System.out.print("Deseja carregar dados de exemplo? (S/N): ");
        String resposta = scanner.nextLine().trim().toUpperCase();
        if (resposta.equals("S") || resposta.equals("SIM")) {
            carregarDadosExemplo();
            System.out.println("\n✅ Dados de exemplo carregados com sucesso!");
            pausar();
        }
        
        // Loop principal do menu
        boolean continuar = true;
        while (continuar) {
            continuar = exibirMenuPrincipal();
        }
        
        System.out.println("\n👋 Obrigado por usar o Sistema Escolar!");
        scanner.close();
    }
    
    private static void exibirBanner() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GERENCIAMENTO ESCOLAR - POO      ║");
        System.out.println("║            VERSÃO INTERATIVA                   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
    }
    
    private static boolean exibirMenuPrincipal() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              MENU PRINCIPAL                    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("📚 GERENCIAR ESTUDANTES (List)");
        System.out.println("  1 - Adicionar estudante");
        System.out.println("  2 - Listar todos os estudantes");
        System.out.println("  3 - Buscar estudante por nome");
        System.out.println("  4 - Ordenar estudantes por nome");
        System.out.println("  5 - Remover estudante");
        System.out.println();
        System.out.println("📖 GERENCIAR DISCIPLINAS (Set)");
        System.out.println("  6 - Adicionar disciplina");
        System.out.println("  7 - Listar todas as disciplinas");
        System.out.println("  8 - Verificar se disciplina existe");
        System.out.println("  9 - Remover disciplina");
        System.out.println();
        System.out.println("📝 GERENCIAR MATRÍCULAS E NOTAS (Map)");
        System.out.println("  10 - Adicionar matrícula (nota)");
        System.out.println("  11 - Ver histórico de um estudante");
        System.out.println("  12 - Ver nota específica");
        System.out.println("  13 - Calcular média do estudante");
        System.out.println("  14 - Calcular média da disciplina");
        System.out.println("  15 - Remover matrícula");
        System.out.println();
        System.out.println("📊 RELATÓRIOS");
        System.out.println("  16 - Alunos com média ≥ 8.0");
        System.out.println("  17 - Disciplinas com média < 6.0");
        System.out.println("  18 - Top 5 estudantes");
        System.out.println("  19 - Relatório completo");
        System.out.println();
        System.out.println("  0 - SAIR");
        System.out.println();
        System.out.print("Escolha uma opção: ");
        
        int opcao = lerInteiro();
        
        switch (opcao) {
            case 1: adicionarEstudante(); break;
            case 2: listarEstudantes(); break;
            case 3: buscarEstudantePorNome(); break;
            case 4: ordenarEstudantes(); break;
            case 5: removerEstudante(); break;
            
            case 6: adicionarDisciplina(); break;
            case 7: listarDisciplinas(); break;
            case 8: verificarDisciplina(); break;
            case 9: removerDisciplina(); break;
            
            case 10: adicionarMatricula(); break;
            case 11: verHistoricoEstudante(); break;
            case 12: verNotaEspecifica(); break;
            case 13: calcularMediaEstudante(); break;
            case 14: calcularMediaDisciplina(); break;
            case 15: removerMatricula(); break;
            
            case 16: relatorioAlunosAprovados(); break;
            case 17: relatorioDisciplinasBaixas(); break;
            case 18: relatorioTopEstudantes(); break;
            case 19: relatorioCompleto(); break;
            
            case 0: 
                return false;
            
            default:
                System.out.println("\n❌ Opção inválida!");
                pausar();
        }
        
        return true;
    }
    
    // ========== MÉTODOS DE ESTUDANTES ==========
    
    private static void adicionarEstudante() {
        limparTela();
        System.out.println("=== ADICIONAR ESTUDANTE ===\n");
        
        System.out.print("ID do estudante: ");
        int id = lerInteiro();
        
        scanner.nextLine(); // Limpa buffer
        System.out.print("Nome do estudante: ");
        String nome = scanner.nextLine();
        
        try {
            Estudantes novo = new Estudantes(id, nome);
            listaEstudantes.adicionarEstudante(novo);
            System.out.println("\n✅ Estudante adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("\n❌ Erro: " + e.getMessage());
        }
        
        pausar();
    }
    
    private static void listarEstudantes() {
        limparTela();
        listaEstudantes.exibirTodos();
        pausar();
    }
    
    private static void buscarEstudantePorNome() {
        limparTela();
        System.out.println("=== BUSCAR ESTUDANTE ===\n");
        
        System.out.print("Digite parte do nome: ");
        String substring = scanner.nextLine();
        
        List<Estudantes> resultados = listaEstudantes.buscarEstudantesPorNome(substring);
        
        System.out.println("\n📋 Resultados encontrados: " + resultados.size());
        if (resultados.isEmpty()) {
            System.out.println("Nenhum estudante encontrado.");
        } else {
            for (Estudantes e : resultados) {
                System.out.println("  • " + e);
            }
        }
        
        pausar();
    }
    
    private static void ordenarEstudantes() {
        limparTela();
        System.out.println("=== ORDENAR ESTUDANTES ===\n");
        
        listaEstudantes.ordenarEstudantesPorNome();
        System.out.println("✅ Lista ordenada alfabeticamente!");
        System.out.println("\nLista atualizada:");
        listaEstudantes.exibirTodos();
        
        pausar();
    }
    
    private static void removerEstudante() {
        limparTela();
        System.out.println("=== REMOVER ESTUDANTE ===\n");
        
        listarEstudantes();
        
        System.out.print("ID do estudante a remover: ");
        int id = lerInteiro();
        
        boolean removido = listaEstudantes.removerEstudanteporID(id);
        
        if (removido) {
            System.out.println("\n✅ Estudante removido com sucesso!");
        } else {
            System.out.println("\n❌ Estudante não encontrado!");
        }
        
        pausar();
    }
    
    // ========== MÉTODOS DE DISCIPLINAS ==========
    
    private static void adicionarDisciplina() {
        limparTela();
        System.out.println("=== ADICIONAR DISCIPLINA ===\n");
        
        System.out.print("Código da disciplina (ex: MAT101): ");
        String codigo = scanner.nextLine();
        
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        
        try {
            Disciplina nova = new Disciplina(codigo, nome);
            boolean adicionada = cadastroDisciplinas.adicionarDisciplina(nova);
            
            if (adicionada) {
                System.out.println("\n✅ Disciplina adicionada com sucesso!");
            } else {
                System.out.println("\n⚠️  Disciplina já existe (duplicata ignorada)!");
            }
        } catch (Exception e) {
            System.out.println("\n❌ Erro: " + e.getMessage());
        }
        
        pausar();
    }
    
    private static void listarDisciplinas() {
        limparTela();
        cadastroDisciplinas.exibirTodasAsDisciplinas();
        pausar();
    }
    
    private static void verificarDisciplina() {
        limparTela();
        System.out.println("=== VERIFICAR DISCIPLINA ===\n");
        
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        
        boolean existe = cadastroDisciplinas.verificarDisciplina(codigo);
        
        if (existe) {
            System.out.println("\n✅ Disciplina encontrada!");
            Disciplina d = cadastroDisciplinas.buscaPorCodigo(codigo);
            System.out.println("  " + d);
        } else {
            System.out.println("\n❌ Disciplina não encontrada!");
        }
        
        pausar();
    }
    
    private static void removerDisciplina() {
        limparTela();
        System.out.println("=== REMOVER DISCIPLINA ===\n");
        
        cadastroDisciplinas.exibirTodasAsDisciplinas();
        
        System.out.print("Código da disciplina a remover: ");
        String codigo = scanner.nextLine();
        
        boolean removida = cadastroDisciplinas.removerDisciplina(codigo);
        
        if (removida) {
            System.out.println("\n✅ Disciplina removida com sucesso!");
        } else {
            System.out.println("\n❌ Disciplina não encontrada!");
        }
        
        pausar();
    }
    
    private static void adicionarMatricula() {
        limparTela();
        System.out.println("=== ADICIONAR MATRÍCULA (NOTA) ===\n");
        
        listaEstudantes.exibirTodos();
        System.out.print("ID do estudante: ");
        int idEstudante = lerInteiro();
        
        scanner.nextLine(); // Limpa buffer
        cadastroDisciplinas.exibirTodasAsDisciplinas();
        System.out.print("Código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        
        System.out.print("Nota (0 a 10): ");
        double nota = lerDouble();
        
        try {
            historicoNotas.adicionarMatricula(idEstudante, codigoDisciplina, nota);
            System.out.println("\n✅ Matrícula adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("\n❌ Erro: " + e.getMessage());
        }
        
        pausar();
    }
    
    private static void verHistoricoEstudante() {
        limparTela();
        System.out.println("=== HISTÓRICO DO ESTUDANTE ===\n");
        
        listaEstudantes.exibirTodos();
        System.out.print("ID do estudante: ");
        int id = lerInteiro();
        
        historicoNotas.exibirHistorico(id);
        
        pausar();
    }
    
    private static void verNotaEspecifica() {
        limparTela();
        System.out.println("=== VER NOTA ESPECÍFICA ===\n");
        
        System.out.print("ID do estudante: ");
        int id = lerInteiro();
        
        scanner.nextLine(); // Limpa buffer
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        
        Optional<Double> notaOpt = historicoNotas.obterNota(id, codigo);
        
        if (notaOpt.isPresent()) {
            System.out.printf("\n📝 Nota: %.2f\n", notaOpt.get());
        } else {
            System.out.println("\n❌ Matrícula não encontrada!");
        }
        
        pausar();
    }
    
    private static void calcularMediaEstudante() {
        limparTela();
        System.out.println("=== MÉDIA DO ESTUDANTE ===\n");
        
        listaEstudantes.exibirTodos();
        System.out.print("ID do estudante: ");
        int id = lerInteiro();
        
        double media = historicoNotas.mediaDoEstudante(id);
        
        System.out.printf("\n📊 Média geral: %.2f\n", media);
        
        if (media >= 7.0) {
            System.out.println("✅ Status: APROVADO");
        } else if (media > 0) {
            System.out.println("❌ Status: REPROVADO");
        } else {
            System.out.println("⚠️  Sem notas cadastradas");
        }
        
        pausar();
    }
    
    private static void calcularMediaDisciplina() {
        limparTela();
        System.out.println("=== MÉDIA DA DISCIPLINA ===\n");
        
        cadastroDisciplinas.exibirTodasAsDisciplinas();
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        
        double media = historicoNotas.mediaDaDisciplina(codigo);
        
        System.out.printf("\n📊 Média da turma: %.2f\n", media);
        
        if (media >= 7.0) {
            System.out.println("✅ Desempenho: BOM");
        } else if (media >= 6.0) {
            System.out.println("⚠️  Desempenho: REGULAR");
        } else if (media > 0) {
            System.out.println("❌ Desempenho: INSUFICIENTE");
        } else {
            System.out.println("⚠️  Sem notas cadastradas");
        }
        
        pausar();
    }
    
    private static void removerMatricula() {
        limparTela();
        System.out.println("=== REMOVER MATRÍCULA ===\n");
        
        System.out.print("ID do estudante: ");
        int id = lerInteiro();
        
        scanner.nextLine(); // Limpa buffer
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        
        boolean removida = historicoNotas.removerMatricula(id, codigo);
        
        if (removida) {
            System.out.println("\n✅ Matrícula removida com sucesso!");
        } else {
            System.out.println("\n❌ Matrícula não encontrada!");
        }
        
        pausar();
    }
    
    
    private static void relatorioAlunosAprovados() {
        limparTela();
        System.out.println("=== ALUNOS COM MÉDIA ≥ 8.0 ===\n");
        
        boolean encontrou = false;
        for (Estudantes e : listaEstudantes.obterTodos()) {
            double media = historicoNotas.mediaDoEstudante(e.getId());
            if (media >= 8.0) {
                System.out.printf("🏆 %s - Média: %.2f\n", e.getNome(), media);
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum aluno com média ≥ 8.0");
        }
        
        pausar();
    }
    
    private static void relatorioDisciplinasBaixas() {
        limparTela();
        System.out.println("=== DISCIPLINAS COM MÉDIA < 6.0 ===\n");
        
        boolean encontrou = false;
        for (Disciplina d : cadastroDisciplinas.obterTodasDisciplinas()) {
            double media = historicoNotas.mediaDaDisciplina(d.getCodigo());
            if (media > 0 && media < 6.0) {
                System.out.printf("⚠️  %s - Média: %.2f\n", d.getNome(), media);
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma disciplina com média < 6.0");
        }
        
        pausar();
    }
    
    private static void relatorioTopEstudantes() {
        limparTela();
        System.out.println("=== TOP 5 ESTUDANTES ===\n");
        
        var top5 = historicoNotas.topNEstudantesPorMedia(5);
        
        int posicao = 1;
        for (var entrada : top5) {
            int idEstudante = entrada.getKey();
            double media = entrada.getValue();
            
            for (Estudantes estudante : listaEstudantes.obterTodos()) {
                if (estudante.getId() == idEstudante) {
                    String medalha = posicao == 1 ? "🥇" : posicao == 2 ? "🥈" : posicao == 3 ? "🥉" : "  ";
                    System.out.printf("%s %dº lugar: %s - Média: %.2f\n", 
                                      medalha, posicao, estudante.getNome(), media);
                    posicao++;
                    break;
                }
            }
        }
        
        pausar();
    }
    
    private static void relatorioCompleto() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           RELATÓRIO COMPLETO DO SISTEMA        ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        System.out.println("📊 ESTATÍSTICAS GERAIS");
        System.out.println("  • Total de Estudantes: " + listaEstudantes.obterTodos().size());
        System.out.println("  • Total de Disciplinas: " + 
                           cadastroDisciplinas.obterTodasDisciplinas().size());
        
        System.out.println("\n👥 ESTUDANTES E SUAS MÉDIAS");
        for (Estudantes e : listaEstudantes.obterTodos()) {
            double media = historicoNotas.mediaDoEstudante(e.getId());
            String status = media >= 7.0 ? "✅" : media > 0 ? "❌" : "⚠️ ";
            System.out.printf("  %s %s - Média: %.2f\n", status, e.getNome(), media);
        }
        
        System.out.println("\n📚 DISCIPLINAS E SUAS MÉDIAS");
        for (Disciplina d : cadastroDisciplinas.obterTodasDisciplinas()) {
            double media = historicoNotas.mediaDaDisciplina(d.getCodigo());
            String status = media >= 7.0 ? "✅" : media >= 6.0 ? "⚠️ " : media > 0 ? "❌" : "  ";
            System.out.printf("  %s %s - Média: %.2f\n", status, d.getNome(), media);
        }
        
        pausar();
    }
    
    private static void carregarDadosExemplo() {
        // Estudantes
        listaEstudantes.adicionarEstudante(new Estudantes(1, "Ana Silva"));
        listaEstudantes.adicionarEstudante(new Estudantes(2, "Bruno Santos"));
        listaEstudantes.adicionarEstudante(new Estudantes(3, "Carlos Silva"));
        listaEstudantes.adicionarEstudante(new Estudantes(4, "Diana Costa"));
        listaEstudantes.adicionarEstudante(new Estudantes(5, "Eduardo Lima"));
        
        // Disciplinas
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("POR101", "Português"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("FIS101", "Física"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("QUI101", "Química"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("HIS101", "História"));
        
        // Matrículas
        historicoNotas.adicionarMatricula(1, "MAT101", 9.5);
        historicoNotas.adicionarMatricula(1, "POR101", 8.8);
        historicoNotas.adicionarMatricula(1, "FIS101", 9.0);
        
        historicoNotas.adicionarMatricula(2, "MAT101", 7.0);
        historicoNotas.adicionarMatricula(2, "POR101", 7.5);
        
        historicoNotas.adicionarMatricula(3, "MAT101", 5.5);
        historicoNotas.adicionarMatricula(3, "FIS101", 5.0);
        
        historicoNotas.adicionarMatricula(4, "MAT101", 8.5);
        historicoNotas.adicionarMatricula(4, "POR101", 8.0);
        historicoNotas.adicionarMatricula(4, "FIS101", 8.8);
        
        historicoNotas.adicionarMatricula(5, "MAT101", 7.8);
        historicoNotas.adicionarMatricula(5, "POR101", 8.2);
    }
    
    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
    }
    
    private static void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
    
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Valor inválido! Digite um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Valor inválido! Digite um número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}