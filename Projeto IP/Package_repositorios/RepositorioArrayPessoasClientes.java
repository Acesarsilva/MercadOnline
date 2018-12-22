package repositorios;
import classesBasicas.Clientes;
import interfaces.InterfacePessoasClientes;
import excecoes.ClienteNaoEncontradoException;
public class RepositorioArrayPessoasClientes implements InterfacePessoasClientes{
    private Clientes[] cliente;
    private int nClientes;
    public RepositorioArrayPessoasClientes(){
        this.cliente = new Clientes [1000];
        this.nClientes = 0;
    }
    private Clientes[] aumentarNumeroClientes(){
        Clientes [] aux = new Clientes [nClientes*2];
        for( int i = 0; i < nClientes; i++){
            aux[i] = this.cliente[i];
        }
        return aux;
    }
    public void inserirPessoaCliente (Clientes cliente){
        this.cliente[nClientes] = cliente;
        this.nClientes++;
        if(this.nClientes == this.cliente.length ){
            this.cliente = aumentarNumeroClientes();
        }
    }
    public void removerPessoaCliente (Clientes cliente) throws ClienteNaoEncontradoException{
        boolean achei = false;
        for (int i = 0; (i < this.nClientes)&&(!achei); i++){
            if(this.cliente[i].getCpfPessoa().equals(cliente.getCpfPessoa())){
                for (int j = i; j + 1 < nClientes;j++){
                    this.cliente[j] = this.cliente[j+1];
                }
                this.cliente[nClientes] = null;
                this.nClientes--;
                achei = true;
            }
        }
        if(!achei) {
            throw new ClienteNaoEncontradoException();
        } 
    }
    public boolean temPessoaCliente (Clientes cliente){
        for( int i = 0; i < nClientes;i++){
            if(this.cliente[i].getCpfPessoa().equals(cliente.getCpfPessoa())){
                return true;
            }
        }
        return false;
    }
    public Clientes buscarPessoaCliente (String cpf,int i) throws ClienteNaoEncontradoException{
            if(i < this.nClientes) {
            	if(!this.cliente[i].getCpfPessoa().equals(cpf)){
                    return buscarPessoaCliente(cpf,i+1);
                }else {
                	return this.cliente[i];
                }
            }else {
            	throw new ClienteNaoEncontradoException();
            }
    }
    public void atualizarNomePessoaCliente (String nome,String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = buscarPessoaCliente(cpf,0);
        cliente.setNomePessoa(nome);
    }
    public void atualizarEnderecoPessoaCliente (String endereco,String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = buscarPessoaCliente(cpf,0);
        cliente.setEnderecoCliente(endereco);
    }
}
