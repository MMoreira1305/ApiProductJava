package com.project.apifk.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.apifk.model.Fornecedor;
import com.project.apifk.model.Product;
import com.project.apifk.model.Tipo_Produto;
import com.project.apifk.servico.ServiceApi;

@RestController
public class Controle {


    @Autowired
    private ServiceApi servico;

    // ============= PRODUTOS ================
    // Cadastrando Produtos a partir do RequestBody
    @PostMapping("/product")
    public ResponseEntity<?> cadastrarProduto(@RequestBody Product obj){
        return servico.cadastrarProduto(obj);
    }
    
    // Selecionando todos os Produtos
    @GetMapping("/product")
    public List<Product> selecionarTodosOsProdutos(){
        return servico.selecionarProdutos();
    }

    // Editando um produto por RequestBody
    @PutMapping("/product")
    public ResponseEntity<?> editarProduto(@RequestBody Product obj){
        return servico.editarProduto(obj);
    }

    // Deletando um produto por id e PathVariable
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> excluir(@PathVariable String id){

        return servico.deleteProduct(id);
    }

    // Selecionando um produto por id com Path Variable
    @GetMapping("/product/{id}")
    public ResponseEntity<?> selecionarProdutoPeloId(@PathVariable String id){
        return servico.selecionarProdutoPeloId(id);
    }

    // ================= FORNECEDORES ====================

    // Cadastrando Fornecedores a partir do RequestBody
    @PostMapping("/fornecedor")
    public ResponseEntity<?> cadastrarFornecedor(@RequestBody Fornecedor obj){
        return servico.cadastrarFornecedor(obj);
    }
    
    // Selecionando todos os Fornecedores
    @GetMapping("/fornecedor")
    public List<Fornecedor> selecionarTodosOsFornecedores(){
        return servico.selecionarFornecedores();
    }

    // Editando um Fornecedor por RequestBody
    @PutMapping("/fornecedor")
    public ResponseEntity<?> editarFornecedor(@RequestBody Fornecedor obj){
        return servico.editarFornecedor(obj);
    }

    // Deletando um Fornecedor por id e PathVariable
    @DeleteMapping("/fornecedor/{id}")
    public ResponseEntity<?> excluirFornecedor(@PathVariable String id){

        return servico.deleteProduct(id);
    }

    // Selecionando um Fornecedor por id com Path Variable
    @GetMapping("/fornecedor/{id}")
    public ResponseEntity<?> selecionarFornecedorPeloId(@PathVariable String id){
        return servico.selecionarFornecedorPeloId(id);
    }

    // ================= TIPOS DE PRODUTOS =====================

    // Cadastrando Tipos de Produtos a partir do RequestBody
    @PostMapping("/tipoProduto")
    public ResponseEntity<?> cadastrarTipoProduto(@RequestBody Tipo_Produto obj){
        return servico.cadastrarTipoProduto(obj);
    }
    
    // Selecionando todos os Tipos de Produtos
    @GetMapping("/tipoProduto")
    public List<Tipo_Produto> selecionarTodosOsTiposDeProdutos(){
        return servico.selecionarTiposProdutos();
    }

    // Editando um produto por RequestBody
    @PutMapping("/tipoProduto")
    public ResponseEntity<?> editarTipoDeProduto(@RequestBody Tipo_Produto obj){
        return servico.editarTipoProduto(obj);
    }

    // Deletando um Tipos de produto por id e PathVariable
    @DeleteMapping("/tipoProduto/{id}")
    public ResponseEntity<?> excluirTipoDeProduto(@PathVariable String id){

        return servico.deleteTipoProduto(id);
    }

    // Selecionando um Tipos de produto por id com Path Variable
    @GetMapping("/tipoProduto/{id}")
    public ResponseEntity<?> selecionarTipoDeProdutoPeloId(@PathVariable String id){
        return servico.selecionarTipoProdutoPeloId(id);
    }
}

