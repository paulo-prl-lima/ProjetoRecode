package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Promocao;

public class PromocaoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void salvar(Promocao promocao) {

		String sql = "INSERT INTO promocao(nomePacote,observacao,percentual)" + " VALUES(?,?,?)";
		try {

			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, promocao.getNomePacote());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, promocao.getObservacao());

			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDouble(3, promocao.getPercentual());

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
	
	public void remover(int id_promocao) {

		String sql = "DELETE FROM promocao WHERE id_promocao = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_promocao);
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

	public void atualizar(Promocao promocao) {
		String sql = "UPDATE promocao SET nomePacote = ?, observacao = ?, percentual = ? WHERE id_promocao = ?";
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, promocao.getNomePacote());

			pstm.setString(2, promocao.getObservacao());

			pstm.setDouble(3, promocao.getPercentual());

			pstm.setInt(4, promocao.getId_promocao());

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

	public List<Promocao> getPromocoes() {
		String sql = "SELECT * FROM promocao";

		List<Promocao> promocoes = new ArrayList<Promocao>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Promocao promocao = new Promocao();

				
				promocao.setId_promocao(rset.getInt("id_promocao"));

				
				promocao.setNomePacote(rset.getString("nomePacote"));

				
				promocao.setObservacao(rset.getString("observacao"));

				
				promocao.setPercentual(rset.getDouble("percentual"));
				// adiciona o contato recuperado, a lista de contato
				promocoes.add(promocao);
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
		
		return promocoes;
	}


}
