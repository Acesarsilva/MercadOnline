package repositorios;
import classesBasicas.Funcionarios;
import interfaces.InterfacePessoasFuncionarios;
import excecoes.FuncionarioNaoEncontradoException;
public class RepositorioListaPessoasFuncionarios implements InterfacePessoasFuncionarios{
    private Funcionarios funcionario;
    private RepositorioListaPessoasFuncionarios proximo;
    public RepositorioListaPessoasFuncionarios(){
        this.funcionario = null;
        this.proximo = null;
    }
    public void inserirPessoaFuncionario (Funcionarios funcionario){
        if(this.proximo == null){
            this.funcionario = funcionario;
            this.proximo = new RepositorioListaPessoasFuncionarios();
        }else{
            this.proximo.inserirPessoaFuncionario(funcionario);
        }
    }
    public void removerPessoaFuncionario (Funcionarios funcionario) throws FuncionarioNaoEncontradoException{
        if( this.proximo != null && funcionario.getCpfPessoa().equals(this.funcionario.getCpfPessoa())){
            this.funcionario = this.proximo.funcionario;
            this.proximo = this.proximo.proximo;
        }else if (this.proximo != null){
            this.proximo.removerPessoaFuncionario(funcionario);
        }else{
            throw new FuncionarioNaoEncontradoException();
        }
    }
    public boolean temPessoaFuncionario (Funcionarios funcionario){
        if( this.proximo != null && this.funcionario.getCpfPessoa().equals(funcionario.getCpfPessoa())){
            return true;
        }else if(this.proximo != null){
            this.proximo.temPessoaFuncionario(funcionario);
        }
        return false;
    }
    public Funcionarios buscarPessoaFuncionario (String cpf,int i) throws FuncionarioNaoEncontradoException{
        if( this.proximo != null && this.funcionario.getCpfPessoa().equals(cpf)){
            return this.funcionario;
        }else if (this.proximo != null){
            return this.proximo.buscarPessoaFuncionario(cpf,i);
        }else{
            throw new FuncionarioNaoEncontradoException();
        }
    }
    public void atualizarNomePessoaFuncionario (String nome,String cpf) throws FuncionarioNaoEncontradoException{
        Funcionarios funcionario = buscarPessoaFuncionario(cpf,0);
        funcionario.setNomePessoa(nome);
    }
    public void atualizarSalarioPessoaFuncionario(double salario ,String cpf) throws FuncionarioNaoEncontradoException{
        Funcionarios funcionario = buscarPessoaFuncionario(cpf,0);
        funcionario.setSalarioFuncionario(salario);
    }

}
