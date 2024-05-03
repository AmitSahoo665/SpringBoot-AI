package com.ai.amit.springbootai.response;


import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatResponse {
    private String status;
    private String response;
}
