package br.com.localizaja.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoLocation {

    private Double latitute;
    private Double longitute;
    private String enderecoCompleto;

    public GeoLocation() {
    }

    public GeoLocation(Double latitute, Double longitute, String enderecoCompleto) {
        this.latitute = latitute;
        this.longitute = longitute;
        this.enderecoCompleto = enderecoCompleto;
    }

    public GeoLocation build() {
        return new GeoLocation(latitute, longitute, enderecoCompleto);
    }
}
