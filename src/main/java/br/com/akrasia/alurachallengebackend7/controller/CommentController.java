package br.com.akrasia.alurachallengebackend7.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akrasia.alurachallengebackend7.model.comment.CommentForm;
import br.com.akrasia.alurachallengebackend7.model.comment.CommentResponse;
import br.com.akrasia.alurachallengebackend7.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long id, HttpServletRequest request) throws IOException {
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());        
        return ResponseEntity.ok(commentService.getComment(id, baseUrl));
    }

    @PostMapping
    public ResponseEntity<String> saveComment(@Valid CommentForm form) throws IOException {
        commentService.saveComment(form);
        return ResponseEntity.ok("Comment saved");
    }
}
