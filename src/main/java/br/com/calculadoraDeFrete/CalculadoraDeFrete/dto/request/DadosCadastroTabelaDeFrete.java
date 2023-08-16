package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTabelaDeFrete(
        @NotBlank
        String nome,
        @NotNull
        @Min(0)
        Double fatorCubagem,
        @NotNull
        @Min(0)
        Double valorKilo,
        @NotNull
        @Min(0)
        Double percentual
) {
}
