package model.entity;

public class Pedidos {

	private int idPedidos;
	private String nomeCliente;
	private String enderecoEntrega;
	private Long valor;
	private String descricao;
	private Usuario user;
	
	
	public Pedidos(String nomeCliente, String enderecoEntrega, Long valor, String descricao, Usuario user) {
		super();
		this.nomeCliente = nomeCliente;
		this.enderecoEntrega = enderecoEntrega;
		this.valor = valor;
		this.descricao = descricao;
		this.user = user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdPedidos() {
		return idPedidos;
	}
	public void setIdPedidos(int idPedidos) {
		this.idPedidos = idPedidos;
	}
	
	
	
	
	
}
