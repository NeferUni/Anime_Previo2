package co.edu.ufps.controller;

import co.edu.ufps.entity.Manga;
import co.edu.ufps.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable int id) {
        Optional<Manga> manga = mangaService.findById(id);
        return manga.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Manga> createManga(@RequestBody Manga manga) {
        Manga createdManga = mangaService.save(manga);
        return new ResponseEntity<>(createdManga, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(@PathVariable int id, @RequestBody Manga manga) {
        Optional<Manga> existingManga = mangaService.findById(id);
        if (existingManga.isPresent()) {
            manga.setId(id);
            mangaService.save(manga);
            return ResponseEntity.ok(manga);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManga(@PathVariable int id) {
        Optional<Manga> existingManga = mangaService.findById(id);
        if (existingManga.isPresent()) {
            mangaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}