package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizarNotaFiscal(
        @NotNull
        Long id,
        String nome,
        @Min(0)
        BigDecimal valor,
        LocalDate data,
        @Min(0)
        Double pesoCubado
) {
}
