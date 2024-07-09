package co.edu.ufps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ufps.entity.Pais;
import co.edu.ufps.repository.PaisRepository;

import java.util.List;

@Service
@Transactional
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public Pais findById(int id) {
        return paisRepository.findById(id).orElse(null);
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public void deleteById(int id) {
        paisRepository.deleteById(id);
    }
}
