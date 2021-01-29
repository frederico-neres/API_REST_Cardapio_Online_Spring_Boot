package br.com.frederico.neres.cardapioonline.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonBackReference
    private Restaurante restaurante;

    @OneToMany(mappedBy = "cardapio")
    @JsonManagedReference
    private List<Categoria> categorias ;

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
