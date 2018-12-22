package interfaces;

import classesBasicas.Produto;
import excecoes.*;
 
public interface InterfaceProduto {  
	public void inserir(Produto novoProduto)throws ProdutoJaCadastradoException;
	public void remover(int codigoProduto) throws ProdutoNaoEncontradoException;
	public void atualizarNome(int codigoProduto, String novoNome)throws ProdutoNaoEncontradoException;
	public void atualizarPreco(int codigoProduto, Double novoPreco)throws ProdutoNaoEncontradoException;
	public int procurar(int codigoProduto)throws ProdutoNaoEncontradoException;
	public Produto getProduto(int codigoProduto)throws ProdutoNaoEncontradoException;
}
