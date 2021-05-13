package com.puc.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTestConta {

    Cliente cliente = new Cliente("Lucas", "55555555");
    Conta conta = new Conta(cliente);

    @Test
    public void abrirConta() {
        Assertions.assertEquals("Conta Corrente aberta com sucesso!", conta.abrirConta("CC"));
        Assertions.assertEquals("Conta Poupança aberta com sucesso!", conta.abrirConta("CP"));
    }


}
