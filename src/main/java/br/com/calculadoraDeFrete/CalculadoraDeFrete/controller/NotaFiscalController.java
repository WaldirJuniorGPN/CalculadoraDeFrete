package br.com.calculadoraDeFrete.CalculadoraDeFrete.controller;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.*;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.NotaFiscal;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.NotaFiscalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("notas")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroNotaFiscal dados, UriComponentsBuilder uriBuilder) {

        var notaFiscal = new NotaFiscal(dados);
        repository.save(notaFiscal);
        var uri = uriBuilder.path("/notas/{id}").buildAndExpand(notaFiscal.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoNotaFiscal(notaFiscal));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemNotaFiscal>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemNotaFiscal::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarNotaFiscal dados) {
        var notaFiscal = repository.getReferenceById(dados.id());
        notaFiscal.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoNotaFiscal(notaFiscal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
