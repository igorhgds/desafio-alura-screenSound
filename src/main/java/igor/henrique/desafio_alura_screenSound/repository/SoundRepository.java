package igor.henrique.desafio_alura_screenSound.repository;

import igor.henrique.desafio_alura_screenSound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNameContainingIgnoreCase(String name);
}
