package main;

import java.util.*;
import negocios.*;
import repositorios.*;
import classesBasicas.*;
import excecoes.*;
import fachada.Fachada;

class ClasseMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Escolha o tipo de Repositorio -> Array(a) ou Lista(l)");
		String tipoRepositorio = in.next();
		try {
			 Fachada fachada = new Fachada(tipoRepositorio);
			 System.out.println("***************************************************************************");
		   	 System.out.println("                  	      BEM VINDO(A) AO MENU                             	");
		   	 System.out.println("***************************************************************************");
		   	 System.out.println("");
		   	 System.out.println("Escolha uma acesso -> RH(Rh)/Estoque(Es)/Cliente(C)/Fornecedor(Fo)/Entrega(E): ");
		   	 String tipoAcesso = in.next();
		   	 if(tipoAcesso.equals("Rh")) {
		   		System.out.println("                  	      BEM VINDO(A) AO RH                            	");
		   		System.out.println("(1) Contratar Novo Funcionario");
		   		System.out.println("(2) Demitir Funcionario");
		   		System.out.println("(3) Atualizar Nome de Funcionario");
		   		System.out.println("(4) Atualizar Salario de Funcionario");
		   		System.out.println("(5) Finalizar Operacoes");
		   		System.out.println("Escolha uma operacao:");
		   		int operacao = 0;
		   		while(in.hasNextInt() && operacao != 5) {
		   			operacao = in.nextInt();
		   			if(operacao == 1) {
		   				System.out.println("Para Contratar Digite os Dados do Novo Funcionario:");
		   				System.out.println("Nome Completo do Funcionario: ");
		   				String nome = in.nextLine();
		   				while(nome.equals("")) {
		   					nome = in.nextLine();
		   				}
		   				System.out.println("CPF do Funcionario: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				System.out.println("Salario do Novo Contratado: ");
		   				double salario = in.nextDouble();
		   				try {
		   					fachada.contratarFuncionario(nome, cpf, salario);
		   					System.out.println("Funcionario Contratado com Sucesso.");
		   				}catch(FuncionarioJaContratadoException FJC) {
		   					System.out.println(FJC.getMessage());
		   				}
		   			}else if(operacao == 2) {
		   				System.out.println("Para Demitir Digite o CPF do Funcionario: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.demitirFuncionario(cpf);
		   					System.out.println("Funcionario Demitido com Sucesso.");
		   				}catch(FuncionarioNaoEncontradoException FNE) {
		   					System.out.println(FNE.getMessage());
		   				}
		   			}else if(operacao == 3) {
		   				System.out.println("Para Atualizar o Nome do Funcionario Digite os Dados a Seguir: ");
		   				System.out.println("Nome Completo Para Correcao: ");
		   				String nome = in.nextLine();
		   				while(nome.equals("")) {
		   					nome = in.nextLine();
		   				}
		   				System.out.println("CPF do Funcionario: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.atualizarNomeFuncionario(nome, cpf);
		   					System.out.println("Nome Atualizado com Sucesso.");
		   				}catch(FuncionarioNaoEncontradoException FNE) {
		   					System.out.println(FNE.getMessage());
		   				}
		   			}else if(operacao == 4) {
		   				System.out.println("Para Atualizar o Salario do Funcionario Digite os Dados a Seguir: ");
		   				System.out.println("Novo Salario do Funcionario: ");
		   				double salario = in.nextDouble();
		   				System.out.println("CPF do Funcionario :");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.atualizarSalarioFuncionario(salario, cpf);
		   					System.out.println("Salario Atualizado com Sucesso.");
		   				}catch(FuncionarioNaoEncontradoException FNE) {
		   					System.out.println(FNE.getMessage());
		   				}
		   			}
		   		    System.out.println("Escolha uma Nova Operação:");
		   		}
		   		System.out.println("Voce Saiu do RH.");
		   	 }else if(tipoAcesso.equals("Es")){
		   		System.out.println("                  	      BEM VINDO(A) AO ESTOQUE                            	");
		   		System.out.println("                  	    INICIANDO TESTE 1 (INSERIR)                            	");
		   		try {
		   			fachada.inserirProduto(new Produto("nescau", 001, 12.50));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("leite ninho",002, 26.00));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("cafe", 003, 06.20));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("macarrao", 004, 02.40));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("arroz", 005, 04.15));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("feijao", 006, 09.25));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("file", 007, 32.27));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("peito de frango", 010, 16.70));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("contra-file", 011, 14.62));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("sal", 012, 01.00));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		try {
		   			fachada.inserirProduto(new Produto("acucar", 013, 03.11));
		   			System.out.println("Produto inserido com Sucesso.");
		   		}
		   		catch(ProdutoJaCadastradoException PJC){
		   			System.out.println(PJC.getMessage());
		   		}
		   		finally {
		   			System.out.println("----------------- FIM DO TESTE 1 ----------------- ");
					System.out.println("");
					System.out.println("------------ INICIO DO TESTE 2 (REMOVER) ------------- ");
					try {
			   			fachada.removerProduto(010);
			   			System.out.println("Produto removido com Sucesso.");
					}
					catch(ProdutoNaoEncontradoException PNE) {
			   			System.out.println(PNE.getMessage());
			  		}
					try {
						fachada.removerProduto(011);
						System.out.println("Produto removido com Sucesso.");
					}
					catch(ProdutoNaoEncontradoException PNE) {
			   			System.out.println(PNE.getMessage());
			  		}
					try {
						fachada.removerProduto(012);
						System.out.println("Produto removido com Sucesso.");
					}
					catch(ProdutoNaoEncontradoException PNE) {
			   			System.out.println(PNE.getMessage());
			  		}
					try {
						fachada.removerProduto(013);
						System.out.println("Produto removido com Sucesso.");
					}
					catch(ProdutoNaoEncontradoException PNE) {
			   			System.out.println(PNE.getMessage());
			  		}
					try {
						fachada.removerProduto(556);
						System.out.println("Produto removido com Sucesso.");
					}
					catch(ProdutoNaoEncontradoException PNE) {
			   			System.out.println(PNE.getMessage());
			  		}
			   		
			   		finally {
						System.out.println("----------------- FIM DO TESTE 2 ----------------- ");
						System.out.println("");
						System.out.println("---------- INICIO DO TESTE 3 (ATUALIZAR) ------------- ");
						try {
				   			fachada.atualizarNomeProduto(001, "nescau light");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
				   			fachada.atualizarNomeProduto(001, "nescau light");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarNomeProduto(004,"talharim");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarNomeProduto(005,"arroz tio joao");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarNomeProduto(102,"amendoim japones");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarNomeProduto(101,"heineken");
				   			System.out.println("Nome atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(012,01.15);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(013,02.90);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(014,03.00);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(100,29.90);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(101,03.50);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
						try {
							fachada.atualizarPrecoProduto(515,10.16);
				   			System.out.println("Preco atualizado com Sucesso.");
						}
						catch(ProdutoNaoEncontradoException PNE) {
				   			System.out.println(PNE.getMessage());
				  		}
				   		finally {
							System.out.println("----------------- FIM DO TESTE 3 ----------------- ");
							System.out.println("");
						}
					}
		   		}
		   	 }else if(tipoAcesso.equals("C")) {
		   		System.out.println("                  	      BEM VINDO(A) A ABA CLIENTES                            	");
		   		System.out.println("(1) Cadastrar Novo Cliente");
		   		System.out.println("(2) Cancelar Cadastro");
		   		System.out.println("(3) Atualizar Nome de Cliente");
		   		System.out.println("(4) Atualizar Endereco de Cliente");
		   		System.out.println("(5) Finalizar Operacoes");
		   		System.out.println("Escolha uma operacao:");
		   		int operacao = 0;
		   		while(in.hasNextInt() && operacao != 5) {
		   			operacao = in.nextInt();
		   			if(operacao == 1) {
		   				System.out.println("Para Cadastrar Digite os Dados do Novo Cliente:");
		   				System.out.println("Nome Completo do Cliente: ");
		   				String nome = in.nextLine();
		   				while(nome.equals("")) {
		   					nome = in.nextLine();
		   				}
		   				System.out.println("CPF do Cliente: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				System.out.println("Endereco do Cliente: ");
		   				String endereco = in.nextLine();
		   				while(endereco.equals("")) {
		   					endereco = in.nextLine();
		   				}
		   				try {
		   					fachada.cadastrarCliente(nome, cpf, endereco);
		   					System.out.println("Cliente Cadastrado com Sucesso.");
		   				}catch(ClienteJaCadastradoException CJC) {
		   					System.out.println(CJC.getMessage());
		   				}
		   			}else if(operacao == 2) {
		   				System.out.println("Para o Cancelamento do Cadastro Digite o CPF: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.encerrarCadastroCliente(cpf);
		   					System.out.println("Cancelamento Efetuado com Sucesso.");
		   				}catch(ClienteNaoEncontradoException CNE) {
		   					System.out.println(CNE.getMessage());
		   				}
		   			}else if(operacao == 3) {
		   				System.out.println("Para Atualizar o Nome do Cliente Digite os Dados a Seguir: ");
		   				System.out.println("Nome Completo Para Correcao: ");
		   				String nome = in.nextLine();
		   				while(nome.equals("")) {
		   					nome = in.nextLine();
		   				}
		   				System.out.println("CPF do Cliente: ");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.atualizarNomeCliente(nome, cpf);
		   					System.out.println("Nome Atualizado com Sucesso.");
		   				}catch(ClienteNaoEncontradoException CNE) {
		   					System.out.println(CNE.getMessage());
		   				}
		   			}else if(operacao == 4) {
		   				System.out.println("Para Atualizar o Endereco Digite os Dados a Seguir: ");
		   				System.out.println("Novo Endereco do Cliente: ");
		   				String endereco = in.nextLine();
		   				while(endereco.equals("")) {
		   					endereco = in.nextLine();
		   				}
		   				System.out.println("CPF do Cliente:");
		   				String cpf = in.nextLine();
		   				while(cpf.equals("")) {
		   					cpf = in.nextLine();
		   				}
		   				try {
		   					fachada.atualizarEnderecoCliente(endereco, cpf);
		   					System.out.println("Endereco Atualizado com Sucesso.");
		   				}catch(ClienteNaoEncontradoException CNE) {
		   					System.out.println(CNE.getMessage());
		   				}
		   			}
		   		    System.out.println("Escolha uma Nova Operação:");
		   		}
		   		System.out.println("Voce Saiu da Aba Clientes.");
		   		
		   	 }else if(tipoAcesso.equals("Fo")) {
		   	// variaveis relativas aos DADOS do fornecedor
			String empresaFornecedor = "", CNPJ = "";
			String nomeProduto = "";
			int[] codigoProdutos = new int[2];
			Double precoProduto = 0.0;

			Fachada fachada = new Fachada(tipoRepositorio);// basta alterar para usar com array (a)

			/* CADASTRO DE FORNECEDOR */
			System.out.println("***************************************************************************");
			System.out.println("                         CADASTRO FORNECEDOR                               ");
			System.out.println("***************************************************************************");
			System.out.println("\n");
			// TESTE 1 -> INSERINDO FORNECEDOR NA LISTA/ARRAY
			System.out.println("--------------------------  INICIO TESTE 1  -------------------------------\n");

			fornecedorTest1(fachada);
			System.out.println("Imprimindo fornecedores presentes no REPOSITORIO DE LISTA: ");

			// imprimindo o repositorio (com os 2 fornecedores inseridos)
			fachada.imprimeTodosFornecedores();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");

			// TESTE 2 -> INSERIR FORNECEDOR JA CADASTRADO (EXCEPTION)
			System.out.println("--------------------------  INICIO TESTE 2  -------------------------------\n");
			fornecedorTest2Exc(fachada);
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");

			// TESTE 3 -> CNPJ INVALIDO (EXCEPTION)
			System.out.println("--------------------------  INICIO TESTE 3  ------------------------------\n");
			cadastroFornecedorTest3CNPJExc(fachada);

			/* ALTERA DADOS DO FORNECEDOR */
			System.out.println("***************************************************************************");
			System.out.println("                     ALTERACAO CADASTRO FORNECEDOR                               ");
			System.out.println("***************************************************************************");
			System.out.println("\n");

			// TESTE 1 -> BUSCA FORNECEDOR E ALTERA NOME DA EMPRESA
			System.out.println("--------------------------  INICIO TESTE 1  -------------------------------\n");
			alteraFornecedorTest1(fachada);

			// TESTE 2 -> FORNECEDOR NAO ENCONTRADO (EXCEPTION)
			System.out.println("--------------------------  INICIO TESTE 2  -------------------------------\n");
			alteraFornecedorTest2(fachada);

			/* REMOVE O FORNECEDOR */
			System.out.println("***************************************************************************");
			System.out.println("                   CANCELAMENTO DO CADASTRO FORNECEDOR                               ");
			System.out.println("***************************************************************************");
			System.out.println("");
			// TESTE 1 -> REMOVENDO FORNECEDOR DA LISTA
			System.out.println("--------------------------  INICIO TESTE 1  -------------------------------\n");
			removeFornecedorTest1(fachada);
			// TESTE 2 -> CNPJ INVALIDO (EXCEPTION)
			System.out.println("--------------------------  INICIO TESTE 2  -------------------------------\n");
			removeFornecedorTest2(fachada);

		   	 }//end - fornecedor
			 else if(tipoAcesso.equals("E")) {
		   		 //MC DAG :)
		   	 }else {
		   		 System.out.println("Acesso Invalido.");
		   	 }
		}catch(ErroDeInicializacaoException EdI) {
			System.out.println(EdI.getMessage());
		}
	}//end - main

	// metodo teste exception ao tentar remover fornecedor da lista -> cnpj invalido exception
	public static void removeFornecedorTest2(Fachada fachada) {
		// dados do fornecedor(empresa ja inserida na lista)
		String CNPJ = "123456789123456789";
		String empresaFornecedor = "NEWDistribuidoraSM";

		// removendo a empresa da lista
		try {
			fachada.removeFornecedor(CNPJ);
			fachada.imprimeTodosFornecedores();// imprimindo o fornecedor alterado
		} catch (CnpjInvalidoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("***************************************************************************");
			System.out.println(
					"                   FIM CANCELAMENTO DO CADASTRO FORNECEDOR                               ");
			System.out.println("***************************************************************************");
			System.out.println("\n");
			System.out.println("\n");
		}
	}end - removeFornecedorTest2

	// metodo remove fornecedor da lista/array
	public static void removeFornecedorTest1(Fachada fachada) {
		// dados do fornecedor(empresa ja inserida na lista)
		String CNPJ = "123456789123456789";
		String empresaFornecedor = "NEWDistribuidoraSM";

		// removendo a empresa da lista
		try {
			fachada.removeFornecedor(CNPJ);
			fachada.imprimeTodosFornecedores();// imprimindo o fornecedor alterado
		} catch (CnpjInvalidoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		}

	}//end - removeFornecedorTest1

	// metodo testa exception na alteracao de dados do fornecedor -> fornecedor nao encontrado exception
	public static void alteraFornecedorTest2(Fachada fachada) throws FornecedorNaoEncontradoException {
		// dados do fornecedor:
		String CNPJ = "000000000000000001";
		String empresaFornecedor = "BLA&cia";

		Fornecedor fornecedorTeste = new Fornecedor();
		fornecedorTeste.setCNPJ("000000000000000001");
		fornecedorTeste.setNomeEmpresa("BLA&cia");

		try {
			fachada.procuraFornecedor(CNPJ);
			fachada.atualizaFornecedor(fornecedorTeste);
		} catch (FornecedorNaoEncontradoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("***************************************************************************");
			System.out.println("                   FIM ALTERACAO CADASTRO FORNECEDOR                              ");
			System.out.println("***************************************************************************");
			System.out.println("\n");
			System.out.println("\n");
		}

	}//end - alteraFornecedorTest2

	// metodo altera dados do fornecedor
	public static void alteraFornecedorTest1(Fachada fachada) {

		// dados do fornecedor:
		String CNPJ = "123456789123456789";
		String empresaFornecedor = "NEWDistribuidoraSM";

		Fornecedor fornecedorTeste = new Fornecedor();
		fornecedorTeste.setCNPJ("123456789123456789");
		fornecedorTeste.setNomeEmpresa("NEWDistribuidoraSM");

		// busca o fornecedor na lista, e se o achar, atualiza seus dados
		try {
			fachada.procuraFornecedor(CNPJ);// so continua no try se achar o fornecedor pelo CNPJ
			fachada.atualizaFornecedor(fornecedorTeste);
			fachada.imprimeTodosFornecedores();// imprimindo o fornecedor alterado
		} catch (FornecedorNaoEncontradoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		}

	}//end - alteraFornecedorTest1

	// metodo testa exception fornecedor ja cadastrado
	public static void cadastroFornecedorTest3CNPJExc(Fachada fachada) throws FornecedorJaCadastradoException {
		// dados do fornecedor:
		String CNPJ = "abdy1627384";
		String empresaFornecedor = "DISTltd";

		Fornecedor fornecedorTeste = new Fornecedor();
		fornecedorTeste.setCNPJ("abdy1627384");
		fornecedorTeste.setNomeEmpresa("DISTltd");

		// tentando inserir fornecedor com um cnpj invalido
		try {
			fachada.cadastraFornecedor(fornecedorTeste);
		} catch (CnpjInvalidoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("***************************************************************************");
			System.out.println("                        FIM CADASTRO FORNECEDOR                               ");
			System.out.println("***************************************************************************");
			System.out.println("\n");
			System.out.println("\n");

		}

	}//end - cadastroFornecedorTest3CNPJExc

	// metodo cadastra fornecedor
	public static void fornecedorTest1(Fachada fachada)
			throws CnpjInvalidoException, ProdutoNaoEncontradoException, FornecedorJaCadastradoException {

		// variaveis relativas aos DADOS do fornecedor
		String empresaFornecedor = "", CNPJ = "";
		String nomeProduto = "";
		int[] codigoProdutos = new int[2];
		Double precoProduto = 0.0;

		System.out.println("FORNECEDOR 1: \n");

		// DADOS FORNECEDOR 1
		System.out.println("Informe os dados do Fornecedor: " + "\n" + "1)CNPJ: 123456789123456789 ");
		Fornecedor fornecedor1 = new Fornecedor();
		CNPJ = "123456789123456789";

		System.out.println("2)Nome da empresa: DistribuidoraSM");
		empresaFornecedor = "DistribuidoraSM";

		System.out.println("--------------------Produto 1--------------------");

		System.out.println("a)Nome do Produto: Nescau ");
		nomeProduto = "Nescau";

		System.out.println("b)Codigo do Produto: 1234 ");
		codigoProdutos[0] = 1234;

		System.out.println("c)Preço do Produto: R$3,50");
		precoProduto = 3.5;
		Produto produto = null;// produto a ser inserido no repositorio Lista Produto
		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[0]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("--------------------Produto 2--------------------");

		System.out.println("a)Nome do Produto: Diamante Negro");
		nomeProduto = "Diamante Negro";

		System.out.println("b)Codigo do Produto: 5678");
		codigoProdutos[1] = 5678;

		System.out.println("c)Preço do Produto: 3,45");
		precoProduto = 3.45;

		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[1]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("**************************************************************************");
		System.out.println("                          FIM DA LISTA DE PRODUTOS");
		System.out.println("**************************************************************************");

		// tentando inserir o fornecedor e seus produtos no Repositorio do tipo Lista

		try {

			Produto produto1 = fachada.getProduto(codigoProdutos[0]);
			Produto produto2 = fachada.getProduto(codigoProdutos[1]);
			// inserindo dados do fornecedor
			fornecedor1.setCNPJ(CNPJ);
			fornecedor1.setNomeEmpresa(empresaFornecedor);
			fornecedor1.adicionarProduto(produto1);
			fornecedor1.adicionarProduto(produto2);
			fachada.cadastraFornecedor(fornecedor1);

		} catch (FornecedorJaCadastradoException exc) {
			exc.printStackTrace();
		} catch (ProdutoNaoEncontradoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("\n");

			System.out.println("--------------------------------------------------------------------------");
		}
		System.out.println("\n");
		// DADOS FORNECEDOR 2
		System.out.println("FORNECEDOR 2: \n");

		// DADOS FORNECEDOR 1
		System.out.println("Informe os dados do Fornecedor: " + "\n" + "1)CNPJ: 345672891029384756 ");
		fornecedor1 = new Fornecedor();
		CNPJ = "345672891029384756";

		System.out.println("2)Nome da empresa: Distribuidora&Cia");
		empresaFornecedor = "Distribuidora&Cia";

		System.out.println("--------------------Produto 1--------------------");

		System.out.println("a)Nome do Produto: Skol Beats ");
		nomeProduto = "Skol Beats";

		System.out.println("b)Codigo do Produto: 5647 ");
		codigoProdutos[0] = 5647;

		System.out.println("c)Preço do Produto: R$4,50");
		precoProduto = 4.5;
		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[0]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("--------------------Produto 2--------------------");

		System.out.println("a)Nome do Produto: Doritos");
		nomeProduto = " Doritos";

		System.out.println("b)Codigo do Produto: 7773");
		codigoProdutos[1] = 7773;

		System.out.println("c)Preço do Produto: 3,50");
		precoProduto = 3.50;

		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[1]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("**************************************************************************");
		System.out.println("                          FIM DA LISTA DE PRODUTOS");
		System.out.println("**************************************************************************");

		try {

			Produto produto1 = fachada.getProduto(codigoProdutos[0]);
			Produto produto2 = fachada.getProduto(codigoProdutos[1]);
			// inserindo dados do fornecedor
			fornecedor1.setCNPJ(CNPJ);
			fornecedor1.setNomeEmpresa(empresaFornecedor);
			fornecedor1.adicionarProduto(produto1);
			fornecedor1.adicionarProduto(produto2);
			fachada.cadastraFornecedor(fornecedor1);

		} catch (FornecedorJaCadastradoException exc) {
			exc.printStackTrace();
		} catch (ProdutoNaoEncontradoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("\n");

			System.out.println("--------------------------------------------------------------------------");
		}
	}// end - fornecedorTest1


	// metodo testa exception -> FORNECEDOR JA CADASTRADO
	public static void fornecedorTest2Exc(Fachada fachada)
			throws CnpjInvalidoException, ProdutoNaoEncontradoException, FornecedorJaCadastradoException {
		// variaveis relativas aos DADOS do fornecedor
		String empresaFornecedor = "", CNPJ = "";
		String nomeProduto = "";
		int[] codigoProdutos = new int[2];
		Double precoProduto = 0.0;

		// DADOS FORNECEDOR 1
		System.out.println("Informe os dados do Fornecedor: " + "\n" + "1)CNPJ: 123456789123456789 ");
		Fornecedor fornecedor1 = new Fornecedor();
		CNPJ = "123456789123456789";

		System.out.println("2)Nome da empresa: DistribuidoraSM");
		empresaFornecedor = "DistribuidoraSM";

		System.out.println("--------------------Produto 1--------------------");

		System.out.println("a)Nome do Produto: Nescau ");
		nomeProduto = "Nescau";

		System.out.println("b)Codigo do Produto: 1234 ");
		codigoProdutos[0] = 1234;

		System.out.println("c)Preço do Produto: R$3,50");
		precoProduto = 3.5;
		Produto produto = null;// produto a ser inserido no repositorio Lista Produto
		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[0]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("--------------------Produto 2--------------------");

		System.out.println("a)Nome do Produto: Diamante Negro");
		nomeProduto = "Diamante Negro";

		System.out.println("b)Codigo do Produto: 5678");
		codigoProdutos[1] = 5678;

		System.out.println("c)Preço do Produto: 3,45");
		precoProduto = 3.45;

		// inserindo os atributos do produto a ser inserido na lista de produtos

		produto = new Produto();

		produto.setNome(nomeProduto);
		produto.setCodigo(codigoProdutos[1]);
		produto.setPreco(precoProduto);

		try {// tentando inserir o produto na lista de produtos
			fachada.inserir(produto);

		} catch (ProdutoJaCadastradoException exc) {// se nao conseguir, lance a excecao
			exc.printStackTrace();
		}

		System.out.println("**************************************************************************");
		System.out.println("                          FIM DA LISTA DE PRODUTOS");
		System.out.println("**************************************************************************");

		// tentando inserir o fornecedor e seus produtos no Repositorio do tipo Lista

		try {

			Produto produto1 = fachada.getProduto(codigoProdutos[0]);
			Produto produto2 = fachada.getProduto(codigoProdutos[1]);
			// inserindo dados do fornecedor
			fornecedor1.setCNPJ(CNPJ);
			fornecedor1.setNomeEmpresa(empresaFornecedor);
			fornecedor1.adicionarProduto(produto1);
			fornecedor1.adicionarProduto(produto2);
			fachada.cadastraFornecedor(fornecedor1);

		} catch (FornecedorJaCadastradoException exc) {
			exc.printStackTrace();
		} catch (ProdutoNaoEncontradoException exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("\n");
		}
		System.out.println("\n");

	}// end - fornecedorTest2Exc
}//end class
