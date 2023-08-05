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
@Entity(name = "tipo_produto")
@Table(name = "tipo_produto")
public class Tipo_Produto {
    
    // Entidade/Tabela do meu database chamada Tipo_Produto, com GenerationType UUID que gera uma String aleatória como ID.

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String nome;

    public Tipo_Produto(String nome){
        this.nome = nome;
    }
}
