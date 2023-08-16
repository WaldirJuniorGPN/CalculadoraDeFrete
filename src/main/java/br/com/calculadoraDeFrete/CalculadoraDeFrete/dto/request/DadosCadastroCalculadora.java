package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCalculadora(
        @NotNull
        Long idTabelaDeFrete,
        @NotNull
        Long idNota
) {
}
