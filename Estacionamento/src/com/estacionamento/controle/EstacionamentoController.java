package com.estacionamento.controle;

import com.estacionamento.integracao.StatusBean;
import com.estacionamento.persistencia.DAOEstacionamento;
import com.estacionamento.negocio.Vaga;

/**
 * Classe controladora que coordena todo o fluxo da informação
 * e eventos do sistema.
 */
public class EstacionamentoController {

	/**
	 * Recupera o status das vagas do estacionamento
	 *
	 * @return status atual de vagas ocupadas no estaciomento
	 */
	public static int inicializarVagasOcupadas() {
		return new DAOEstacionamento().getVagasOcupadas();
	}

	public StatusBean getStatusDia() {
		StatusBean bean = null;

		int livres = Vaga.livres();
		int ocupadas = Vaga.getOcupadas();
		double faturamento = new DAOEstacionamento().getFaturamentoCorrente();

		bean = new StatusBean(livres, ocupadas, faturamento);

		return bean;
	}
}
