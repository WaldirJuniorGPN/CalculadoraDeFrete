package br.com.calculadoraDeFrete.CalculadoraDeFrete.controller;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.dto.DadosCadastroCalculadora;
import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.CalculadoraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    @Autowired
    CalculadoraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity calcularFrete(@RequestBody @Valid DadosCadastroCalculadora dados) {

        return ResponseEntity.ok(null);
    }
}
