package interfaces;

import classesBasicas.Entrega;
import excecoes.EntregaNaoEncontradaException;
import excecoes.EntregaJaCadastradaException;
public interface InterfaceEntrega {
	abstract void inserirEntrega(Entrega entrega) throws EntregaJaCadastradaException;

	abstract void removerEntrega(Entrega entrega) throws EntregaNaoEncontradaException;

	abstract void atualizarEntrega(Entrega entrega) throws EntregaNaoEncontradaException;

	abstract boolean procurarEntrega(Entrega entrega);
}
