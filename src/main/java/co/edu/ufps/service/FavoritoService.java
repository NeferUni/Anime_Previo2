package co.edu.ufps.service;

import co.edu.ufps.entity.Favorito;
import co.edu.ufps.entity.Manga;
import co.edu.ufps.entity.Usuario;
import co.edu.ufps.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Manga> findMangasByUsuario(Usuario usuario) {
        return favoritoRepository.findByUsuario(usuario).stream()
                .map(Favorito::getManga)
                .collect(Collectors.toList());
    }

    public Favorito save(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public Optional<Favorito> findByUsuarioAndManga(Usuario usuario, Manga manga) {
        return favoritoRepository.findByUsuarioAndManga(usuario, manga);
    }

    public void delete(Favorito favorito) {
        favoritoRepository.delete(favorito);
    }
}
