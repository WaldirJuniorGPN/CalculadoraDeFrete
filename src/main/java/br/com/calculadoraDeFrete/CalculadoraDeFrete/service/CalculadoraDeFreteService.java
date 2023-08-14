package br.com.calculadoraDeFrete.CalculadoraDeFrete.service;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraDeFreteService implements calculadora{

    private BigDecimal valor = BigDecimal.ZERO;

    @Override
    public void calcular(TabelaDeFrete tabela) {

    }
}
