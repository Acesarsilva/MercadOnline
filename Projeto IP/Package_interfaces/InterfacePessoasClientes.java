package interfaces;
import classesBasicas.Clientes;
import excecoes.ClienteNaoEncontradoException;
public interface InterfacePessoasClientes {
	abstract void inserirPessoaCliente (Clientes cliente);
	abstract void removerPessoaCliente (Clientes cliente)throws ClienteNaoEncontradoException;
	abstract boolean temPessoaCliente (Clientes cliente);
	abstract Clientes buscarPessoaCliente (String cpf,int i)throws ClienteNaoEncontradoException;
	abstract void atualizarNomePessoaCliente (String nome,String cpf)throws ClienteNaoEncontradoException;
	abstract void atualizarEnderecoPessoaCliente(String endereco,String cpf)throws ClienteNaoEncontradoException;
}
