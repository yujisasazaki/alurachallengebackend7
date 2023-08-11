package br.com.akrasia.alurachallengebackend7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import br.com.akrasia.alurachallengebackend7.model.photo.Photo;
import br.com.akrasia.alurachallengebackend7.service.PhotoStorageService;

@SpringBootTest
public class PhotoStorageServiceTest {

    @Autowired
    private PhotoStorageService photoStorageService;

    @Test
    public void testStorePhoto() throws IOException {
        MultipartFile file = new MockMultipartFile("test.jpg", "test.jpg", "image/jpeg", "test".getBytes());
        Photo photo = new Photo(null, file.getOriginalFilename(), file.getContentType());

        Photo savedPhoto = photoStorageService.storePhoto(file);

        assertEquals(photo.getName(), savedPhoto.getName());
    }
}