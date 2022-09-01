package com.trugdz.apimanga.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.trugdz.apimanga.controller.dto.MangaDto;
import com.trugdz.apimanga.controller.form.AtualizaMangaForm;
import com.trugdz.apimanga.controller.form.MangaForm;
import com.trugdz.apimanga.model.Manga;
import com.trugdz.apimanga.repository.MangaRepository;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @GetMapping
    public List<MangaDto> listar() {
        List<Manga> mangas = mangaRepository.findAll();
        return MangaDto.converter(mangas);

    }

    @PostMapping
    public ResponseEntity<MangaDto> cadastrar(@Valid @RequestBody MangaForm form, UriComponentsBuilder uriBuilder) {
        Manga manga = form.converter();
        Boolean titutoExiste = form.validaSeTituloExiste(mangaRepository, manga.getTitulo());
        if (titutoExiste) {
            mangaRepository.save(manga);
            URI uri = uriBuilder.path("/mangas/{id}").buildAndExpand(manga.getId()).toUri();
            return ResponseEntity.created(uri).body(new MangaDto(manga));
        }
        return ResponseEntity.internalServerError().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Manga> optional = mangaRepository.findById(id);
        if (optional.isPresent()) {
            mangaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<MangaDto> atualizar(@Valid @RequestBody AtualizaMangaForm form,
            UriComponentsBuilder uriBuilder, @PathVariable Long id) {
        Optional<Manga> optional = mangaRepository.findById(id);
        if (optional.isPresent()) {
            Manga manga = form.atualizar(id, mangaRepository);
            return ResponseEntity.ok(new MangaDto(manga));
        }
        return ResponseEntity.notFound().build();

    }

}
