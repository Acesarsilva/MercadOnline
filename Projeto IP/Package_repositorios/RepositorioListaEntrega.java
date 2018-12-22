package repositorios;

import classesBasicas.Entrega;
import excecoes.EntregaJaCadastradaException;
import excecoes.EntregaNaoEncontradaException;
import interfaces.InterfaceEntrega;

public class RepositorioListaEntrega implements InterfaceEntrega {
	private Entrega entrega;
	private RepositorioListaEntrega proximo;

	public RepositorioListaEntrega() {
		this.entrega = null;
		this.proximo = null;
	}

	public void inserirEntrega(Entrega entrega) throws EntregaJaCadastradaException {
		if (this.entrega == null) {
			this.entrega = entrega;
			this.proximo = new RepositorioListaEntrega();
		} else {
			this.proximo.inserirEntrega(entrega);
		}
	}

	public void removerEntrega(Entrega entregaNova) throws EntregaNaoEncontradaException {
		if (this.entrega != null) {
			if (this.entrega.getCpfClienteEntrega().equals(entrega.getCpfClienteEntrega())
					&& this.entrega.getPedidoEntrega().equals(entregaNova.getPedidoEntrega())) {
				this.entrega = this.proximo.entrega;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerEntrega(entrega);
			}
		}
	}

	public void atualizarEntrega(Entrega entregaNova) throws EntregaNaoEncontradaException {
		if (this.entrega != null) {
			if (this.entrega.getCpfClienteEntrega().equals(entrega.getCpfClienteEntrega())
					&& !this.entrega.getPedidoEntrega().equals(entregaNova.getPedidoEntrega())) {
				this.entrega.setPedidoEntrega(entregaNova.getPedidoEntrega());
			} else {
				this.proximo.atualizarEntrega(entrega);
			}
		}
	}

	public boolean procurarEntrega(Entrega entregaNova) {
		if (this.entrega != null) {
			if (this.entrega.getCpfClienteEntrega().equals(entrega.getCpfClienteEntrega())
					&& this.entrega.getPedidoEntrega().equals(entregaNova.getPedidoEntrega())) {
				return true;
			} else {
				this.proximo.procurarEntrega(entregaNova);
			}
		}
		return false;
	}
}