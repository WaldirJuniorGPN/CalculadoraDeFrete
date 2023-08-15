package br.com.calculadoraDeFrete.CalculadoraDeFrete.controller;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroNotaFiscal;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosDetalhamentoNotaFiscal;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.NotaFiscal;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.NotaFiscalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
