package co.edu.ufps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entity.Favorito;
import co.edu.ufps.entity.FavoritoPK;
import co.edu.ufps.entity.Manga;
import co.edu.ufps.entity.Usuario;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoPK> {
    List<Favorito> findByUsuario(Usuario usuario);
    Optional<Favorito> findByUsuarioAndManga(Usuario usuario, Manga manga);
}