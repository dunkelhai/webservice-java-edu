package impacta.estacionamento.integracao;

import impacta.estacionamento.controle.EstacionamentoController;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
@WebService(endpointInterface = "impacta.estacionamento.integracao.StatusEstacionamentoService")
public class StatusEstacionamentoServiceImpl implements StatusEstacionamentoService{

    @Override
    public StatusBean getStatus() {
        StatusBean bean = new EstacionamentoController().getStatusDia();
        return bean;
    }

    public static void main(String[] args) {
        try {
            System.setProperty("javax.xml.ws.spi.Provider", "com.sun.xml.ws.spi.ProviderImpl");
            Endpoint.publish("http://127.0.0.1:8888/status?WSDL", new StatusEstacionamentoServiceImpl());
            System.out.println("Serviço iniciado");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
