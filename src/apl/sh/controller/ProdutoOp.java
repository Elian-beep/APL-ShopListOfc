package apl.sh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apl.sh.controller.config.BdConnection;
import apl.sh.controller.config.DbException;
import apl.sh.controller.interfaces.ProdutoDAO;
import apl.sh.model.Produto;
import apl.sh.model.Supermercado;

public class ProdutoOp implements ProdutoDAO{

	private Connection conn;
	
	public ProdutoOp(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Produto> Listartodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Produto ORDER BY id");
			rs = st.executeQuery();

			List<Produto> list = new ArrayList<>();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setSupermercadoId(rs.getInt("supermercadoId"));
				list.add(produto);
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

	@Override
	public List<Produto> ListarPorSupermercado(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Produto WHERE supermercadoId = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			List<Produto> list = new ArrayList<>();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setSupermercadoId(rs.getInt("supermercadoId"));
				list.add(produto);
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

	@Override
	public Produto Listar(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Produto WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setSupermercadoId(rs.getInt("supermercadoId"));
				return produto;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			BdConnection.closeStatement(st);
			BdConnection.closeResultSet(rs);
		}
	}
	
}
