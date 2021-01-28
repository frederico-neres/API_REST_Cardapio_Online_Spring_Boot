package br.com.frederico.neres.cardapioonline.domain.model;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String ingredientes;

    @ManyToOne()
    @JoinColumn(name = "cardapio_id")
    private Cardapio cardapio;

    @OneToOne()
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
