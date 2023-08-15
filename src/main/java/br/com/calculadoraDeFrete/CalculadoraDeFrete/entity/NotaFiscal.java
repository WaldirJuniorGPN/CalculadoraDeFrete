package br.com.calculadoraDeFrete.CalculadoraDeFrete.entity;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroNotaFiscal;
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
    private BigDecimal valorDaNf;
    private LocalDate dataDeEmissao;

    public NotaFiscal(DadosCadastroNotaFiscal dados) {
        this.nomeFornecedor = dados.nome();
        this.valorDaNf = dados.valor();
        this.dataDeEmissao = dados.data();
    }
}
