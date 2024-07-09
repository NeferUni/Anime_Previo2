package co.edu.ufps.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoritoPK implements Serializable {
    @Column(name = "manga_id")
    private Integer mangaId;

    @Column(name = "usuario_id")
    private Integer usuarioId;
}