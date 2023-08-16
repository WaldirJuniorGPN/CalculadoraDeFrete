package br.com.calculadoraDeFrete.CalculadoraDeFrete.controller;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.repository.CalculadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    @Autowired
    CalculadoraRepository repository;
}
