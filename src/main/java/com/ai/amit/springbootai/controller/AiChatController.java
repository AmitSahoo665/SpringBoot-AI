package com.ai.amit.springbootai.controller;


import com.ai.amit.springbootai.response.AiChatResponse;
import com.ai.amit.springbootai.service.AiChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AiChatController {
    private final AiChatService service;

    @GetMapping("/ai/generate")
    public ResponseEntity<AiChatResponse> generate(@RequestParam(value = "prompt", defaultValue = "Tell me a joke") String prompt) {
        return ResponseEntity.ok().body(service.generate(prompt));
    }

    @GetMapping("/ai/generateStream")
    public Flux<String> generateStream(@RequestParam(value = "prompt", defaultValue = "Tell me a joke") String prompt) {
        return service.generateStream(prompt);
    }

    @GetMapping("/ai/generateStreamFlux")
    public Flux<ChatResponse> generateStreamFlux(@RequestParam(value = "prompt", defaultValue = "Tell me a joke") String prompt) {
        return service.generateStreamFlux(prompt);
    }
}
