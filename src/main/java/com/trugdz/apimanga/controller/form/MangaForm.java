package com.trugdz.apimanga.controller.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.trugdz.apimanga.model.Manga;
import com.trugdz.apimanga.repository.MangaRepository;

public class MangaForm {
    @NotNull
    private String titulo;

    @NotNull
    private String autor;

    private String genero;

    @NotNull
    private Integer volume;

    @NotNull
    private BigDecimal preco;

    private Integer censura;

    @NotNull
    private String isbn;

    private Integer quantidadeDePaginas;

    @NotNull
    private String urlImagem;

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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Manga converter() {
        return new Manga(titulo, autor, genero, volume, preco, censura, isbn, quantidadeDePaginas, urlImagem);
    }

    public Boolean validaSeTituloExiste(MangaRepository mangaRepository, String titulo) {
        // em teste.
        Optional<Manga> op = mangaRepository.findByTitulo(titulo);
        if (op.isPresent()) {
            return false;
        }
        return true;
    }

}
