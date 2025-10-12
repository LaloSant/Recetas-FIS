package com.ejbs.recetario;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    ImageModel imageModel(@Value("${spring.ai.openai.api-key}") String apiKey) {
        OpenAiImageApi openAiImageApi = OpenAiImageApi.builder()
                .apiKey(apiKey)
                .build();
        return new OpenAiImageModel(openAiImageApi);
    }
}
