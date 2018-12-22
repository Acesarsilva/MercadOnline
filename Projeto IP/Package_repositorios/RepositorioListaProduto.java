package repositorios;
 
import classesBasicas.Produto;
import interfaces.InterfaceProduto;
import excecoes.*;

 
public class RepositorioListaProduto implements InterfaceProduto {
    private Produto objetoProduto;
    private RepositorioListaProduto proximo;
 
    public RepositorioListaProduto() {
        this.objetoProduto = null;
        this.proximo = null;
    }
    public int procurar(Integer codigoProduto) {
        if(this.objetoProduto==null) {
            return -1;
        }else {
            if(this.objetoProduto.getCodigo()==codigoProduto) {
                return 1;
            }else {
                return this.proximo.procurar(codigoProduto);
            }
        }
    }
    public Produto getProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
     	 if (this.objetoProduto.getCodigo() == codigoProduto) {
     		 return this.objetoProduto;
     	 } else {
     		 if (this.proximo == null) {
     			 throw new ProdutoNaoEncontradoException(codigoProduto);
     		 } else {
     			 return this.proximo.getProduto(codigoProduto);
     		 }
     	 }
    }
 
    public void inserir(Produto item) throws ProdutoJaCadastradoException{
        if (this.objetoProduto == null) {
            this.objetoProduto =  item;
            this.proximo = new RepositorioListaProduto();
        } else {
        	if(this.objetoProduto.getCodigo()==item.getCodigo()) {
     			 throw new ProdutoJaCadastradoException(objetoProduto.getNome());
     		 }
            this.proximo.inserir(item);
        }
    }
 
    public void remover(Integer codigoProduto) throws ProdutoNaoEncontradoException{
        if (codigoProduto == this.objetoProduto.getCodigo()) {
            this.objetoProduto = this.proximo.objetoProduto;
            this.proximo = this.proximo.proximo;
        } else {
        	if(this.proximo==null) {
        		throw new ProdutoNaoEncontradoException(codigoProduto);
        	}else {
        		this.proximo.remover(codigoProduto);
        	}
            
        }
 
    }
 
    public void atualizarNome(Integer codigoProduto, String novoNome) throws ProdutoNaoEncontradoException{
        if (codigoProduto == this.objetoProduto.getCodigo()) {
            this.objetoProduto.setNome(novoNome);
        } else {
        	if(this.proximo==null) {
        		throw new ProdutoNaoEncontradoException(codigoProduto);
        	}else {
        		this.proximo.atualizarNome(codigoProduto, novoNome);
        	}
            
        }
    }
 
    public void atualizarPreco(Integer codigoProduto, Double novoPreco)throws ProdutoNaoEncontradoException{
        if (codigoProduto == this.objetoProduto.getCodigo()) {
            this.objetoProduto.setPreco(novoPreco);
        } else {
        	if(this.proximo==null) {
        		throw new ProdutoNaoEncontradoException(codigoProduto);
        	}else {
        		this.proximo.atualizarPreco(codigoProduto, novoPreco);
        	}
            
        }
    }
 
    
}