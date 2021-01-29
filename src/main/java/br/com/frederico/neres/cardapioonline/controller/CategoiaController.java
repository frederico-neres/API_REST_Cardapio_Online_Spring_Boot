package br.com.frederico.neres.cardapioonline.controller;

import br.com.frederico.neres.cardapioonline.controller.Response.Response;
import br.com.frederico.neres.cardapioonline.domain.model.Cardapio;
import br.com.frederico.neres.cardapioonline.domain.model.Categoria;
import br.com.frederico.neres.cardapioonline.domain.repository.CardapioRepository;
import br.com.frederico.neres.cardapioonline.domain.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoiaController {

    CategoriaRepository categoriaRepository;
    CardapioRepository cardapioRepository;

    public CategoiaController(CategoriaRepository categoriaRepository,
                              CardapioRepository cardapioRepository) {
        this.categoriaRepository = categoriaRepository;
        this.cardapioRepository = cardapioRepository;
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        Response<List<Categoria>> response = new Response<List<Categoria>>();
        List<Categoria> categorias = categoriaRepository.findAll();

        response.setData(categorias);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("{cardapioId}")
    public ResponseEntity salvar(@PathVariable(name = "cardapioId") Long cardapioId,
                                 @RequestBody Categoria categoriaDTO) {
        Response<Categoria> response = new Response<Categoria>();
        Cardapio cardapio = cardapioRepository.findById(cardapioId).orElse(null);

        if(cardapio == null) {
            response.getErrors().add("Cardapio não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Categoria categoria = categoriaRepository.save(categoriaDTO);
        response.setData(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
