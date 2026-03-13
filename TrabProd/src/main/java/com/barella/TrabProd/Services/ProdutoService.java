package com.barella.TrabProd.Services;

import com.barella.TrabProd.Repositories.ProdutoRepository;
import com.barella.TrabProd.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //DELETE
    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id){
    produtoRepository.deleteById(id);
    }

    //GET
    @GetMapping
    public List<ProdutoModel> ProdutoModelList(){
    return  produtoRepository.findAll();
    }

    //POST
    @PostMapping
    public ProdutoModel cadastrar(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    //PUT
    @PutMapping
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel newProduto = produtoRepository.findById(id).get();
        newProduto.setNome(produtoModel.getNome());
        return produtoRepository.save(newProduto);
    }
}
