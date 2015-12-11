package br.com.localizaja.controle;

import br.com.localizaja.modelo.Empresa;
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
    private Empresa empresa = new Empresa();
    private GeoLocation enderecoSelecionado;

    
    
    public void buscarEnderecos(){
        
        try {
//            resultadoEnderecos = new ArrayList<GeoLocation>();
            resultadoEnderecos = Servico.getCoordenadasGeograficas(empresa.getEndereco() + " " + empresa.getCidade() + " " + empresa.getEstado());
//            System.out.println("eeend: " + empresa.getEndereco());
        } catch (Exception ex) {
            resultadoEnderecos = null; 
            Logger.getLogger(CadastroEstabelecimentoMB.class.getName(
            )).log(Level.SEVERE, null, ex);
        }

    }
    
}
