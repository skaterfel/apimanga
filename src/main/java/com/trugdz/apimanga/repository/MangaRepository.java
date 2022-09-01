package com.trugdz.apimanga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trugdz.apimanga.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long> {

    Optional<Manga> findByTitulo(String titulo);

}
