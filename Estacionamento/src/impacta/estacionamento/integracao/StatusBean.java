package impacta.estacionamento.integracao;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatusBean {

    @XmlElement
    private int vagasLivres;
    
    @XmlElement
    private int vagasOcupadas;
}
