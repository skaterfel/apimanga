package com.trugdz.apimanga.controller.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.trugdz.apimanga.model.Manga;
import com.trugdz.apimanga.repository.MangaRepository;

public class AtualizaMangaForm {

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

    public Manga atualizar(Long id, MangaRepository mangaRepository) {
        Manga manga = mangaRepository.getOne(id);
        manga.setAutor(autor);
        manga.setCensura(censura);
        manga.setGenero(genero);
        manga.setIsbn(isbn);
        manga.setPreco(preco);
        manga.setQuantidadeDePaginas(quantidadeDePaginas);
        manga.setTitulo(titulo);
        manga.setUrlImagem(urlImagem);
        manga.setVolume(volume);
        mangaRepository.save(manga);

        return manga;
    }

}
