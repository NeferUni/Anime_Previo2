package co.edu.ufps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
