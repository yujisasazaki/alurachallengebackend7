package br.com.akrasia.alurachallengebackend7.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akrasia.alurachallengebackend7.model.photo.PhotoData;
import br.com.akrasia.alurachallengebackend7.service.PhotoStorageService;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoStorageService photoService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) throws IOException {
        PhotoData photo = photoService.getPhotoData(id);        
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(photo.contentType()))
                .body(photo.data());
    }    
}
