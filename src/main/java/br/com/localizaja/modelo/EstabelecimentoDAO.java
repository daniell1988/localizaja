/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localizaja.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Daniel
 */
@Getter
@Setter
public class EstabelecimentoDAO {

    private String nomeEmpresa;
    private String endereco;
    private String cidade;
    private String estado;
    private String categoria;
    private Double latitude;
    private Double longitude;

}
