package br.com.frederico.neres.cardapioonline.controller;

import br.com.frederico.neres.cardapioonline.controller.Response.Response;
import br.com.frederico.neres.cardapioonline.domain.model.Restaurante;
import br.com.frederico.neres.cardapioonline.domain.repository.RestauranteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurantes")
public class RestauranteController {

    public RestauranteRepository restauranteRepository;

    public RestauranteController(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        Response<List<Restaurante>> response = new Response<List<Restaurante>>();
        List<Restaurante> restaurantes = restauranteRepository.findAll();

        response.setData(restaurantes);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Restaurante restauranteDTO) {
        Response<Restaurante> response = new Response<Restaurante>();
        Restaurante restaurante = restauranteRepository.save(restauranteDTO);

        response.setData(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
