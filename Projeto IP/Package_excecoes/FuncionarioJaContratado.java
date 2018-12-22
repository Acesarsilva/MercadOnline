package excecoes;
public class FuncionarioJaContratado extends Exception {
	public FuncionarioJaContratado() {
		super("Funcionario ja contratado");
	}
}
