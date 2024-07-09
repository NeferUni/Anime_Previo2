package co.edu.ufps.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // Puedes usar @JsonIgnore si lo necesitas para ignorar propiedades en la serialización JSON
}
