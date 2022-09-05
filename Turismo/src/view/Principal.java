package view;

import controller.ClienteDAO;
import controller.DestinoDAO;
import controller.PromocaoDAO;
import model.Destino;

public class Principal {

	public static void main(String[] args) {

		// ########################//
		// ####TABELA CLIENTE####//
		// ########################//

		ClienteDAO clienteDAO = new ClienteDAO();

		// ---CRIA E SALVA CLIENTE---

		/*
		 * Cliente cliente = new Cliente(); cliente.setNome("Fabio");
		 * cliente.setEndereco("Rua Ana X"); cliente.setTelefone("81-9895-3658");
		 * 
		 * clienteDAO.salvar(cliente);
		 */

		// ---ATUALIZA CLIENTE---
		/*
		 * Cliente cliente1 = new Cliente(); cliente1.setId_cliente(3);
		 * cliente1.setNome("Fabiana Souza"); cliente1.setEndereco("Rua da PAz");
		 * cliente1.setTelefone("(81)9868-4578");
		 * 
		 * clienteDAO.atualizar(cliente1);
		 */

		// ---REMOVE CLIENTE---
		// clienteDAO.remover(4);

		// ---EXIBI CLIENTE CLIENTE---

		/*
		 * for (Cliente c : clienteDAO.getClientes()) { System.out.println("ID: " +
		 * c.getId_cliente()); System.out.println("Nome: " + c.getNome());
		 * System.out.println("Endereço: " + c.getEndereco());
		 * System.out.println("Telefone: " + c.getTelefone());
		 * System.out.println("---------------------------------------"); }
		 */

		// ########################//
		// ####TABELA PROMOCAO####//
		// ########################//

		PromocaoDAO promocaoDAO = new PromocaoDAO();

		// ---CRIA E SALVA PROMOÇÃO---

		/*
		 * 
		 * Promocao promocao = new Promocao(); promocao.setNomePacote("Verão 15");
		 * promocao.setObservacao("sem almoço	"); promocao.setPercentual(15);
		 * promocaoDAO.salvar(promocao);
		 */

		// ---ATUALIZA PROMOCAO---

		/*
		 * Promocao promocao1 = new Promocao(); promocao1.setId_promocao(1);
		 * promocao1.setNomePacote("Verão kids 2");
		 * promocao1.setObservacao("Para menores de 20 anos");
		 * promocao1.setPercentual(13);
		 * 
		 * promocaoDAO.atualizar(promocao1);
		 * 
		 */
		// ---REMOVE PROMOCAO---
		// promocaoDAO.remover(5);

		// ---RELATÓRIO PROMOCAO

		/*
		 * for (Promocao p : promocaoDAO.getPromocoes()) { System.out.println("ID: " +
		 * p.getId_promocao()); System.out.println("Nome: " + p.getNomePacote());
		 * System.out.println("Desconto: " + p.getPercentual() + "%");
		 * System.out.println("Observação: " + p.getObservacao());
		 * System.out.println("---------------------------------------"); }
		 */
		// #######################################//
		// ############TABELA DESTINO############//
		// #######################################//

		DestinoDAO destinoDAO = new DestinoDAO();

		// ---CRIA E SALVA DESTINO---

		/*
		 * Destino destino = new Destino(); destino.setNome("PRAIA de Piedade");
		 * destino.setDescricao("Teste"); destino.setHotel("Brisa e Mar");
		 * destino.setValor(600); destino.setId_cliente(1); destino.setId_promocao(2);
		 * destinoDAO.salvar(destino);
		 */

		// ---ATUALIZA DESTINO---

		/*
		 * Destino destino1 = new Destino(); destino1.setId_destino(1);
		 * destino1.setHotel("Verdes Mares"); destino1.setNome("Verão 12");
		 * destino1.setDescricao("válida apenas para casal"); destino1.setValor(400);
		 * destino1.getValorTotal();
		 * 
		 * destinoDAO.atualizar(destino1);
		 */

		// ---REMOVE DESTINO---

		// destinoDAO.remover(2);

		// ---RELATORIO DESTINO---

		for (Destino d : destinoDAO.getDestinos()) {
			System.out.println("ID: " + d.getId_destino());
			System.out.println("Nome: " + d.getNome());
			System.out.println("Hotel: " + d.getHotel());
			System.out.println("Observação: " + d.getDescricao());
			System.out.println("Valor: " + d.getDescricao());
			System.out.println("ID Cliente: " + d.getId_cliente());
			System.out.println("ID Promocao: " + d.getId_promocao());
			System.out.println("---------------------------------------");
		}
	}
}
