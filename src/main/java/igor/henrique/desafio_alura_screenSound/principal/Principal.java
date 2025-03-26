package igor.henrique.desafio_alura_screenSound.principal;

import java.util.Scanner;

public class Principal {

    public void exibeMenu() {
        Scanner scan = new Scanner(System.in);
        
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