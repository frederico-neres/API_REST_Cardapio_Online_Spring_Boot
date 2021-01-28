package br.com.frederico.neres.cardapioonline.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "restaurante")
    private List<Cardapio> cardapio;
}
