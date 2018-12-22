package classesBasicas;
public class Entrega {
	private Clientes cliente;
	private String pedido;

	Entrega(Clientes cliente, String pedido) {
		this.cliente = cliente;
		this.pedido = pedido;
	}
	public String getPedidoEntrega() {
		return this.pedido;
	}

	public void setPedidoEntrega(String pedido) {
		this.pedido = pedido;
	}

	public String getEnderecoEntrega() {
		return this.cliente.getEnderecoCliente();
	}

	public String getNomeClienteEntrega() {
		return this.cliente.getNomePessoa();
	}

	public String getCpfClienteEntrega() {
		return this.cliente.getCpfPessoa();
	}
}
