package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.response;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;

public record DadosDetalhamentoTabelaDeFrete(Long id, String nome, Double fatorCubagem, Double valorKilo,
                                             Double percentual) {

    public DadosDetalhamentoTabelaDeFrete(TabelaDeFrete tabela) {
        this(tabela.getId(), tabela.getNome(), tabela.getFatorCubagem(), tabela.getValorKilo(), tabela.getPercentual());
    }
}
