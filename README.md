# Sistema de Gerenciamento Escolar

## Integrantes do Grupo
- Lucas Ribeiro
- Adriel Martim
- João Evangelista

## Descrição do Projeto
Este projeto implementa um sistema de gerenciamento escolar interativo que permite:
- Cadastro e gerenciamento de estudantes
- Registro e controle de disciplinas
- Gerenciamento de matrículas
- Controle de notas e histórico escolar
- Geração de relatórios em arquivo texto (output.txt)

O sistema utiliza estruturas de dados (coleções) do Java para organizar e manipular as informações de forma eficiente.

## Justificativa das Coleções Utilizadas

### ArrayList
- Utilizada na classe `ListaEstudantes` para armazenar a lista de estudantes
- Escolhida por permitir acesso rápido por índice e manter a ordem de inserção
- Ideal para situações onde precisamos percorrer a lista sequencialmente

### HashSet
- Implementada na classe `CadastroDisciplinas` para gerenciar disciplinas
- Garante que não haja duplicatas de disciplinas
- Oferece operações de busca e inserção em O(1)

### HashMap
- Usada na classe `HistoricoNotas` para mapear estudantes às suas notas
- Permite associação direta entre estudante e suas notas
- Acesso rápido ao histórico de cada estudante

## Como Executar o Programa

1. Compilar os arquivos fonte:
   ```bash
   cd src
   javac *.java -d ../bin
   ```

2. Executar o programa:
   ```bash
   cd ../bin
   java SistemaEscolarInterativo
   ```

3. Interagir com o menu:
   - Digite o número da opção desejada
   - Siga as instruções na tela
   - Para gerar o arquivo output.txt, utilize a opção específica no menu

## Desafios e Aprendizados

### Merge no GitHub
Durante o desenvolvimento, enfrentamos desafios significativos ao realizar o merge das branches no GitHub. Um dos principais problemas foi o conflito com arquivos `.class` que não deveriam estar no controle de versão. Para resolver:
- Implementamos um `.gitignore` adequado
- Realizamos backup dos arquivos compilados
- Aprendemos a importância de ignorar arquivos binários no controle de versão

### Implementação de Hash
A implementação correta dos métodos `hashCode()` e `equals()` foi desafiadora, especialmente para garantir:
- Consistência entre os métodos
- Unicidade apropriada dos objetos
- Funcionamento correto das coleções que dependem dessas implementações

Este desafio nos ajudou a compreender melhor:
- A importância da correta implementação de hash para o funcionamento das coleções
- Como a equals() e hashCode() trabalham juntos
- A necessidade de manter a consistência entre essas implementações

## Conclusão
O projeto proporcionou uma experiência prática valiosa com:
- Estruturas de dados em Java
- Controle de versão com Git
- Trabalho em equipe
- Resolução de conflitos de código