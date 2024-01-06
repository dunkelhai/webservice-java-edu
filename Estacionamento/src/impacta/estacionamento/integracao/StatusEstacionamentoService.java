package impacta.estacionamento.integracao;

import impacta.estacionamento.integracao.StatusBean;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface StatusEstacionamentoService {

    @WebMethod
    public StatusBean getStatus();


}
