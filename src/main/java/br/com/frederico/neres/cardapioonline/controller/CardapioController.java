package br.com.frederico.neres.cardapioonline.controller;

import br.com.frederico.neres.cardapioonline.controller.Response.Response;
import br.com.frederico.neres.cardapioonline.domain.model.Cardapio;
import br.com.frederico.neres.cardapioonline.domain.model.Restaurante;
import br.com.frederico.neres.cardapioonline.domain.repository.CardapioRepository;
import br.com.frederico.neres.cardapioonline.domain.repository.RestauranteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardapios")
public class CardapioController {

    public CardapioRepository cardapioRepository;
    public RestauranteRepository restauranteRepository;

    public CardapioController(CardapioRepository cardapioRepository,
                              RestauranteRepository restauranteRepository) {
        this.cardapioRepository = cardapioRepository;
        this.restauranteRepository = restauranteRepository;
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        Response<List<Cardapio>> response = new Response<List<Cardapio>>();
        List<Cardapio> cardapios = cardapioRepository.findAll();

        response.setData(cardapios);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("{restauranteId}")
    public ResponseEntity savar(@PathVariable(name = "restauranteId") Long restauranteId,
                                    @RequestBody Cardapio cardapioDTO) {
        Response<Cardapio> response = new Response<Cardapio>();

        Restaurante restaurante = restauranteRepository.findById(restauranteId).orElse(null);
        System.out.println(restaurante);

        if(restaurante == null) {
            response.getErrors().add("Restaurante não entrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        cardapioDTO.setRestaurante(restaurante);
        Cardapio cardapio = cardapioRepository.save(cardapioDTO);

        response.setData(cardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
