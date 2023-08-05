package com.project.apifk.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.apifk.model.Fornecedor;
import com.project.apifk.model.Tipo_Produto;
import com.project.apifk.model.Mensagem;
import com.project.apifk.model.Product;
import com.project.apifk.repo.RepositorioProduct;
import com.project.apifk.repo.RepositorioFornecedor;
import com.project.apifk.repo.RepositorioTipoProduto;

@Service
public class ServiceApi {

    // Autowired é uma injeção de dependência, a necessidade de instânciar um objeto sem ter que fazer uma classe, a partir da interface
    @Autowired
    private RepositorioFornecedor acao2;
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositorioProduct acao1;

    @Autowired
    private RepositorioTipoProduto acao3;

    // Cadastro de produtos, Cadastro de Fornecedor, Cadastro de Tipos de Produtos
    public ResponseEntity<?> cadastrarProduto(Product obj){
        if(obj.getNome_produto().equals("")){
            mensagem.setMensagem("O nome do produto precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else if(obj.getQuantidade() < 0){
            mensagem.setMensagem("A quantidade precisa ser certa.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else if(obj.getId_fornecedor().equals("")){
            mensagem.setMensagem("O ID do fornecedor precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else if(obj.getId_tipo_produto().equals("")){
            mensagem.setMensagem("O ID do tipo do produto precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        else{
            mensagem.setMensagem("Produto cadastrado com Sucesso!");
            acao1.save(obj);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }

        
    }

    public ResponseEntity<?> cadastrarFornecedor(Fornecedor obj){
        if(obj.getRazao_social().equals("")){
            mensagem.setMensagem("A razão social precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        mensagem.setMensagem("Fornecedor cadastrado com Sucesso!");
        acao2.save(obj);
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    public ResponseEntity<?> cadastrarTipoProduto(Tipo_Produto obj){
        mensagem.setMensagem("Tipo de Produto cadastrado com Sucesso!");
        return new ResponseEntity<>(acao3.save(obj), HttpStatus.CREATED);
    }

    // Selecionando os dados (all) e também passando por ID.
    public List<Product> selecionarProdutos(){
        return acao1.findAll();
    }

    public List<Fornecedor> selecionarFornecedores(){
        return acao2.findAll();
    }

    public List<Tipo_Produto> selecionarTiposProdutos(){
        return acao3.findAll();
    }

    public ResponseEntity<?> selecionarProdutoPeloId(String id){
        return new ResponseEntity<>(acao1.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<?> selecionarFornecedorPeloId(String id){
        return new ResponseEntity<>(acao2.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<?> selecionarTipoProdutoPeloId(String id){
        return new ResponseEntity<>(acao3.findById(id), HttpStatus.OK);
    }

    // Deletando dados das tabelas.
    public ResponseEntity<?> deleteProduct(String id){
        acao1.deleteById(id);
        return new ResponseEntity<>("Usuário deletado", HttpStatus.OK);
    }

    public ResponseEntity<?> deleteFornecedor(String id){
        acao2.deleteById(id);
        return new ResponseEntity<>("Usuário deletado", HttpStatus.OK);
    }

    public ResponseEntity<?> deleteTipoProduto(String id){
        acao3.deleteById(id);
        return new ResponseEntity<>("Usuário deletado", HttpStatus.OK);
    }

    // Editando todos os dados, a partir dos métodos apresentados abaixo.

    public ResponseEntity<?> editarProduto(Product obj){
        if(acao1.countById(obj.getId()) == 0){
            mensagem.setMensagem("O código informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(obj.getNome_produto().equals("")){
            mensagem.setMensagem("É necessário informar um nome correto.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getQuantidade() < 0){
            mensagem.setMensagem("Informe a quantidade corretamente");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao1.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editarFornecedor(Fornecedor obj){
        if(acao2.countById(obj.getId()) == 0){
            mensagem.setMensagem("O código informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(obj.getRazao_social().equals("")){
            mensagem.setMensagem("É necessário informar a razão social correta.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else if(obj.getCnpj().equals("") || obj.getCnpj().length() < 13){
            mensagem.setMensagem("CNPJ nulo ou menor que 13 caracteres.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao2.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editarTipoProduto(Tipo_Produto obj){
        if(acao3.countById(obj.getId()) == 0){
            mensagem.setMensagem("O código informado não existe.");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(obj.getNome().equals("")){
            mensagem.setMensagem("É necessário informar um nome do tipo do produto não nulo.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acao3.save(obj), HttpStatus.OK);
        }
    }
}

