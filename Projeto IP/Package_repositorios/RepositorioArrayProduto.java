package repositorios;

import classesBasicas.Produto;
import interfaces.InterfaceProduto;
import excecoes.*;
 
public class RepositorioArrayProduto implements InterfaceProduto{
   private Produto[] arrayProduto;
   private int indice;
   
   public RepositorioArrayProduto() {
	   this.arrayProduto=new Produto[30];
	   this.indice=0;
   }
   
   public int procurar(Integer codigoProduto)  {
	   Produto item=arrayProduto[this.indice];
	   if(this.indice<arrayProduto.length && item!=null && item.getCodigo()==codigoProduto) {
		   this.indice=0;
		   return this.indice;
	   }else if(this.indice<arrayProduto.length && item!=null &&  item.getCodigo()!=codigoProduto){
		   this.indice++;
		   return procurar(codigoProduto);
	   }else {
		   return -1;
	   }
	}
   
   public void inserir(Produto item)throws ProdutoJaCadastradoException  {
	   Integer n=procurar(item.getCodigo());
	   if(n!=-1) {
		   throw new ProdutoJaCadastradoException(item.getNome());
	   }else {
		   if(n == this.arrayProduto.length-1){
			   Produto[] novaArrayProduto = new Produto[this.arrayProduto.length * 2];
			   for(int i = 0; i < this.arrayProduto.length-1; i++){
				   novaArrayProduto[i] = this.arrayProduto[i];
			   }
			   this.arrayProduto = novaArrayProduto;
			   this.inserir(item);
		   }
		   for(int t=0; t<arrayProduto.length; t++) {
			   if(arrayProduto[t]==null){
				   arrayProduto[t]=item;
				   t=arrayProduto.length;
			   }
		   }
		   
		}
   }
   
   public void remover(Integer codigoProduto) throws ProdutoNaoEncontradoException {
       Integer n=procurar(codigoProduto);
       if(n==-1) {
    	   throw new ProdutoNaoEncontradoException(codigoProduto);
       }else {
    	   arrayProduto[n]=null;
       }
   }
   
   public void atualizarNome(Integer codigoProduto, String novoNome)  throws ProdutoNaoEncontradoException{
	   Integer n=procurar(codigoProduto);
	   if(n==-1) {
		   throw new ProdutoNaoEncontradoException(codigoProduto);
	   }else {
		   arrayProduto[n].setNome(novoNome);
	   }
   }
   
   public void atualizarPreco(Integer codigoProduto, Double novoPreco)  throws ProdutoNaoEncontradoException{
	   Integer n=procurar(codigoProduto);
	   if(n==-1) {
		   throw new ProdutoNaoEncontradoException(codigoProduto);
	   }else {
		   arrayProduto[n].setPreco(novoPreco);
	   }
   }
   public Produto getProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
		int n = procurar(codigoProduto);
		if (n == -1) {
			throw new ProdutoNaoEncontradoException(codigoProduto);
		} else {
			return arrayProduto[n];
		}
	}
   
}