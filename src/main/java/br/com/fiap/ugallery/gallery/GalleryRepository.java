package br.com.fiap.ugallery.gallery;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GalleryRepository {

    public List<Gallery> findAll() {
        return null;
    }

    public boolean deleteById(Long id) {

        return false;
    }

    public Object findById(Long id) {
        return null;
    }
    
}
