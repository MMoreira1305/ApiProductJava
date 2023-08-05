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

@Entity(name = "fornecedor")
@Table(name = "fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    // Entidade/Tabela do meu database chamada Fornecedor, com GenerationType UUID que gera uma String aleatória como ID.
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String razao_social;

    @Column
    private String cnpj;

    public Fornecedor(String razao_social, String cnpj){
        this.razao_social = razao_social;
        this.cnpj = cnpj;
    }
}
