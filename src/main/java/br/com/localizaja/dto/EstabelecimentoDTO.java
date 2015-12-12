/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localizaja.dto;

import br.com.localizaja.entidade.CoordenadasGeograficas;
import br.com.localizaja.entidade.Endereco;
import br.com.localizaja.entidade.Estabelecimento;
import br.com.localizaja.entidade.Seguimento;

/**
 *
 * @author Daniel
 */
public class EstabelecimentoDTO {

    private String nomeEmpresa;
    private String endereco;
    private String cidade;
    private String estado;
    private String categoria;
    private Double latitude;
    private Double longitude;

    public Estabelecimento toEstabelecimento() {
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(nomeEmpresa);

        for (String nome : categoria.split(",")) {
            Seguimento seguimento = new Seguimento();
            seguimento.setNome(nome);
            seguimento.setEstabelecimento(estabelecimento);
            estabelecimento.adicionarSeguimento(seguimento);
        }

        Endereco end = new Endereco();
        end.setEnderecoCompleto(endereco);
        end.setCoordenadasGeograficas(new CoordenadasGeograficas(latitude, longitude));
        end.setEstabelecimento(estabelecimento);
        estabelecimento.setEndereco(end);

        return estabelecimento;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
