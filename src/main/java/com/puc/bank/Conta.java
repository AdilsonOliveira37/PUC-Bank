package com.puc.bank;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
/**
 * Classe que realiza as operações na conta do usuario, abrir conta, fechar
 * conta, realizar deposito, ver saldo, ver extrato, sacar, tarifa anual, tarifa
 * mensal.
 */
public class Conta {
    private Cliente cliente;
    public int numConta;
    protected String tipo;
    private float saldo;
    private Boolean status;
    private int valorTarifa;

    /**
     * Construtor da classe.
     * 
     * @param cliente     cliente do banco
     * @param saldo       saldo na conta
     * @param status      status da conta do cliente
     * @param valorTarifa valor a ser pago de tarifa
     */
    public Conta(Cliente c) {
        this.cliente = c;
        this.saldo = 0;
        this.status = false;
        this.valorTarifa = 0;
    }

    /**
     * Realiza a abertura da conta.
     * 
     * @return conta criada
     */
    public String abrirConta(String tipoConta) {
        String conta;
        this.setTipo(tipoConta);
        this.setStatus(true);

        if (tipoConta.equals("CC")) {
            conta = "Conta Corrente aberta com sucesso!";
            this.setSaldo(50);
        } else if (tipoConta.equals("CP")) {
            conta = "Conta Poupança aberta com sucesso!";
            this.setSaldo(150);
        } else {
            conta = "Conta inválida!";
        }

        return conta;
    }

    /**
     * Realiza o fechamento da conta.
     * 
     * @return conta excluida
     */
    public String fecharConta(String tipoConta) {
        String conta;

        if (tipoConta.equals("CC") || tipoConta.equals("CP")) {
            if (this.getSaldo() > 0) {
                conta = "Fechamento inválido, ainda existe saldo!";
            } else if (this.getSaldo() < 0) {
                conta = "Fechamento inválido, ainda existem débitos!";
            } else {
                this.setStatus(false);
                conta = "Conta fechada com sucesso!";
            }
        } else {
            conta = "Conta inválida!";
        }

        return conta;
    }
}
