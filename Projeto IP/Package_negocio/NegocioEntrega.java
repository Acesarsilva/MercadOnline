package negocios;

import interfaces.InterfaceEntrega;
import repositorios.RepositorioListaEntrega;
import classesBasicas.Entrega;
import repositorios.RepositorioArrayEntrega;
import excecoes.EntregaJaCadastradaException;
import excecoes.EntregaNaoEncontradaException;
import excecoes.ErroDeInicializacaoException;

public class NegocioEntrega {
	private InterfaceEntrega repositorio;

	public NegocioEntrega(String qualRepositorio)throws ErroDeInicializacaoException{
		if (qualRepositorio.equalsIgnoreCase("a")) {
			repositorio = new RepositorioArrayEntrega();
		} else if (qualRepositorio.equalsIgnoreCase("l")) {
			repositorio = new RepositorioListaEntrega();
		}else {
			throw new ErroDeInicializacaoException();
		}
	}

	public void inserir(Entrega entrega) throws EntregaJaCadastradaException {
		repositorio.inserirEntrega(entrega);
	}

	public void remover(Entrega entrega) throws EntregaNaoEncontradaException {
		repositorio.removerEntrega(entrega);
	}

	public void atualizar(Entrega entrega) throws EntregaNaoEncontradaException {
		repositorio.atualizarEntrega(entrega);
	}

	public void procurar(Entrega entrega) throws EntregaNaoEncontradaException {
		repositorio.procurarEntrega(entrega);
	}
}
