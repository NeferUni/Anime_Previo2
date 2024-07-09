package co.edu.ufps.controller;

import co.edu.ufps.entity.Manga;
import co.edu.ufps.entity.Usuario;
import co.edu.ufps.entity.Favorito;
import co.edu.ufps.entity.FavoritoPK;
import co.edu.ufps.service.UsuarioService;
import co.edu.ufps.service.FavoritoService;
import co.edu.ufps.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FavoritoService favoritoService;

    @Autowired
    private MangaService mangaService;

    @GetMapping("/{username}/favoritos")
    public ResponseEntity<List<Manga>> getFavoritos(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        if (usuario.isPresent()) {
            List<Manga> favoritos = favoritoService.findMangasByUsuario(usuario.get());
            return ResponseEntity.ok(favoritos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{username}/favoritos")
    public ResponseEntity<Favorito> addFavorito(@PathVariable String username, @RequestBody Manga manga) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        if (usuario.isPresent()) {
            Favorito favorito = new Favorito();
            favorito.setUsuario(usuario.get());
            favorito.setManga(manga);
            favorito.setId(new FavoritoPK(manga.getId(), usuario.get().getId()));
            Favorito savedFavorito = favoritoService.save(favorito);
            return new ResponseEntity<>(savedFavorito, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{username}/favoritos/{mangaId}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable String username, @PathVariable int mangaId) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        if (usuario.isPresent()) {
            Optional<Manga> manga = mangaService.findById(mangaId);
            if (manga.isPresent()) {
                Optional<Favorito> favorito = favoritoService.findByUsuarioAndManga(usuario.get(), manga.get());
                if (favorito.isPresent()) {
                    favoritoService.delete(favorito.get());
                    return ResponseEntity.noContent().build();
                }
            }
        }
        return ResponseEntity.notFound().build();
    }
}