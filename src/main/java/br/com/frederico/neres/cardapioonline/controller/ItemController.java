package br.com.frederico.neres.cardapioonline.controller;

import br.com.frederico.neres.cardapioonline.controller.Response.Response;
import br.com.frederico.neres.cardapioonline.domain.model.Item;
import br.com.frederico.neres.cardapioonline.domain.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itens")
public class ItemController {
    public ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        Response<List<Item>> response = new Response<List<Item>>();
        List<Item> items = itemRepository.findAll();

        response.setData(items);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Item item) {
        Response<Item> response = new Response<Item>();
        item = itemRepository.save(item);

        response.setData(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
