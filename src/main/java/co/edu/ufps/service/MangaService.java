package co.edu.ufps.service;

import co.edu.ufps.entity.Manga;
import co.edu.ufps.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> findAll() {
        return mangaRepository.findAll();
    }

    public Optional<Manga> findById(int id) {
        return mangaRepository.findById(id);
    }

    public Manga save(Manga manga) {
        return mangaRepository.save(manga);
    }

    public void deleteById(int id) {
        mangaRepository.deleteById(id);
    }
}
