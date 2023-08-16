package br.com.calculadoraDeFrete.CalculadoraDeFrete.repository;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.Calculadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {
}
