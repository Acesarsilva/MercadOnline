package repositorios;

import java.util.List;
import java.util.Iterator;

import classesBasicas.Fornecedor;
import classesBasicas.Produto;
import excecoes.CnpjInvalidoException;
import excecoes.FornecedorJaCadastradoException;
import excecoes.FornecedorNaoEncontradoException;
import interfaces.InterfaceFornecedor;

public class RepositorioListaFornecedor implements InterfaceFornecedor {
	private Fornecedor fornecedor;// elemento da lista
	private RepositorioListaFornecedor proximo;// referencia

	// construtor
	public RepositorioListaFornecedor() {
		this.fornecedor = null;
		this.proximo = null;
	}

	// inserindo fornecedor na lista
	public void inserir(Fornecedor fornecedor) throws FornecedorJaCadastradoException, CnpjInvalidoException {
		if (fornecedor.getCNPJ().length() == 18) {
			if (this.fornecedor == null) {
				this.fornecedor = fornecedor;
				this.proximo = new RepositorioListaFornecedor();
			} else {
				if (this.fornecedor.getCNPJ().equals(fornecedor.getCNPJ())) {
					throw new FornecedorJaCadastradoException(fornecedor.getCNPJ());
				}
				this.proximo.inserir(fornecedor);
			}
		} else {
			throw new CnpjInvalidoException(fornecedor.getCNPJ());
		}
	}// end - inserir

	// atualizando dados do fornecedor na lista
	public void atualizar(Fornecedor fornecedor) {// parametro de mudanca ->
		// nome; parametro fixo -> // CNPJ
		if (this.fornecedor.getCNPJ().equals(fornecedor.getCNPJ())) {
			this.fornecedor = fornecedor;
		} else {
			this.proximo.atualizar(fornecedor);
		}
	}// end - atualizar

	// removendo fornecedor da lista
	public void remover(String CNPJ) throws CnpjInvalidoException {// usuario procura pelo CNPJ da empresa
		if (CNPJ.length() == 18) {
			if (this.fornecedor.getCNPJ().equals(CNPJ)) {
				this.fornecedor = this.proximo.fornecedor;
				this.proximo = this.proximo.proximo;
			} else {
				if(this.proximo.fornecedor == null) {
					throw new CnpjInvalidoException(CNPJ);// lancando a excecao
				}
				else {
				this.proximo.remover(CNPJ);
				}
			}
		} else {
			throw new CnpjInvalidoException(CNPJ);// lancando a excecao
		}
	}// end - remover

	// procurando o fornecedor na lista
	public boolean procurar(String CNPJ) throws FornecedorNaoEncontradoException {
		if (this.fornecedor.getCNPJ() == null) {

			throw new FornecedorNaoEncontradoException(CNPJ);// lancando a excecao

		} else {
			if (this.fornecedor.getCNPJ().equals(CNPJ)) {
				return true;
			} else {
				if (this.proximo.fornecedor== null) {
					throw new FornecedorNaoEncontradoException(CNPJ);// lancando a excecao
				} else {
					return this.proximo.procurar(CNPJ);
				}
			}
		}
	}// end - procurar

	public void imprimeFornecedor() {
		if (this.fornecedor != null) {
			System.out.println("Nome Empresa: " + fornecedor.getNomeEmpresa());
			System.out.println("CNPJ: " + fornecedor.getCNPJ());
			imprimeProduto(fornecedor.getListaProduto());
			if (this.proximo.fornecedor != null) {
				this.proximo.imprimeFornecedor();
			}
		}
	}

	private void imprimeProduto(List<Produto> listaProdutos) {

		for (Produto produto : listaProdutos) {
			System.out.println("Nome Produto: " + produto.getNome());
			System.out.println("Codigo Produto: " + produto.getCodigo());
			System.out.println("Preco: " + produto.getPreco());

		}
	}

}// end - listaRepositorio
