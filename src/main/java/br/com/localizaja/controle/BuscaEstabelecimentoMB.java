package br.com.localizaja.controle;

import br.com.localizaja.servico.Servico;
import br.com.localizaja.dto.EstabelecimentoDTO;
import br.com.localizaja.dto.GeoLocation;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.GeocodeEvent;

/**
 *
 * @author eyvdmw
 */
@ManagedBean
@ViewScoped
public class BuscaEstabelecimentoMB {

    private List<GeoLocation> resultadoEnderecos;
    private EstabelecimentoDTO empresa = new EstabelecimentoDTO();
    private GeoLocation enderecoSelecionado;

    private int raio;
    private String segmento;
    private String enderecoInicial;

    public void buscarEnderecos(GeocodeEvent event) {
        try {
            resultadoEnderecos = Servico.getCoordenadasGeograficas(enderecoInicial);
        } catch (Exception ex) {
            resultadoEnderecos = null;
        }
    }

    public String goToCadastro() {
        return "cadastro_estabelecimento.xhtml";
    }

    public List<GeoLocation> getResultadoEnderecos() {
        return resultadoEnderecos;
    }

    public void setResultadoEnderecos(List<GeoLocation> resultadoEnderecos) {
        this.resultadoEnderecos = resultadoEnderecos;
    }

    public EstabelecimentoDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EstabelecimentoDTO empresa) {
        this.empresa = empresa;
    }

    public GeoLocation getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(GeoLocation enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getEnderecoInicial() {
        return enderecoInicial;
    }

    public void setEnderecoInicial(String enderecoInicial) {
        this.enderecoInicial = enderecoInicial;
    }

}
