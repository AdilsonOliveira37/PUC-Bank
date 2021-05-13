package com.puc.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTestClient {

    @Test
    public void validaCliente() {
        Cliente  teste1= new Cliente("Adilson", "135248283");
        String atual = teste1.toString();
        Assertions.assertEquals("Cliente{nome='Adilson', cpfCnpj='135248283'}", atual);
    }

    @Test
    public void nomeVazioCliente() {
        Cliente teste2 = new Cliente("", "135248283");
        String atual = teste2.toString();
        Assertions.assertEquals("Cliente{nome='', cpfCnpj='135248283'}", atual);
    }

    @Test
    public void docVazioCliente() {
        Cliente teste3 = new Cliente("Pierre", "");
        String atual = teste3.toString();
        Assertions.assertEquals("Cliente{nome='Pierre', cpfCnpj=''}", atual);
    }
}

