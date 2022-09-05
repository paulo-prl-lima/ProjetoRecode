package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void salvar(Cliente cliente) {

		String sql = "INSERT INTO cliente(nome,endereco,telefone)" + " VALUES(?,?,?)";
		try {

			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getNome());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cliente.getEndereco());

			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, cliente.getTelefone());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void remover(int id_cliente) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_cliente);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE id_cliente = ?";
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());

			pstm.setString(2, cliente.getEndereco());

			pstm.setString(3, cliente.getTelefone());

			pstm.setInt(4, cliente.getId_cliente());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Cliente cliente = new Cliente();

				
				cliente.setId_cliente(rset.getInt("id_cliente"));

				
				cliente.setNome(rset.getString("nome"));

				
				cliente.setEndereco(rset.getNString("endereco"));

				
				cliente.setTelefone(rset.getNString("telefone"));

				// adiciona o contato recuperado, a lista de contato
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		
		return clientes;
	}
}
