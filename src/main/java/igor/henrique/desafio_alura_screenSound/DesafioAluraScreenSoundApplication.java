package igor.henrique.desafio_alura_screenSound;

import igor.henrique.desafio_alura_screenSound.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAluraScreenSoundApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAluraScreenSoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***Desafio Alura Screen Sound Application***");
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
