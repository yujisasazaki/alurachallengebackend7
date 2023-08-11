package br.com.akrasia.alurachallengebackend7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akrasia.alurachallengebackend7.model.CommentForm;
import br.com.akrasia.alurachallengebackend7.service.CommentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @PostMapping
    public ResponseEntity<String> saveComment(@Valid CommentForm form) {
        try {
            commentService.saveComment(form);
            return ResponseEntity.ok("Comment saved");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving comment: " + e.getMessage());
        }
    }
}
