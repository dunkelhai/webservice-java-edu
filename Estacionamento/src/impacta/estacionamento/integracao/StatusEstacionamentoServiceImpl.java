package impacta.estacionamento.integracao;

import impacta.estacionamento.controle.EstacionamentoController;

import javax.jws.WebService;

@WebService(endpointInterface = "impacta.estacionamento.integracao.StatusEstacionamentoService")
public class StatusEstacionamentoServiceImpl implements StatusEstacionamentoService{

    @Override
    public StatusBean getStatus() {
        StatusBean bean = new EstacionamentoController().getStatusDia();
        return bean;
    }
}
