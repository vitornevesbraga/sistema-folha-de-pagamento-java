public class Colaborador {
    private final int matricula;
    private final String nome;
    private final double salarioBase;

    private static final double SALARIO_BASE = 2000.0;

    public Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = SALARIO_BASE;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalarioFinal() {
        return salarioBase;
    }

    public void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Salário base: R$ " + salarioBase);
        System.out.println("Salário final: R$ " + calcularSalarioFinal());
    }
}