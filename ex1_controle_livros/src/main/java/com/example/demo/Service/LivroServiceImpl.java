package com.example.demo.Service;

import com.example.demo.Repository.LivroRepository;
import com.example.demo.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService{


    private final LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @Override
    public Livro postLivro(Livro livro){
        return livroRepository.save(livro);
    }

    @Override
    public List<Livro>listAllLivros(){
        return (List<Livro>) livroRepository.findAll();
    }

    @Override
    public Optional<Livro> getLivroById(Long livroId){
    return livroRepository.findById(livroId);
    }

    @Override
    public void deleteLivro(Long livroId){
        livroRepository.deleteById(livroId);
    }
}
