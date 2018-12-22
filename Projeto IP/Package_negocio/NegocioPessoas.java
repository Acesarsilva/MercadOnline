package negocios;
import classesBasicas.Clientes;
import classesBasicas.Funcionarios;
import interfaces.InterfacePessoasClientes;
import interfaces.InterfacePessoasFuncionarios;
import excecoes.ClienteJaCadastradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.FuncionarioJaContratadoException;
import repositorios.RepositorioArrayPessoasClientes;
import repositorios.RepositorioArrayPessoasFuncionarios;
import repositorios.RepositorioListaPessoasClientes;
import repositorios.RepositorioListaPessoasFuncionarios;
import excecoes.ErroDeInicializacaoException;

public class NegocioPessoas{
    private InterfacePessoasClientes repositorioClientes;
    private InterfacePessoasFuncionarios repositorioFuncionarios;
    public NegocioPessoas(String letra)throws ErroDeInicializacaoException{
        if(letra.equals("a")) {
        	this.repositorioClientes = new RepositorioArrayPessoasClientes();
        	this.repositorioFuncionarios = new RepositorioArrayPessoasFuncionarios();
        }else if(letra.equals("l")) {
        	this.repositorioClientes = new RepositorioListaPessoasClientes();
        	this.repositorioFuncionarios = new RepositorioListaPessoasFuncionarios();
        }else {
        	throw new ErroDeInicializacaoException();
        }
    }
    public void cadastrarCliente (String nome,String cpf,String endereco) throws ClienteJaCadastradoException{
        Clientes cliente = new Clientes(nome,cpf,endereco);
        if(!this.repositorioClientes.temPessoaCliente(cliente)){
            this.repositorioClientes.inserirPessoaCliente(cliente);
        }else{
            throw new ClienteJaCadastradoException();
        }
    }
    public void encerrarCadastroCliente (String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = this.repositorioClientes.buscarPessoaCliente(cpf,0);
        this.repositorioClientes.removerPessoaCliente(cliente);
    }
    public void atualizarNomeCliente(String nome,String cpf) throws ClienteNaoEncontradoException{
        Clientes cliente = this.repositorioClientes.buscarPessoaCliente(cpf, 0);
        cliente.setNomePessoa(nome);
    }
    public void atualizarEnderecoCliente(String endereco,String cpf)throws ClienteNaoEncontradoException {
    	Clientes cliente = this.repositorioClientes.buscarPessoaCliente(cpf, 0);
    	cliente.setEnderecoCliente(endereco);
    }
    public void contratarFuncionario(String nome,String cpf,double salario) throws FuncionarioJaContratadoException{
    	Funcionarios funcionario = new Funcionarios(nome,cpf,salario);
    	if(!this.repositorioFuncionarios.temPessoaFuncionario(funcionario)) {
    		this.repositorioFuncionarios.inserirPessoaFuncionario(funcionario);
    	}else {
    		throw new FuncionarioJaContratadoException();
    	}
    }
    public void demitirFuncionario(String cpf)throws FuncionarioNaoEncontradoException{
    	Funcionarios funcionario = this.repositorioFuncionarios.buscarPessoaFuncionario(cpf, 0);
    	this.repositorioFuncionarios.removerPessoaFuncionario(funcionario);
    }
    public void atualizarNomeFuncionario(String nome,String cpf) throws FuncionarioNaoEncontradoException{
    	Funcionarios funcionario = this.repositorioFuncionarios.buscarPessoaFuncionario(cpf, 0);
    	funcionario.setNomePessoa(nome);
    }
    public void atualizarSalarioFuncionario(double salario,String cpf) throws FuncionarioNaoEncontradoException{
    	Funcionarios funcionario = this.repositorioFuncionarios.buscarPessoaFuncionario(cpf, 0);
    	funcionario.setSalarioFuncionario(salario);
    }
}