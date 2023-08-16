package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTabelaDeFrete(
        @NotNull
        Long id,
        String nome,
        Double fatorCubagem,
        Double valorKilo,
        Double percentual) {
}
