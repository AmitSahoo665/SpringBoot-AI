package com.ai.amit.springbootai.service;


import com.ai.amit.springbootai.response.AiChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class AiChatService {
    private final OllamaChatClient chatClient;

    public AiChatResponse generate(String prompt) {
        return AiChatResponse.builder().status("Success").response(chatClient.call(prompt)).build();
    }

    public Flux<String> generateStream(String prompt) {
        return chatClient.stream(prompt);
    }

    public Flux<ChatResponse> generateStreamFlux(String prompt) {
        Prompt message = new Prompt(new UserMessage(prompt));
        return chatClient.stream(message);
    }
}
