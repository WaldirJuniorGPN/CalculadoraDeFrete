package br.com.calculadoraDeFrete.CalculadoraDeFrete.controller;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosAtualizarTabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroTabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosDetalhamentoTabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosListagemTabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.TabelaDeFreteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tabelas")
public class TabelaDeFreteController {

    @Autowired
    private TabelaDeFreteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTabelaDeFrete dados, UriComponentsBuilder uriBuilder) {
        var tabela = new TabelaDeFrete(dados);
        repository.save(tabela);
        var uri = uriBuilder.path("/tabelas/{id}").buildAndExpand(tabela.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTabelaDeFrete(tabela));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTabelaDeFrete>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTabelaDeFrete::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTabelaDeFrete dados) {
        var tabelaDeFrete = repository.getReferenceById(dados.id());
        tabelaDeFrete.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTabelaDeFrete(tabelaDeFrete));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var tabela = repository.getReferenceById(id);
        repository.deleteById(tabela.getId());
        return ResponseEntity.noContent().build();
    }

}
