package co.edu.ufps.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
@Data
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Puedes usar @JsonIgnore si lo necesitas para ignorar propiedades en la serialización JSON
}
