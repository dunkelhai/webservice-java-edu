package impacta.estacionamento.integracao;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
