package br.com.frederico.neres.cardapioonline.domain.repository;

import br.com.frederico.neres.cardapioonline.domain.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{
}
