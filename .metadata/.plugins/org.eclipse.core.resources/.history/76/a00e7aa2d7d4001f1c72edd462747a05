package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.connection.DatabaseConnection;
import model.entity.Pedidos;
import model.entity.Usuario;

public class DatabaseUserImp implements DatabaseUserDAO{
	
	private static final String CRIAR_BANCO = "CREATE DATABASE prova";
	private static final String CREATE_TABLE_USER = "\n"
			+ "CREATE TABLE usuario(\n"
			+ "	login VARCHAR(50),\n"
			+ "    senha VARCHAR(45),\n"
			+ "    \n"
			+ "    PRIMARY KEY (login)\n"
			+ ")";
	
	private static final String CREATE_TABLE_PEDIDOS = "\n"
			+ "CREATE TABLE pedidos(\n"
			+ "	id_pedidos INT,\n"
			+ "    nomeCliente VARCHAR(145),\n"
			+ "    enderecoEntrega VARCHAR(200),\n"
			+ "    valor DECIMAL(10, 2),\n"
			+ "    descricao VARCHAR(300),\n"
			+ "    login VARCHAR(50),\n"
			+ "    \n"
			+ "    PRIMARY KEY (id_pedidos),\n"
			+ "    FOREIGN KEY (login) REFERENCES usuario(login) ON DELETE CASCADE\n"
			+ "    ON UPDATE CASCADE \n"
			+ "    \n"
			+ ")";
	
	private static final String INSERT_USER = "INSERT INTO user_tb(login, senha) VALUES(?, ?)";
	private static final String SELECT_USER = "SELECT * FROM usuario WHERE login = ?";
	
	
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
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public List<Pedidos> listarTOdosPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedidos> mostrarPedidoUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarPedido(Pedidos pedido) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
