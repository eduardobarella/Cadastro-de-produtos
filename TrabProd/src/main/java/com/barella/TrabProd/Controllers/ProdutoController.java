package com.barella.TrabProd.Controllers;

import com.barella.TrabProd.Services.ProdutoService;
import com.barella.TrabProd.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> ProdutoModelList(){
        List<ProdutoModel> requeste = produtoService.ProdutoModelList();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ProdutoModel ProdutoModel(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.cadastrar(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public void ResponseEntity<?> excluirProduto(@RequestBody Long id){
        produtoService.excluirProduto(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }

    @PutMapping
    public ProdutoModel atualizar(@RequestBody ProdutoModel produtoModel, @PathVariable Long id){
        ProdutoModel model = produtoService.atualizar(id, produtoModel);
        return org.springframework.http.ResponseEntity.ok().body(model);

    }
}
