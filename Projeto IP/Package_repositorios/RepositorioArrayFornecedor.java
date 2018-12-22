package repositorios;

import java.util.List;

import classesBasicas.Fornecedor;
import classesBasicas.Produto;
import excecoes.CnpjInvalidoException;
import excecoes.FornecedorJaCadastradoException;
import excecoes.FornecedorNaoEncontradoException;
import interfaces.InterfaceFornecedor;

public class RepositorioArrayFornecedor implements InterfaceFornecedor {
	// declarando o array
	private Fornecedor[] arrayFornecedor;
	private int tamInicial;

	// construtor
	public RepositorioArrayFornecedor() {
		// inicializando as variaveis
		tamInicial = 30;
		arrayFornecedor = new Fornecedor[tamInicial];
	}

	public void aumentaVetor() {
		Fornecedor[] arrayFornecedor2 = new Fornecedor[2 * tamInicial];

		for (int i = 0; i < tamInicial; i++) {
			arrayFornecedor2[i] = arrayFornecedor[i];
		}
		tamInicial = 2 * tamInicial;
		arrayFornecedor = arrayFornecedor2;// apontador antigo aponta p novo array
	}// end - aumentar - vetor

	public void inserir(Fornecedor fornecedor) throws FornecedorJaCadastradoException, CnpjInvalidoException {// antes
																												// //
																												// que
		// verificar se o fornecedor ja
		// esta no // array
		boolean nInseriu = true;
		for (int i = 0; i < tamInicial && nInseriu; i++) {
			if (fornecedor.getCNPJ().length() == 18) {
				if (arrayFornecedor[i] == null) {
					arrayFornecedor[i] = fornecedor;
					nInseriu = false;
				} // end - if
				else {
					if (arrayFornecedor[i] != null && arrayFornecedor[i].getCNPJ() != null
							&& arrayFornecedor[i].getCNPJ().equals(fornecedor.getCNPJ())) {
						throw new FornecedorJaCadastradoException(fornecedor.getCNPJ());
					} else {
						if (i == tamInicial - 1) {
							this.aumentaVetor();
						} // end - if
					}
				} // end - else
			} else {
				throw new CnpjInvalidoException(fornecedor.getCNPJ());
			}
		} // end - for
	}// end - inserir

	public void remover(String CNPJ) throws CnpjInvalidoException {// so podemos remover se o fornecedor estiver no //
																	// array
		boolean nAchouF = true;
		for (int i = 0; i < tamInicial && nAchouF; i++) {
			if (CNPJ.length() <= 18) {
				if (arrayFornecedor[i] != null && arrayFornecedor[i].getCNPJ() != null
						&& arrayFornecedor[i].getCNPJ().equals(CNPJ)) {
					arrayFornecedor[i] = null;
					nAchouF = false;
				} // end - if
				else {
					throw new CnpjInvalidoException(CNPJ);
				}
			} else {
				throw new CnpjInvalidoException(CNPJ);
			}
		} // end - for
	}// end - remover

	public boolean procurar(String CNPJ) throws FornecedorNaoEncontradoException {// procurando o fornecedor pelo CNPJ
		int nAchouFornecedor = 0;
		boolean isAchou = false;
		for (int i = 0; i < tamInicial; i++) {
			if (arrayFornecedor[i] != null && arrayFornecedor[i].getCNPJ() != null
					&& arrayFornecedor[i].getCNPJ().equals(CNPJ)) {
				isAchou = true;
				return isAchou;
			}
		}
		if (!isAchou) {
			throw new FornecedorNaoEncontradoException(CNPJ);
		}
		return isAchou;
	}// end - procurar

	public void atualizar(Fornecedor fornecedor) {// so podemos atualizar a empresa, se a acharmos
		// parametro de procura -> CNPJ; parametro de mudanca -> NovoNomeEmpresa
		boolean isNotFound = true;
		for (int i = 0; i < tamInicial && isNotFound; i++) {
			if (arrayFornecedor[i] != null) {
				if (arrayFornecedor[i].getCNPJ() != null && arrayFornecedor[i].getCNPJ().equals(fornecedor.getCNPJ())) {
					arrayFornecedor[i] = fornecedor;
					isNotFound = false;
				} // end - if
			}

		} // end - for
	}// end - atualizar

	public void imprimeFornecedor() {
		for (int i = 0; i < tamInicial; i++) {

			if (arrayFornecedor[i] != null) {
				System.out.println("Nome Empresa: " + arrayFornecedor[i].getNomeEmpresa());
				System.out.println("CNPJ: " + arrayFornecedor[i].getCNPJ());
				this.imprimeProduto(arrayFornecedor[i].getListaProduto());
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

}// end - ArrayRepositorio_Fornecedor
