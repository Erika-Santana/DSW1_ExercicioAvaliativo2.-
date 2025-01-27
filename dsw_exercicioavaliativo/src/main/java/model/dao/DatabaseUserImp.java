package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.dao.connection.DatabaseConnection;
import model.entity.Pedidos;
import model.entity.Usuario;

public class DatabaseUserImp implements DatabaseUserDAO{
	
	private static final String CRIAR_BANCO = "CREATE DATABASE prova";
	private static final String CREATE_TABLE_USER = "CREATE TABLE usuario(\n"
			+ "	login VARCHAR(50) NOT NULL,\n"
			+ "    senha VARCHAR(45)  NOT NULL,\n"
			+ "    \n"
			+ "    PRIMARY KEY (login)\n"
			+ ");\n";
	
	private static final String CREATE_TABLE_PEDIDOS = "CREATE TABLE pedidos(\n"
			+ "	id_pedidos INT AUTO_INCREMENT,\n"
			+ "    nomeCliente VARCHAR(145) NOT NULL,\n"
			+ "    enderecoEntrega VARCHAR(200)  NOT NULL,\n"
			+ "    valor DECIMAL(10, 2) NOT NULL,\n"
			+ "    descricao VARCHAR(300) NOT NULL,\n"
			+ "    login VARCHAR(50) NOT NULL,\n"
			+ "    \n"
			+ "    PRIMARY KEY (id_pedidos),\n"
			+ "    FOREIGN KEY (login) REFERENCES usuario(login) ON DELETE CASCADE\n"
			+ "    ON UPDATE CASCADE \n"
			+ "    \n"
			+ ")";
	
	private static final String INSERT_USER = "INSERT INTO user_tb(login, senha) VALUES(?, ?)";
	private static final String SELECT_USER = "SELECT * FROM usuario WHERE login = ?";
	private static final String SELECT_PEDIDOS = "SELECT * FROM pedidos";
	private static final String SELECT_PEDIDOS_USER = "SELECT * FROM pedidos WHERE login = ?";
	private static final String INSERT_PEDIDOS = "INSERT INTO pedidos(nomeCliente, enderecoEntrega, valor, descricao, login) VALUES (?, ?, ?, ?, ?)";
	private static final String DELECT_PEDIDOS = "DELETE * FROM pedidos";
	private static final String DELECT_PEDIDOS_USER = "DELETE * FROM pedidos WHERE login = ?";
	private static final String UPDATE_PEDIDOS = "UPDATE pedido SET nomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ?";
	private static final String UPDATE_PEDIDOS_USER = "UPDATE pedido SETnomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ?";
	
	
	@Override
	public boolean cadastrarNovosUsuario(Usuario user) {
		int rows = 0;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(INSERT_USER)){
			
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getSenha());
			
			rows = preparedStatement.executeUpdate();
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0 ;
	}

	@Override
	public Usuario encontrarUsuarioRegistrado(String login) {
		Usuario user = null;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(SELECT_USER)){
			
			preparedStatement.setString(1, login);
			
			ResultSet resultado = preparedStatement.executeQuery();
			
			if (resultado.next()) {
				
				user = new Usuario(resultado.getString("login"), resultado.getString("senha"));	
			}
			
			return new Usuario(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		

	}

	@Override
	public List<Pedidos> listarTodosPedidos() {
		List<Pedidos> listaPedidos = new LinkedList<Pedidos>();
		Pedidos pedido = null;
		Usuario user = null;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(SELECT_PEDIDOS)){
			
			var resultado = preparedStatement.executeQuery();
			//(String nomeCliente, String enderecoEntrega, float valor, String descricao, Usuario user) {
			
			while(resultado.next()) {
				var login = resultado.getString("login");
				user = encontrarUsuarioRegistrado(login);
				pedido = new Pedidos(resultado.getString("nomeCliente"), 
						resultado.getString("enderecoEntrega"), 
						resultado.getLong("valor"), 
						resultado.getString("descricao"),
						user);
				
				listaPedidos.add(pedido);
			}
			
			//Nova lista ou não?
			return listaPedidos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Pedidos> mostrarPedidoUsuario(Usuario user) {
		List<Pedidos> listaPedidos = new LinkedList<Pedidos>();
		Pedidos pedido = null;
		
		try (var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_PEDIDOS_USER)){
			
			preparedStatement.setString(1, user.getLogin());
			
			var resultado = preparedStatement.executeQuery();
			
			while(resultado.next()) {
				var login = resultado.getString("login");
				user = encontrarUsuarioRegistrado(login);
				pedido = new Pedidos(resultado.getString("nomeCliente"), 
						resultado.getString("enderecoEntrega"), 
						resultado.getLong("valor"), 
						resultado.getString("descricao"),
						user);
				
				listaPedidos.add(pedido);
			}
			
			return listaPedidos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean cadastrarPedido(Pedidos pedido){
		
		int row = 0;
		
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(INSERT_PEDIDOS)){
			
	
			
			preparedStatement.setString(1, pedido.getNomeCliente());
			preparedStatement.setString(2, pedido.getEnderecoEntrega());
			preparedStatement.setLong(3, pedido.getValor());
			preparedStatement.setString(4, pedido.getDescricao());
			preparedStatement.setString(5, pedido.getUser().getLogin());
			
			row = preparedStatement.executeUpdate();
			
			return row > 0;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
