package br.com.fiap.ugallery.gallery;

import lombok.Data;

@Data
public class Gallery {
    private String id;
    private String title;
    private String imageUrl;

    // Construtores e outros métodos não são necessários, o Lombok cuida deles.
}

