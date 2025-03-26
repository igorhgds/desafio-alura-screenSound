package igor.henrique.desafio_alura_screenSound.repository;

import igor.henrique.desafio_alura_screenSound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundRepository extends JpaRepository<Artista, Long> {
}
