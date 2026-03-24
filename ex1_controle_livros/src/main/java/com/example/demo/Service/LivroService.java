package com.example.demo.Service;

import com.example.demo.entity.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    Livro postLivro(Livro livro);

    List<Livro> listAllLivros();

    Optional<Livro> getLivroById(Long livroId);

    void deleteLivro(Long livroId);

}
