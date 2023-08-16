package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTabelaDeFrete(
        @NotNull
        Long id,
        String nome,
        @Min(0)
        Double fatorCubagem,
        @Min(0)
        Double valorKilo,
        @Min(0)
        Double percentual) {
}
