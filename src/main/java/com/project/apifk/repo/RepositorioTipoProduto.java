package com.project.apifk.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.apifk.model.Tipo_Produto;

// Repositório de tipo Produto
@Repository
public interface RepositorioTipoProduto extends CrudRepository<Tipo_Produto, String>{
    int countById(String id);

    void deleteById(String id);

    List<Tipo_Produto> findAll();
}
