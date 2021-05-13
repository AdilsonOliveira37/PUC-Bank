package com.puc.bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cliente {
  private String nome;
  private String cpfCnpj;

  /**
   * Construtor da classe.
   * 
   * @param nome    nome do cliente
   * @param cpfCnpj cpf ou cnpj do cliente
   */
  public Cliente(String nome, String cpfCnpj) {
    this.nome = nome;
    this.cpfCnpj = cpfCnpj;
  }

  @Override
  public String toString() {
    return "Cliente{" + "nome='" + nome + '\'' + ", cpfCnpj='" + cpfCnpj + '\'' + '}';
  }
}
