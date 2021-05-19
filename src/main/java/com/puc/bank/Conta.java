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

    /**
     * Realiza um deposito na conta passada como arametro.
     * 
     */
    public void depositar(float valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado na conta de " + this.cliente.getNome());
        } else {
            System.out.println("Não foi possível realizar o depósito em uma conta fechada.");
        }
    }
        /**
     * Retorna o saque realizado.
     * 
     * @param saque armazena a resposta do saque feito
     * @param valor quantidade negociada
     * @return saque.
     */
    public String sacar(float valor) {
        String saque;

        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                saque = "Saque realizado na conta de " + this.cliente.getNome();
            } else {
                saque = "Saldo insuficiente para saque";
            }
        } else {
            saque = "Impossível sacar de uma conta fechada!";
        }

        return saque;
    }

    /**
     * Exibe o extrato da conta.
     * 
     * @param data  data periodo
     * @param agora data da operacao
     */
    public void extrato() {
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("\nSeu saldo é de: " + this.getSaldo() + " \nData da operação: " + data.format(agora));
    }

    /**
     * Faz o pagamento da tarifa mensal.
     * 
     */
    public void tarifaMensal() {
        if (this.getTipo().equals("CC")) {
            this.setValorTarifa(12);
        } else if (this.getTipo().equals("CP")) {
            this.setValorTarifa(20);
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - this.getValorTarifa());
            System.out.println("Mensalidade paga com sucesso!");
        } else {
            System.out.println("Impossível pagar de uma conta fechada!");
        }
    }

     /**
     * Faz o pagamento da tarifa anual.
     * 
     */
    public void tarifaAnual() {
        if (this.getTipo().equals("CC")) {
            this.setValorTarifa(120);
        } else if (this.getTipo().equals("CP")) {
            this.setValorTarifa(200);
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - this.getValorTarifa());
            System.out.println("Mensalidade paga com sucesso!");
        } else {
            System.out.println("Impossível pagar de uma conta fechada!");
        }
    }
}