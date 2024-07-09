package co.edu.ufps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
