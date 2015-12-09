package br.com.controle;

import br.com.modelo.GeoLocation;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
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
    public static GeoLocation getCoordenadasGeograficas(String endereco) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(KEY_MAPS);
        GeocodingResult[] results = GeocodingApi.geocode(context, endereco).await();

        return new GeoLocation().
                setLatitute(results[0].geometry.location.lat).
                setLongitute(results[0].geometry.location.lng).
                setNomeCompleto(results[0].formattedAddress).
                build();
    }

    public static void main(String[] args) throws Exception {
        GeoLocation casa = getCoordenadasGeograficas("Rua Benedito Alves Moreira, 75, São José dos Campos");
        System.out.println("Latitude: " + casa.getLatitute());
        System.out.println("Longitude: " + casa.getLongitute());
        System.out.println("Nome: " + casa.getNomeCompleto());
    }
}
