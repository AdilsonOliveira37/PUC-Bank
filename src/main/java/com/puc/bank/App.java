package com.puc.bank;

/**
* Esse software foi desenvolvido para resolução do trabalho de Projeto de Sistemas
* @version 1.00 2021-05-05
* @author Adilson Oliveira, Caio Capua, Pierre Marques
*
*/

public class App {
    /**
     * Classe principal.
     * 
     * @param cliente       recebe um objeto da classe cliente
     * @param conta         recebe um objeto da classe conta
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente("", "");
        Conta conta = new Conta(cliente);
        conta.abrirConta("CC");
    }
}