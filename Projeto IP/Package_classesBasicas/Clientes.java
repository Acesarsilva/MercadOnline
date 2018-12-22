package classesBasicas;
public class Clientes extends Pessoas {
    private String endereco;
    public Clientes(String nome,String cpf, String endereco){
        super (nome,cpf);
        this.endereco = endereco;
    }
    public String getEnderecoCliente() {
        return endereco;
    }
    public void setEnderecoCliente(String endereco) {
        this.endereco = endereco;
    }
}
