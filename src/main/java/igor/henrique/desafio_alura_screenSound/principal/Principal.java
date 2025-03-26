package igor.henrique.desafio_alura_screenSound.principal;

import igor.henrique.desafio_alura_screenSound.model.Artista;
import igor.henrique.desafio_alura_screenSound.model.Musicas;
import igor.henrique.desafio_alura_screenSound.model.TipoArtista;
import igor.henrique.desafio_alura_screenSound.repository.SoundRepository;
import igor.henrique.desafio_alura_screenSound.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final SoundRepository repository;
    Scanner scan = new Scanner(System.in);

    public Principal(SoundRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() {

        var option = -1;
        while (option!= 0) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    0 - Sair
                    """;

            System.out.println(menu);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchMusicByArtist();
                    break;
                case 5:
                    searchArtistData();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void registerArtist() {
        var novoArtista = "s";

        while(novoArtista.equalsIgnoreCase( "s")) {
            System.out.println("Informe o nome do artista: ");
            var name = scan.nextLine();
            System.out.println("Informe o tipo do artista: (solo, dupla ou banda)");
            var type = scan.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(type.toUpperCase());
            Artista artista = new Artista(name, tipoArtista);
            repository.save(artista);
            System.out.println("Cadastrar novo artista? (s/n)");
            novoArtista = scan.nextLine();
        }
    }

    private void registerMusic() {
        System.out.println("Cadastrar música de qual artista? ");
        var name = scan.nextLine();
        Optional<Artista> artista = repository.findByNameContainingIgnoreCase(name);
        if (artista.isPresent()) {
            System.out.println("Informe o titulo da música: ");
            var title = scan.nextLine();
            Musicas musica = new Musicas(title);
            musica.setArtist(artista.get());
            artista.get().getMusicas().add(musica);
            repository.save(artista.get());
            System.out.println("Musica cadastrada!");
        } else {
            System.out.println("Artista não encontrado!");
        }
    }

    private void listSongs() {
        List<Artista> artistas = repository.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void searchMusicByArtist() {
        System.out.println("Buscar músicas de qual artista? ");
        var name = scan.nextLine();
        List<Musicas> musicas = repository.searchMusicByArtist(name);
        musicas.forEach(System.out::println);
    }

    private void searchArtistData() {
        System.out.println("Digite o nome do artista: ");
        var artista = scan.nextLine();
        var resposta = ConsultaChatGPT.buscarInformacao(artista);
        System.out.println(resposta.trim());
    }
}