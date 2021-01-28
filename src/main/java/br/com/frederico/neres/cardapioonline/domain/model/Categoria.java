package br.com.frederico.neres.cardapioonline.domain.model;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;

    @OneToOne(mappedBy = "categoria")
    private Item item;
}
