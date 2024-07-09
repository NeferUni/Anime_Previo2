package co.edu.ufps.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "favorito")
@Data
public class Favorito {
    @EmbeddedId
    private FavoritoPK id;

    @ManyToOne
    @MapsId("mangaId")
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
