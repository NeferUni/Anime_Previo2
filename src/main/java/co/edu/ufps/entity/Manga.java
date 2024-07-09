package co.edu.ufps.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manga")
@Data
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "temporadas")
    private Integer temporadas;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @Column(name = "anime")
    private Boolean anime;

    @Column(name = "juego")
    private Boolean juego;

    @Column(name = "pelicula")
    private Boolean pelicula;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;
}
