package com.example.demo.Controller;

import com.example.demo.Service.LivroService;
import com.example.demo.Service.LivroServiceImpl;
import com.example.demo.entity.Livro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {


    private final LivroServiceImpl livroService;

    public LivroController(LivroServiceImpl livroService){
        this.livroService = livroService;
    }

    @PostMapping("/livro")
    public ResponseEntity<Livro> postLivro(@Valid @RequestBody Livro livro){
        Livro savedLivro= livroService.postLivro(livro);

        URI location = URI.create("/livro"+ savedLivro.getId());

        return ResponseEntity.created(location).body(savedLivro);
    }

    @GetMapping("/livro")
    public ResponseEntity<List<Livro>> getAllLivros(){
        return ResponseEntity.ok(livroService.listAllLivros());
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id){
        return livroService.getLivroById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/livro/{id}")
    public ResponseEntity<Void> deleteLivroById(@PathVariable("id") long id){
        livroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }


}
