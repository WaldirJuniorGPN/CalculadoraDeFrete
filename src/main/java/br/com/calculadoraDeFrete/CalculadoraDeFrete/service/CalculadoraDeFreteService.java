package br.com.calculadoraDeFrete.CalculadoraDeFrete.service;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroCalculadora;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.NotaFiscalRepository;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.TabelaDeFreteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Getter
public class CalculadoraDeFreteService implements calculadora {

    private BigDecimal valor = BigDecimal.ZERO;

    @Autowired
    TabelaDeFreteRepository tabelaDeFreteRepository;

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Override
    public void calcular(DadosCadastroCalculadora dados) {
        var tabelaDeFrete = tabelaDeFreteRepository.getReferenceById(dados.idTabelaDeFrete());
        var notaFiscal = notaFiscalRepository.getReferenceById(dados.idNota());

        var valorDoFretePorPercentual = notaFiscal.getValorDaNf().multiply(BigDecimal.valueOf(tabelaDeFrete.getPercentual()));
        var valorPorPeso = notaFiscal.getPesoCubado() * tabelaDeFrete.getValorKilo();

        if (valorDoFretePorPercentual.compareTo(BigDecimal.valueOf(valorPorPeso)) > 0) {
            valor = valorDoFretePorPercentual.setScale(2, RoundingMode.HALF_UP);
        } else {
            valor = BigDecimal.valueOf(valorPorPeso).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
