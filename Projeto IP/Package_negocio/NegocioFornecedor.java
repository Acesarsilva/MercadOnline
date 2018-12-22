package negocios;

import interfaces.InterfaceFornecedor;
import repositorios.RepositorioArrayFornecedor;
import repositorios.RepositorioListaFornecedor;
import classesBasicas.Fornecedor;
import excecoes.CnpjInvalidoException;
import excecoes.FornecedorJaCadastradoException;
import excecoes.FornecedorNaoEncontradoException;
import excecoes.ErroDeInicializacaoException;

public class NegocioFornecedor {
    private InterfaceFornecedor repositorio;

    public NegocioFornecedor(String letraRepositorio)throws ErroDeInicializacaoException {//construtor
   	 if(letraRepositorio.equalsIgnoreCase("a")) {//usuario escolheu trabalhar com array
   		 repositorio = new RepositorioArrayFornecedor();
    
   	 }
   	 else if(letraRepositorio.equalsIgnoreCase("l")) {//usario escolheu lista
   		 repositorio = new RepositorioListaFornecedor();
   	 }else {
   		 throw new ErroDeInicializacaoException();
   	 }
    }//end - construtor
    
  public void acessoInserir(Fornecedor fornecedor) throws FornecedorJaCadastradoException,CnpjInvalidoException {
		repositorio.inserir(fornecedor);
	}
	
	public void acessoRemover(String CNPJ) throws CnpjInvalidoException{
		repositorio.remover(CNPJ);
	}
	
	public void acessoAtualizar(Fornecedor fornecedor) {
		repositorio.atualizar(fornecedor);
	}
	
	public boolean acessoProcurar(String CNPJ) throws FornecedorNaoEncontradoException{
		return repositorio.procurar(CNPJ);
	}
	public void imprimeTodosFornecedores() {
		this.repositorio.imprimeFornecedor();
	}
}//end - negocioFornecedor
