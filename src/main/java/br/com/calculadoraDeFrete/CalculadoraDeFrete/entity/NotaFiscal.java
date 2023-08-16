package br.com.calculadoraDeFrete.CalculadoraDeFrete.entity;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request.DadosAtualizarNotaFiscal;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request.DadosCadastroNotaFiscal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "NotaFiscal")
@Table(name = "notas_fiscais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFornecedor;
    private LocalDate dataDeEmissao;
    private BigDecimal valorDaNf;
    private Double pesoCubado;

    public NotaFiscal(DadosCadastroNotaFiscal dados) {
        this.nomeFornecedor = dados.nome();
        this.valorDaNf = dados.valor();
        this.dataDeEmissao = dados.data();
        this.pesoCubado = dados.pesoCubado();
    }

    public void atualizarDados(DadosAtualizarNotaFiscal dados) {
        if (dados.nome() != null) {
            this.nomeFornecedor = dados.nome();
        }
        if (dados.valor() != null) {
            this.valorDaNf = dados.valor();
        }
        if (dados.data() != null) {
            this.dataDeEmissao = dados.data();
        }
        if (dados.pesoCubado() != null) {
            this.pesoCubado = dados.pesoCubado();
        }
    }
}
