package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroNotaFiscal(
        @NotBlank
        String nome,
        @NotNull
        @Min(0)
        BigDecimal valor,
        @NotNull
        LocalDate data,
        @Min(0)
        Double pesoCubado
) {
}
