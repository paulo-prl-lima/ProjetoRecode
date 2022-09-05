package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Destino;
	
public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void salvar(Destino destino) {
		String sql = "INSERT INTO destino(nome,hotel,descricao,valor,id_cliente,id_promocao) VALUES(?,?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			
			pstm.setString(2, destino.getHotel());
			
			pstm.setString(3, destino.getDescricao());
			
			pstm.setDouble(4, destino.getValor());
			pstm.setInt(5, destino.getId_cliente());
			pstm.setInt(6, destino.getId_promocao());
			
			
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

	public void atualizar(Destino destino) {
		String sql = "UPDATE destino SET nome = ?, hotel = ?, descricao = ?, valor=? WHERE id_destino = ?";
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome());

			pstm.setString(2, destino.getHotel());

			pstm.setString(3, destino.getDescricao());

			pstm.setDouble(4, destino.getValor());
			
			pstm.setInt(5, destino.getId_destino());

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

	public void remover(int id_destino) {

		String sql = "DELETE FROM destino WHERE id_destino = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);
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
	
	public List<Destino> getDestinos() {
		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Destino destino = new Destino();
				
				destino.setId_destino(rset.getInt("id_destino"));
				
				destino.setNome(rset.getString("nome"));
				
				destino.setHotel(rset.getNString("hotel"));
				
				destino.setDescricao(rset.getNString("descricao"));
				
				destino.setValor(rset.getDouble("valor"));
				
				destino.setId_cliente(rset.getInt("id_cliente"));
				
				destino.setId_promocao(rset.getInt("id_promocao"));
					
				// adiciona o contato recuperado, a lista de contato
				destinos.add(destino);
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
		
		return destinos;
	}


	

	
}
