package br.com.frederico.neres.cardapioonline.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;

    @ManyToOne()
    @JoinColumn(name = "cardapio_id")
    @JsonBackReference
    private Cardapio cardapio;

    @OneToMany(mappedBy = "categoria")
    private List<Item> item;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Item> getItem() {
        return item;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
