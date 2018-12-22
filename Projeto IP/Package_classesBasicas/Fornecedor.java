package classesBasicas;

import java.util.ArrayList;
import java.util.List;
import repositorios.RepositorioListaProduto;

public class Fornecedor {
    // classe possui 2 atributos próprios e um objeto listaProdutos
    private String CNPJ;
    private String nomeEmpresa;
    private List<Produto> listaProduto = new ArrayList<Produto>();

    public List<Produto> getListaProduto() {
   	 return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
   	 this.listaProduto = listaProduto;
    }

    // construtor
    public Fornecedor() {
   	 this.CNPJ = null;
   	 this.nomeEmpresa = null;
    }// end - construtor

    // metodos permitem alterar/acessar atributos da classe fornecedor no main
    public String getCNPJ() {
   	 return this.CNPJ;
    }

    public void setCNPJ(String cNPJ) {
   	 this.CNPJ = cNPJ;
    }

    public String getNomeEmpresa() {
   	 return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
   	 this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarProduto(Produto produto) {
   	 getListaProduto().add(produto);
    }
    public void removerProduto(Produto produto) {
   	 getListaProduto().remove(produto);
    }
    public void adicionarTodosProdutos(List<Produto> listaProduto) {
   	 getListaProduto().addAll(listaProduto);
    }

}// end - fornecedor_class