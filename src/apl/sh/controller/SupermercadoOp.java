package apl.sh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import apl.sh.controller.config.BdConnection;
import apl.sh.controller.config.DbException;
import apl.sh.controller.interfaces.SupermercadoDAO;
import apl.sh.model.Cliente;
import apl.sh.model.Supermercado;

public class SupermercadoOp implements SupermercadoDAO{

	private Connection conn;
	
	public SupermercadoOp(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Supermercado ListarUnico(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Supermercado WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Supermercado supermercado = new Supermercado();
				supermercado.setId(rs.getInt("id"));
				supermercado.setNome(rs.getString("nome"));
				supermercado.setCnpj(rs.getString("cnpj"));
				supermercado.setEmail(rs.getString("email"));
				supermercado.setTelefone(rs.getString("telefone"));
				return supermercado;
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
	public List<Supermercado> ListarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Supermercado ORDER BY id");
			rs = st.executeQuery();

			List<Supermercado> list = new ArrayList<>();

			while (rs.next()) {
				Supermercado supermercado = new Supermercado();
				supermercado.setId(rs.getInt("id"));
				supermercado.setNome(rs.getString("nome"));
				supermercado.setCnpj(rs.getString("cnpj"));
				supermercado.setEndereco(rs.getString("endereco"));
				supermercado.setTelefone(rs.getString("telefone"));
				supermercado.setEmail(rs.getString("email"));
				list.add(supermercado);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			BdConnection.closeStatement(st);
			BdConnection.closeResultSet(rs);
		}
	}

}
