package igor.henrique.desafio_alura_screenSound.principal;

import igor.henrique.desafio_alura_screenSound.model.Artista;
import igor.henrique.desafio_alura_screenSound.model.TipoArtista;
import igor.henrique.desafio_alura_screenSound.repository.SoundRepository;

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
            var tipo = scan.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(name, tipoArtista);
            repository.save(artista);
            System.out.println("Cadastrar novo artista? (s/n)");
            novoArtista = scan.nextLine();
        }
    }

    private void registerMusic() {
    }

    private void listSongs() {
    }

    private void searchMusicByArtist() {
    }

    private void searchArtistData() {
    }
}