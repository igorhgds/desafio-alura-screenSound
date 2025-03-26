package igor.henrique.desafio_alura_screenSound.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {
    private int id;
    private String name;
    private TipoArtista type;
}
