package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.NotaFiscal;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoNotaFiscal(Long id, String nomeFornecedor, BigDecimal valorDaNf,
                                          LocalDate dataDeEmissao, Double pesoCubado) {
    public DadosDetalhamentoNotaFiscal(NotaFiscal dados) {
        this(dados.getId(), dados.getNomeFornecedor(), dados.getValorDaNf(), dados.getDataDeEmissao(), dados.getPesoCubado());
    }
}
