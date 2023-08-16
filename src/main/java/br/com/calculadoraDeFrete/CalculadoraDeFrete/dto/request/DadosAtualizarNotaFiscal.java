package br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizarNotaFiscal(
        @NotNull
        Long id,
        String nome,
        BigDecimal valor,
        LocalDate data,
        Double pesoCubado
) {
}
