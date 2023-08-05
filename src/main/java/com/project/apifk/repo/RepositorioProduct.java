package com.project.apifk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.apifk.model.Product;

// Repositório de Produto.
@Repository
public interface RepositorioProduct extends CrudRepository<Product, String> {
    // Encontrando um produto a partir do ID, e trazendo apenas o nome
    @Query("SELECT p.nome_produto FROM product p WHERE p.id = :id")
    String findNomeById(String id);

    // Selecionando todos os produtos com JOIN, testando ainda mas ainda não funcionou
    @Query("SELECT p.id, p.nome_produto, p.quantidade, f.razao_social, tp.nome FROM product p JOIN fornecedor f ON p.id_fornecedor = f.id JOIN tipo_produto tp ON p.id_tipo_produto = tp.id")
    List<Product> findAllProducts();
    
    // Delete por ID
    void deleteById(String id);
    // Contar os ID´s para ver se aquele ID realmente existe.
    int countById(String id);

    // Encontrando todos os dados do produto.
    List<Product> findAll();
    
}
