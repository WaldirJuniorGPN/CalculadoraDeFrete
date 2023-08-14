package br.com.calculadoraDeFrete.CalculadoraDeFrete.service;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;

import java.math.BigDecimal;

public interface calculadora {

    TabelaDeFrete tabela = new TabelaDeFrete();

    void calcular(TabelaDeFrete valor);

}
