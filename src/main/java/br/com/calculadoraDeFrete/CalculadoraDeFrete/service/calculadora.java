package br.com.calculadoraDeFrete.CalculadoraDeFrete.service;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroCalculadora;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;

import java.math.BigDecimal;

public interface calculadora {

    void calcular(DadosCadastroCalculadora calculadora);

}
