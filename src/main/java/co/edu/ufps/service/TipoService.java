package co.edu.ufps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ufps.entity.Tipo;
import co.edu.ufps.repository.TipoRepository;

import java.util.List;

@Service
@Transactional
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    public Tipo findById(int id) {
        return tipoRepository.findById(id).orElse(null);
    }

    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public void deleteById(int id) {
        tipoRepository.deleteById(id);
    }
}
