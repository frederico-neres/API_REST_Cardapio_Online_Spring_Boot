package br.com.frederico.neres.cardapioonline.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "restaurante")
    @JsonManagedReference
    private List<Cardapio> cardapios;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }
}
