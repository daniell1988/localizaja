package br.com.localizaja.controle;

import br.com.localizaja.modelo.GeoLocation;
import java.util.ArrayList;
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
    private String nomeEmpresa;
    private String endereco;
    private String cidade;
    private String estado;
    private String categoria;
    private Double latitude;
    private Double longitude;
    
    
    public void buscarEnderecos(){
        
        try {
            resultadoEnderecos = new ArrayList<GeoLocation>();
            resultadoEnderecos = Servico.getCoordenadasGeograficas(endereco + " " + cidade + " " + estado);
            System.out.println("a");
        } catch (Exception ex) {
            resultadoEnderecos = null; 
            Logger.getLogger(CadastroEstabelecimentoMB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
