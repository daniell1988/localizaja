/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localizaja.ws;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class teste {

    public static void main(String[] args) {

        try { // Call Web Service Operation
            ConsultaLeilaoWS_Service service = new ConsultaLeilaoWS_Service();
            ConsultaLeilaoWS port = service.getConsultaLeilaoWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String nomeCategoria = "";
            // TODO process result here
            List<LeilaoVO> result = port.obterLeiloesPorNomeCategoria(nomeCategoria);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

}
