package br.com.akrasia.alurachallengebackend7.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akrasia.alurachallengebackend7.model.comment.Comment;
import br.com.akrasia.alurachallengebackend7.model.comment.CommentForm;
import br.com.akrasia.alurachallengebackend7.model.comment.CommentResponse;
import br.com.akrasia.alurachallengebackend7.model.photo.Photo;
import br.com.akrasia.alurachallengebackend7.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private PhotoStorageService photoService;

    public void saveComment(CommentForm form) throws IOException {
        
        Photo photo = photoService.storePhoto(form.file());
        Comment comment = new Comment(null, form.author(), form.content(), photo);

        repository.save(comment);        
    }

    public CommentResponse getComment(Long id, String baseUrl) throws IOException {
        Comment comment = repository.findById(id).get();
        String photoUrl = baseUrl + "/photo/" + comment.getPhoto().getId().toString();
        CommentResponse response = new CommentResponse(comment, photoUrl);
        return response;
    }    
}
