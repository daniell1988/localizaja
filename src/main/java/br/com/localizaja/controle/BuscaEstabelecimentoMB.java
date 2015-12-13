package br.com.localizaja.controle;

import br.com.localizaja.dto.BuscaEstabelecimentoDTO;
import br.com.localizaja.servico.Servico;
import br.com.localizaja.dto.GeoLocation;
import br.com.localizaja.util.FacesMessageUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author eyvdmw
 */
@ManagedBean
@ViewScoped
public class BuscaEstabelecimentoMB {

    @EJB
    private Servico servico;

    private List<GeoLocation> resultadoEnderecos;
    private BuscaEstabelecimentoDTO empresa = new BuscaEstabelecimentoDTO();
    private GeoLocation enderecoSelecionado;

    public void buscarMinhaLocalizacao() {
        try {
            GeoLocation endereco = servico.getEndereco(empresa.getLatitude(), empresa.getLongitude());
            empresa.setEnderecoOrigem(endereco.getEnderecoCompleto());
        } catch (Exception ex) {
            FacesMessageUtil.addMensagemError("Não foi possível obter a localização: " + ex);
            ex.printStackTrace();
            resultadoEnderecos = null;
        }
    }

    public void buscarEnderecos() {
        try {
            resultadoEnderecos = servico.getCoordenadasGeograficas(empresa.getEnderecoOrigem());
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessageUtil.addMensagemError("Não foi possível buscar endereços: " + ex);
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

    public BuscaEstabelecimentoDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(BuscaEstabelecimentoDTO empresa) {
        this.empresa = empresa;
    }

    public GeoLocation getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(GeoLocation enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }
}
