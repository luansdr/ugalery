package br.com.fiap.ugallery;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

import java.io.InputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class UgalleryApplication {

    public static void main(String[] args) {
        // Verifique se o FirebaseApp já foi inicializado
        if (FirebaseApp.getApps().isEmpty()) {
            initializeFirebaseApp();
        }

        SpringApplication.run(UgalleryApplication.class, args);
    }

    private static void initializeFirebaseApp() {
        try {
            Resource resource = new ClassPathResource("serviceAccountKey.json");

            if (resource.exists()) {
                InputStream inputStream = resource.getInputStream();

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(inputStream))
                        .build();

                FirebaseApp.initializeApp(options);
                System.out.println("FirebaseApp inicializado com sucesso.");
            } else {
                System.out.println("O arquivo serviceAccountKey.json não foi encontrado na pasta resources.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao inicializar o FirebaseApp: " + e.getMessage());
        }
    }
}