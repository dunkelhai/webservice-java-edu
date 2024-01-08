package impacta.estacionamento.integracao;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class StatusBean {

    @XmlElement
    private int vagasLivres;

    @XmlElement
    private int vagasOcupadas;

    @XmlElement
    private double faturamentoDia;

    public StatusBean() {
    }

    public StatusBean(int vagasLivres, int vagasOcupadas, double faturamentoDia) {
        this.vagasLivres = vagasLivres;
        this.vagasOcupadas = vagasOcupadas;
        this.faturamentoDia = faturamentoDia;
    }

    public int getVagasLivres() {
        return vagasLivres;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public double getFaturamentoDia() {
        return faturamentoDia;
    }
}
