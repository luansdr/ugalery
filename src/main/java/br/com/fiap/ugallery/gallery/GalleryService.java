package br.com.fiap.ugallery.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {

    @Autowired
    GalleryRepository repository;

    public List<Gallery> findAll(){
        return repository.findAll();
    } 


     public boolean delete(Long id){
        var gallery = repository.findById(id);
        return repository.deleteById(id);
    } 
    
}
