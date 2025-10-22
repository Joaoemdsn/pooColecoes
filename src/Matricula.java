public class Matricula {
    private String codigoDisciplina;
    private double nota;
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        if(nota >= 0 && nota <= 10) {
            this.nota = nota;
        } else {
            System.out.println("Nota inválida. Deve estar entre 0 e 10.");
        }
    }
    
    public Matricula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = codigoDisciplina;
        if (nota < 0 || nota > 10) {
            System.out.println("Nota deve estar entre 0 e 10");
            this.nota = 0.0;
        } else {
            this.nota = nota;
        }
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "codigoDisciplina='" + codigoDisciplina + '\'' +
                ", nota=" + nota +
                '}';
    }

}
