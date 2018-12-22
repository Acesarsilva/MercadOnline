package excecoes;

public class ErroDeInicializacaoException extends Exception {
	public ErroDeInicializacaoException() {
		super("Digite 'a' ou 'l' para escolher o tipo de repositorio");
	}

}
