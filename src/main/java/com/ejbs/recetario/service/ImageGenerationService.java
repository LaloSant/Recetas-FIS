package com.ejbs.recetario.service;

import java.util.Optional;

import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Component;

@Component
public class ImageGenerationService {

    private final ImageModel imageModel;

    public ImageGenerationService(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public String generarImg(String prompt) {
        ImagePrompt ip = new ImagePrompt(prompt,
                OpenAiImageOptions.builder()
                        .quality("hd")
                        .N(1)
                        .height(1024)
                        .width(1024).build());
        ImageResponse ir = imageModel.call(ip);
        return resolveImageContent(ir);
    }

    private String resolveImageContent(ImageResponse imageResponse) {
        Image image = imageResponse.getResult().getOutput();
        return Optional
                .ofNullable(image.getUrl())
                .orElseGet(image::getB64Json);
    }
}
