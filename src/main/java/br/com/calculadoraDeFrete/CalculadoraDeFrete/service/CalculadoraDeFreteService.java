package br.com.calculadoraDeFrete.CalculadoraDeFrete.service;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroCalculadora;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.CalculadoraRepository;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.NotaFiscalRepository;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.TabelaDeFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraDeFreteService implements calculadora{

    private BigDecimal valor = BigDecimal.ZERO;

    @Autowired
    TabelaDeFreteRepository tabelaDeFreteRepository;

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Override
    public void calcular(DadosCadastroCalculadora dados) {
        var tabelaDeFrete = tabelaDeFreteRepository.getReferenceById(dados.idTabelaDeFrete());
        var notaFiscal = notaFiscalRepository.getReferenceById(dados.idNota());

        var valorDoFretePorPercentual = notaFiscal.getValorDaNf().multiply(tabelaDeFrete.getPercentual());
    }
}
