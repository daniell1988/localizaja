package br.com.localizaja.controle;

import br.com.localizaja.servico.Servico;
import br.com.localizaja.dto.EstabelecimentoDTO;
import br.com.localizaja.dto.GeoLocation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author eyvdmw
 */
@ManagedBean
@ViewScoped
public class CadastroEstabelecimentoMB {

    @EJB
    private Servico servico;

    private List<GeoLocation> resultadoEnderecos;
    private EstabelecimentoDTO empresa = new EstabelecimentoDTO();
    private GeoLocation enderecoSelecionado;

    public void buscarEnderecos() {
        try {
            resultadoEnderecos = Servico.getCoordenadasGeograficas(empresa.getEndereco() + "," + empresa.getCidade() + "," + empresa.getEstado());
        } catch (Exception ex) {
            resultadoEnderecos = null;
            Logger.getLogger(CadastroEstabelecimentoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cadastrarEndereco() {
        try {
            servico.salvarEstabelecimento(empresa.toEstabelecimento());
            return "/busca_estabelecimento.jsf";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/busca_estabelecimento.jsf";
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
}
