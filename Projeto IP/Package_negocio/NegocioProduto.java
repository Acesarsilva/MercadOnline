package negocios;
 
import classesBasicas.Produto;
import excecoes.ProdutoJaCadastradoException;
import excecoes.ProdutoNaoEncontradoException;
import excecoes.ErroDeInicializacaoException;
import interfaces.InterfaceProduto;
import repositorios.RepositorioArrayProduto;
import repositorios.RepositorioListaProduto;
 
public class NegocioProduto {
    private InterfaceProduto repositorio;
    
    public NegocioProduto(String escolhaRepositorio)throws ErroDeInicializacaoException {
    	if(escolhaRepositorio.equalsIgnoreCase("a")) {
            repositorio = (InterfaceProduto) new RepositorioArrayProduto();
   
        }
        else if(escolhaRepositorio.equalsIgnoreCase("l")) {
            repositorio = new RepositorioListaProduto();
        }else {
        	throw new ErroDeInicializacaoException();
        }
    }
    public int procurar(int codigoProduto)throws ProdutoNaoEncontradoException{
        return repositorio.procurar(codigoProduto);
    }
    public void inserir(Produto item) throws ProdutoJaCadastradoException {
        repositorio.inserir(item);
    }
   
    public void remover(int codigoProduto)  throws ProdutoNaoEncontradoException{
        repositorio.remover(codigoProduto);
    }
   
    public void atualizarNome(int codigoProduto, String novoNome)throws ProdutoNaoEncontradoException{
        repositorio.atualizarNome(codigoProduto,novoNome);
    }
    public void atualizarPreco(int codigoProduto, Double novoPreco)throws ProdutoNaoEncontradoException{
        repositorio.atualizarPreco(codigoProduto,novoPreco);
    }
    public Produto getProduto(int codigoProduto) throws ProdutoNaoEncontradoException{
      	 return repositorio.getProduto(codigoProduto);
   	}
}