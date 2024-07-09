package co.edu.ufps.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "pais")
@Data
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Puedes usar @JsonIgnore si lo necesitas para ignorar propiedades en la serialización JSON
}
