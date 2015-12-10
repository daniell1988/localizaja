package br.com.localizaja.controle;

import br.com.localizaja.modelo.GeoLocation;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author eyvdmw
 */
@Stateless
public class Servico {

    private static final String KEY_MAPS = "AIzaSyB9vf8PF7mxi5zV6eRibXUbFSqdhRyiQL8";

    public Servico() {
    }

    /**
     * TODO: Não Ficara aqui!
     *
     * @param endereco
     * @return
     * @throws java.lang.Exception
     */
    public static ArrayList<GeoLocation> getCoordenadasGeograficas(String endereco) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(KEY_MAPS);
        GeocodingResult[] results = GeocodingApi.geocode(context, endereco).await();

        List<GeocodingResult> resultadoEnderecos = Arrays.asList(results);
        ArrayList<GeoLocation> enderecos = new ArrayList<GeoLocation>();
        
        for (GeocodingResult end : resultadoEnderecos) {
            enderecos.add(new GeoLocation(Double.valueOf(end.geometry.location.lat), Double.valueOf(end.geometry.location.lng), end.formattedAddress));
        }

        return enderecos;
    }
}
