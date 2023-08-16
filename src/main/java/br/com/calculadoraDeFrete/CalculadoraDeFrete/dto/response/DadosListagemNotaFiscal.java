package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.response;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.NotaFiscal;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemNotaFiscal(Long id, String nome, BigDecimal valor, LocalDate data) {

   public DadosListagemNotaFiscal(NotaFiscal dados){
        this(dados.getId(), dados.getNomeFornecedor(), dados.getValorDaNf(), dados.getDataDeEmissao());
    }
}
