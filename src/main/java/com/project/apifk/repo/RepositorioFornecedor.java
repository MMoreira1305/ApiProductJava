package com.project.apifk.repo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.apifk.model.Fornecedor;

// Repositório de Fornecedor.
@Repository
public interface RepositorioFornecedor extends CrudRepository<Fornecedor, String> {
    // Encontrando a razao social pelo ID
    @Query("SELECT f.razao_social FROM fornecedor f WHERE f.id = :id")
    String findrazao_socialById(String id);

    // Contando o ID vendo se ele realmente existe no banco.
    int countById(String string);

    // Delete por ID
    void deleteById(String id);

    // Encontrando todos os dados
    List<Fornecedor> findAll();
}
