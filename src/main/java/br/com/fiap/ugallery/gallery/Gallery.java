package br.com.fiap.ugallery.gallery;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Data
public class Gallery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String imageUrl;

}

