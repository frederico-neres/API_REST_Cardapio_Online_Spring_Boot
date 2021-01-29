package br.com.frederico.neres.cardapioonline.domain.repository;

import br.com.frederico.neres.cardapioonline.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
