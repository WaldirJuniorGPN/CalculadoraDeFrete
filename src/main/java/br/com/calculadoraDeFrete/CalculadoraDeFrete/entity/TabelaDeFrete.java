package br.com.calculadoraDeFrete.CalculadoraDeFrete.entity;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request.DadosAtualizarTabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.request.DadosCadastroTabelaDeFrete;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "TabelaDeFrete")
@Table(name = "tabelas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class TabelaDeFrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double fatorCubagem;
    private double valorKilo;
    private double percentual;

    public TabelaDeFrete(DadosCadastroTabelaDeFrete dados) {
        this.nome = dados.nome();
        this.fatorCubagem = dados.fatorCubagem();
        this.valorKilo = dados.valorKilo();
        this.percentual = dados.percentual();
    }

    public void atualizarDados(DadosAtualizarTabelaDeFrete dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.fatorCubagem() != null) {
            this.fatorCubagem = dados.fatorCubagem();
        }
        if (dados.valorKilo() != null) {
            this.valorKilo = dados.valorKilo();
        }
        if (dados.percentual() != null) {
            this.percentual = dados.percentual();
        }
    }

}

