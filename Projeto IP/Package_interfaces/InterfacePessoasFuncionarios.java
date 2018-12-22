package interfaces;
import classesBasicas.Funcionarios;
import excecoes.FuncionarioNaoEncontradoException;
public interface InterfacePessoasFuncionarios {
	abstract void inserirPessoaFuncionario (Funcionarios funcionario);
	abstract void removerPessoaFuncionario (Funcionarios funcionario)throws FuncionarioNaoEncontradoException;
	abstract boolean temPessoaFuncionario (Funcionarios funcionario);
	abstract Funcionarios buscarPessoaFuncionario (String cpf,int i)throws FuncionarioNaoEncontradoException;
	abstract void atualizarNomePessoaFuncionario (String nome,String cpf)throws FuncionarioNaoEncontradoException;
	abstract void atualizarSalarioPessoaFuncionario(double salario,String cpf)throws FuncionarioNaoEncontradoException;
}

