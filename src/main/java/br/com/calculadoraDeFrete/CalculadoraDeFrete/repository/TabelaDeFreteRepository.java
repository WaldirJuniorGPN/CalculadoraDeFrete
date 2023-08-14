package br.com.calculadoraDeFrete.CalculadoraDeFrete.repository;

import br.com.calculadoraDeFrete.CalculadoraDeFrete.entity.TabelaDeFrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabelaDeFreteRepository extends JpaRepository<TabelaDeFrete, Long> {
}
