package apl.sh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import apl.sh.controller.config.BdConnection;
import apl.sh.controller.config.DbException;
import apl.sh.controller.config.DbIntegrityException;
import apl.sh.controller.interfaces.ClienteDAO;
import apl.sh.model.Cliente;

public class ClienteOp implements ClienteDAO{

	private Connection conn;
	
	public ClienteOp(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void Cadastrar(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO Cliente(nome, telefone, email) VALUES (?, ?, ?);"
					, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getTelefone());
			st.setString(3, cliente.getEmail());
			
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					cliente.setId(id);
				}
			}else {
				throw new DbException("Erro: nenhuma linha foi afetada");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			BdConnection.closeStatement(st);
		}
	}


	
	@Override
	public void Alterar(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE Cliente SET nome=?, telefone=?, email=? WHERE id = ?");
			
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getEmail());
			st.setString(3, cliente.getTelefone());
			st.setInt(4, cliente.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			BdConnection.closeStatement(st);
		}
	}

	@Override
	public void Excluir(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM Cliente WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			BdConnection.closeStatement(st);
		}
	}

	@Override
	public Cliente ListarUnico(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Cliente WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				return cliente;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			BdConnection.closeStatement(st);
			BdConnection.closeResultSet(rs);
		}
	}

	@Override
	public List<Cliente> ListarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
