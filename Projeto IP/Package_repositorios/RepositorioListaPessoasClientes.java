package repositorios;
import classesBasicas.Clientes;
import excecoes.ClienteNaoEncontradoException;
import interfaces.InterfacePessoasClientes;
public class RepositorioListaPessoasClientes implements InterfacePessoasClientes{
    private Clientes cliente ;
    private RepositorioListaPessoasClientes proximo;
    public RepositorioListaPessoasClientes(){
        this.cliente = null;
        this.proximo = null;
    }
    public void inserirPessoaCliente (Clientes cliente){
        if(this.proximo == null){
            this.cliente = cliente;
            this.proximo = new RepositorioListaPessoasClientes();
        }else{
            this.proximo.inserirPessoaCliente(cliente);
        }
    }
    public void removerPessoaCliente (Clientes cliente) throws ClienteNaoEncontradoException{
        if(this.proximo != null && cliente.getCpfPessoa().equals(this.cliente.getCpfPessoa())){
            this.cliente = this.proximo.cliente;
            this.proximo = this.proximo.proximo;
        }else if (this.proximo != null){
            this.proximo.removerPessoaCliente(cliente);
        }else{
            throw new ClienteNaoEncontradoException();
        }
    }
    public boolean temPessoaCliente (Clientes cliente){
        if(this.proximo != null && this.cliente.getCpfPessoa().equals(cliente.getCpfPessoa())){
            return true;
        }else if(this.proximo != null){
            this.proximo.temPessoaCliente(cliente);
        }
        return false;
    }
    public Clientes buscarPessoaCliente (String cpf,int i) throws ClienteNaoEncontradoException{
        if(this.proximo != null && this.cliente.getCpfPessoa().equals(cpf)){
            return this.cliente;
        }else if (this.proximo != null){
            return this.proximo.buscarPessoaCliente(cpf, i);
        }else{
            throw new ClienteNaoEncontradoException();
        }
    }
    public void atualizarNomePessoaCliente (String nome,String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = buscarPessoaCliente(cpf,0);
        cliente.setNomePessoa(nome);
    }
    public void atualizarEnderecoPessoaCliente(String endereco,String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = buscarPessoaCliente(cpf,0);
        cliente.setEnderecoCliente(endereco);
    }
}
