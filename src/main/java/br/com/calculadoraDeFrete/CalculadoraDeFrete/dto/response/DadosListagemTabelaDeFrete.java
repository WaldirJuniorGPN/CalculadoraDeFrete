package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.response;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;

public record DadosListagemTabelaDeFrete(Long id, String nome, Double fatorCubagem, Double valorKilo, Double percentual) {

    public DadosListagemTabelaDeFrete(TabelaDeFrete tabela) {
        this(tabela.getId(), tabela.getNome(), tabela.getFatorCubagem(), tabela.getValorKilo(), tabela.getPercentual());
    }
}
