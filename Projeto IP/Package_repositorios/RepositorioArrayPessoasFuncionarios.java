package repositorios;
import classesBasicas.Funcionarios;
import excecoes.FuncionarioNaoEncontradoException;
import interfaces.InterfacePessoasFuncionarios;
public class RepositorioArrayPessoasFuncionarios implements InterfacePessoasFuncionarios{
    private Funcionarios[] funcionario;
    private int nFuncionarios;
    public RepositorioArrayPessoasFuncionarios(){
        this.funcionario = new Funcionarios [100];
        this.nFuncionarios = 0;
    }
    private Funcionarios[] aumentarNumeroFuncionarios(){
        Funcionarios[] aux = new Funcionarios[nFuncionarios*2];
        for( int i = 0; i < nFuncionarios; i++){
            aux[i] = this.funcionario[i];
        }
        return aux;
    }
    public void inserirPessoaFuncionario (Funcionarios funcionario){
        this.funcionario[nFuncionarios] = funcionario;
        this.nFuncionarios++;
        if(this.nFuncionarios == this.funcionario.length){
            this.funcionario = aumentarNumeroFuncionarios();
        }
    }
    public void removerPessoaFuncionario (Funcionarios funcionario) throws FuncionarioNaoEncontradoException{
        boolean achei = false;
        for (int i = 0; (i < nFuncionarios)&&(!achei); i++){
            if(this.funcionario[i].getCpfPessoa().equals(funcionario.getCpfPessoa())){
                for (int j = i; j + 1 < nFuncionarios;j++){
                    this.funcionario[j] = this.funcionario[j+1];
                }
                this.funcionario[nFuncionarios] = null;
                this.nFuncionarios--;
                achei = true;
            }
        }
        if(!achei){
            throw new FuncionarioNaoEncontradoException();
        }
    }
    public boolean temPessoaFuncionario (Funcionarios funcionario){
        for( int i = 0; i < nFuncionarios;i++){
            if(this.funcionario[i].getCpfPessoa().equals(funcionario.getCpfPessoa())){
                return true;
            }
        }
        return false;
    }
    public Funcionarios buscarPessoaFuncionario (String cpf,int i) throws FuncionarioNaoEncontradoException{
    	if(i < this.nFuncionarios) {
        	if(!this.funcionario[i].getCpfPessoa().equals(cpf)){
                return buscarPessoaFuncionario(cpf,i+1);
            }else {
            	return this.funcionario[i];
            }
        }else {
        	throw new FuncionarioNaoEncontradoException();
        }
    }
    public void atualizarNomePessoaFuncionario (String nome,String cpf) throws FuncionarioNaoEncontradoException{
        Funcionarios funcionario = buscarPessoaFuncionario(cpf,0);
        funcionario.setNomePessoa(nome);
    }
    public void atualizarSalarioPessoaFuncionario (double salario,String cpf) throws FuncionarioNaoEncontradoException{
        Funcionarios funcionario = buscarPessoaFuncionario(cpf,0);
        funcionario.setSalarioFuncionario(salario);
    }
}

