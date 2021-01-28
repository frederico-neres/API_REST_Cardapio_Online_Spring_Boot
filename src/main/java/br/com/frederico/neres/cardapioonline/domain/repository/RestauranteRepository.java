package br.com.frederico.neres.cardapioonline.domain.repository;

import br.com.frederico.neres.cardapioonline.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
