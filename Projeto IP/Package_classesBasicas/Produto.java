package classesBasicas;
 
public class Produto {
    private Integer codigo;
    private String nome;
    private Double preco;
   
//PIETRA, apenas a linha abaixo foi alterada:
   public Produto(String nome, int codigo, Double preco){
        this.codigo=null;
        this.nome=null;
        this.preco=null;
    }
 
    public Integer getCodigo() {
        return this.codigo;
    }
 
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
 
    public String getNome() {
        return this.nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public Double getPreco() {
        return this.preco;
    }
 
    public void setPreco(Double preco) {
        this.preco = preco;
    }
}


