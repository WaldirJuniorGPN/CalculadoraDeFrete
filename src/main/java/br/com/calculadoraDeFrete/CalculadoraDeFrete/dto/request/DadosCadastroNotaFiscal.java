package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroNotaFiscal(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal valor,
        @NotNull
        LocalDate data,
        Double pesoCubado
) {
}
