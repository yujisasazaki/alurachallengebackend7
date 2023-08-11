package br.com.akrasia.alurachallengebackend7.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.akrasia.alurachallengebackend7.model.photo.Photo;
import br.com.akrasia.alurachallengebackend7.model.photo.PhotoData;
import br.com.akrasia.alurachallengebackend7.repository.PhotoRepository;

@Service
public class PhotoStorageService {

    @Autowired
    private PhotoRepository repository;

    @Value("${photo.folder_path}")
    private String FOLDER_PATH;

    public Photo storePhoto(MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();
        Photo photo = repository.save(new Photo(null, originalFileName, file.getContentType()));

        String filePath = FOLDER_PATH + photo.getId() + "_" + originalFileName;
        file.transferTo(new File(filePath));

        return photo;
    }

    public PhotoData getPhotoData(Long id) throws IOException {

        Optional<Photo> optionalPhoto = repository.findById(id);

        if (optionalPhoto.isPresent()) {
            Photo photo = optionalPhoto.get();
            String filePath = FOLDER_PATH + photo.getId() + "_" + photo.getName();
            byte[] data = Files.readAllBytes(Paths.get(filePath));
            return new PhotoData(data, photo.getType());
        } else {
            throw new IOException("Photo with ID: " + id + " not found");
        }
    }
}