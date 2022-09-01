package com.trugdz.apimanga.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.trugdz.apimanga.model.Manga;

public class MangaDto {

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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public MangaDto(Manga manga) {
        this.id = manga.getId();
        this.titulo = manga.getTitulo();
        this.autor = manga.getAutor();
        this.genero = manga.getGenero();
        this.volume = manga.getVolume();
        this.preco = manga.getPreco();
        this.censura = manga.getCensura();
        this.isbn = manga.getIsbn();
        this.quantidadeDePaginas = manga.getQuantidadeDePaginas();
        this.urlImagem = manga.getUrlImagem();
    }

    public static List<MangaDto> converter(List<Manga> mangas) {
        return mangas.stream().map(MangaDto::new).collect(Collectors.toList());
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
