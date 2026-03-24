package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_livros")
public class Livro implements Serializable {
    @Id @GeneratedValue
    protected Long id;
    @Column(name="titulo_livro")
    protected String titulo;
    @Column(name="autor_livro")
    protected String autor;
    @Column(name="ano_publicacao")
    protected Integer anoPublicacao;

    public Livro(Long id, String titulo, String autor, Integer anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString(){
        return String.format("Livro[id=%d, titulo=%s, autor=%s, anoPubli=%d", id, titulo, autor, anoPublicacao);
    }
}


