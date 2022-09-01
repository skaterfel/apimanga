package com.trugdz.apimanga.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String genero;
    private Integer volume;
    private BigDecimal preco;
    private Integer censura;
    private String isbn;
    private Integer quantidadeDePaginas;
    private String urlImagem;

    public Manga() {
    }

    public Manga(String titulo, String autor, String genero, Integer volume, BigDecimal preco, Integer censura,
            String isbn, Integer quantidadeDePaginas, String urlImagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.volume = volume;
        this.preco = preco;
        this.censura = censura;
        this.isbn = isbn;
        this.quantidadeDePaginas = quantidadeDePaginas;
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getCensura() {
        return censura;
    }

    public void setCensura(Integer censura) {
        this.censura = censura;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public void setQuantidadeDePaginas(Integer quantidadeDePaginas) {
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

}
