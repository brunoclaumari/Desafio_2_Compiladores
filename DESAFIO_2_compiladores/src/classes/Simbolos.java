/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BRUNOSILVA
 */
public class Simbolos {

    List<String> aberto = Arrays.asList("(", "{", "[");
    List<String> fechado = Arrays.asList(")", "}", "]");

    public List<String> getAberto() {
        return aberto;
    }

    public List<String> getFechado() {
        return fechado;
    }
    
    
}
