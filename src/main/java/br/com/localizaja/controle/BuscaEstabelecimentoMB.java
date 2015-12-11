package br.com.localizaja.controle;

import br.com.localizaja.modelo.EstabelecimentoDAO;
import br.com.localizaja.modelo.GeoLocation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author eyvdmw
 */
@Getter
@Setter
@ManagedBean
@ViewScoped
public class BuscaEstabelecimentoMB {

    private List<GeoLocation> resultadoEnderecos;
    private EstabelecimentoDAO empresa = new EstabelecimentoDAO();
    private GeoLocation enderecoSelecionado;

    private int raio;
    private String segmento;
    private String enderecoInicial;

//    public void buscarEnderecos() {
//        try {
//            resultadoEnderecos = Servico.getCoordenadasGeograficas(empresa.getEndereco() + " " + empresa.getCidade() + " " + empresa.getEstado());
//        } catch (Exception ex) {
//            resultadoEnderecos = null; 
//            Logger.getLogger(CadastroEstabelecimentoMB.class.getName(
//            )).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void cadastrarEndereco(){
//        System.out.println("ENDERECOOOO: " + enderecoSelecionado.getEnderecoCompleto());
//    }
//    }
    public String goToCadastro() {
        return "cadastro_estabelecimento.xhtml";
    }
}
