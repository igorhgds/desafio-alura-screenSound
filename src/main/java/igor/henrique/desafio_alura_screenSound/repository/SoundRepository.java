package igor.henrique.desafio_alura_screenSound.repository;

import igor.henrique.desafio_alura_screenSound.model.Artista;
import igor.henrique.desafio_alura_screenSound.model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoundRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.name ILIKE %:name%")
    List<Musicas> searchMusicByArtist(String name);
}
