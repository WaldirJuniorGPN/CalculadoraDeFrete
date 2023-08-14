package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTabelaDeFrete(
        @NotBlank
        String nome,
        @NotNull
        Double fatorCubagem,
        @NotNull
        Double valorKilo,
        @NotNull
        Double percentual
) {
}
