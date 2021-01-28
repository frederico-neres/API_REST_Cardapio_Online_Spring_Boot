package br.com.frederico.neres.cardapioonline.domain.model;

import javax.persistence.*;

@Entity
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
