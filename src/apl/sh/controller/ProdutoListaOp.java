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
import apl.sh.controller.config.DbIntegrityException;
import apl.sh.controller.interfaces.ProdutoListaDAO;
import apl.sh.model.ListaCompra;
import apl.sh.model.Produto;

public class ProdutoListaOp implements ProdutoListaDAO{
	private Connection conn;

	public ProdutoListaOp(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void Cadastrar(Produto produto) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO ProdutoLista(nome, valor, quantidade, supermercadoId) VALUES (?, ?, ?, ?);"
					, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, produto.getNome());
			st.setDouble(2, produto.getValor());
			st.setInt(3, produto.getQuantidade());
			st.setInt(4, produto.getSupermercadoId());
			
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					produto.setId(id);
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
	public void Excluir(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM ProdutoLista WHERE Id = ?");

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
	public List<Produto> ListarPorSupermercado(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM ProdutoLista WHERE supermercadoId = ?");
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
	public List<Produto> ListarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM ProdutoLista ORDER BY id");
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
}