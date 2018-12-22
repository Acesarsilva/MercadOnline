package interfaces;

import classesBasicas.Fornecedor;
import excecoes.CnpjInvalidoException;
import excecoes.FornecedorJaCadastradoException;
import excecoes.FornecedorNaoEncontradoException;

public interface InterfaceFornecedor {
    //metodos que ambos reposit�rios(lista e array) ter�o:
	public void inserir(Fornecedor fornecedor) throws FornecedorJaCadastradoException, CnpjInvalidoException;
	public void remover(String CNPJ) throws CnpjInvalidoException;
	public boolean procurar(String CNPJ) throws FornecedorNaoEncontradoException;
	public void atualizar(Fornecedor fornecedor);
	public void imprimeFornecedor();
}
