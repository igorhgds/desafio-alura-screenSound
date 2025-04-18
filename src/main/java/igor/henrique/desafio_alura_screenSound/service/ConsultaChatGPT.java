package igor.henrique.desafio_alura_screenSound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String buscarInformacao(String texto) {
        String apiKey = System.getenv("OPENAI_APIKEY");
        OpenAiService service = new OpenAiService(apiKey);


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Me de detalhes sobre o artista " + texto)
                .maxTokens(500)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }

    public static String dadosArtista(String name){
        String apiKey = System.getenv("OPENAI_APIKEY");
        OpenAiService service = new OpenAiService(apiKey);

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Em apenas uma palavra me diga se o artista é solo, dupla ou banda: " + name)
                .maxTokens(500)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
