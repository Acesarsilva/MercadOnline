package classesBasicas;
public class Funcionarios extends Pessoas{
    private double salario;
    public Funcionarios (String nome, String cpf,double salario){
        super(nome,cpf);
        this.salario = salario;
    }
    public double getSalarioFuncionario() {
        return salario;
    }
    public void setSalarioFuncionario(double salario) {
        this.salario = salario;
    }
 
}
