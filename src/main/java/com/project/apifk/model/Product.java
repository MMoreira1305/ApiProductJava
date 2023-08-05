package com.project.apifk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "product")
@Table(name = "product")
public class Product {
    
    // Entidade/Tabela do meu database chamada Product, com GenerationType UUID que gera uma String aleatória como ID.

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String nome_produto;

    @Column
    private Long quantidade;

    @Column
    private String id_tipo_produto;

    @Column
    private String id_fornecedor;

    public Product(String nome_produto,Long quantidade, String id_tipo_produto, String id_fornecedor){
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.id_tipo_produto = id_tipo_produto;
        this.id_fornecedor = id_fornecedor;
    }
}
