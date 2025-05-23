package igor.henrique.desafio_alura_screenSound.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TipoArtista type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musicas> musicas = new ArrayList<>();

    public Artista() {}

    public Artista(String name, TipoArtista tipoArtista) {
        this.name = name;
        this.type = tipoArtista;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoArtista getType() {
        return type;
    }

    public void setType(TipoArtista type) {
        this.type = type;
    }

    public List<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musicas> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return
                " Artista = " + name + '\'' +
                ", tipo = " + type +
                ", músicas = " + musicas;
    }
}
