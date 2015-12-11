package br.com.localizaja.controle;

import br.com.entidade.Endereco;
import br.com.entidade.Estabelecimento;
import br.com.entidade.Seguimento;
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
public class CadastroEstabelecimentoMB {

    private List<GeoLocation> resultadoEnderecos;
    private EstabelecimentoDAO empresa = new EstabelecimentoDAO();
    private GeoLocation enderecoSelecionado;

    public void buscarEnderecos() {

        try {
            resultadoEnderecos = Servico.getCoordenadasGeograficas(empresa.getEndereco() + " " + empresa.getCidade() + " " + empresa.getEstado());
        } catch (Exception ex) {
            resultadoEnderecos = null;
            Logger.getLogger(CadastroEstabelecimentoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cadastrarEndereco() {

        Estabelecimento estabelecimento = new Estabelecimento();
        Endereco endereco = new Endereco();
        //o certo eh segmento com o g mudo
        Seguimento seguimento = new Seguimento();

        //os dados do formulario ficam no objeto empresa e enderecoSelecionado
        //nao nao precisará ter uma entidade endereco
        //a empresa terá os seguintes atributos: 
        //-endereco(completo do obejto selecionado)
        //-nome da empresa
        //-segmento
        //-latitude
        //-longitude
        endereco.setEndereco(enderecoSelecionado.getEnderecoCompleto());
//        estabelecimento.setSeguimento(seguimento.setNome(empresa.getNomeEmpresa()));;

        System.out.println("ENDERECOOOO: " + enderecoSelecionado.getEnderecoCompleto());

        return "/busca_estabelecimento.jsf";
    }

}
