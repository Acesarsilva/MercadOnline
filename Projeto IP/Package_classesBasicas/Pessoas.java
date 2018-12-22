package classesBasicas;
abstract class Pessoas {
	 private String nome;
	 private String cpf;
	    Pessoas(String nome, String cpf){
	        this.nome = nome;
	        this.cpf = cpf;
	    }
	    public String getNomePessoa() {
	        return nome;
	    }
	    public void setNomePessoa(String nome) {
	        this.nome = nome;
	    }
	    public String getCpfPessoa() {
	        return cpf;
	    }
	    public void setCpfPessoa(String cpf) {
	        this.cpf = cpf;
	    }   
}
