package br.com.akrasia.alurachallengebackend7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akrasia.alurachallengebackend7.model.Comment;
import br.com.akrasia.alurachallengebackend7.model.CommentForm;
import br.com.akrasia.alurachallengebackend7.model.Photo;
import br.com.akrasia.alurachallengebackend7.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private PhotoStorageService photoService;

    public void saveComment(CommentForm form) throws Exception {
        
        Photo photo = photoService.storePhoto(form.file());
        Comment comment = new Comment(null, form.author(), form.content(), photo);

        repository.save(comment);        
    }    
}
