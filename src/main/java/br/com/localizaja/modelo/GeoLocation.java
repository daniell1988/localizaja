package br.com.localizaja.modelo;

/**
 *
 * @author eyvdmw
 */
public class GeoLocation {

    private double latitute;

    private double longitute;

    private String nomeCompleto;

    public GeoLocation() {
    }

    public GeoLocation(double latitute, double longitute, String nomeCompleto) {
        this.latitute = latitute;
        this.longitute = longitute;
        this.nomeCompleto = nomeCompleto;
    }

    public double getLatitute() {
        return latitute;
    }

    public GeoLocation setLatitute(double latitute) {
        this.latitute = latitute;
        return this;
    }

    public double getLongitute() {
        return longitute;
    }

    public GeoLocation setLongitute(double longitute) {
        this.longitute = longitute;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public GeoLocation setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public GeoLocation build() {
        return new GeoLocation(latitute, longitute, nomeCompleto);
    }
}
