package br.com.akrasia.alurachallengebackend7.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akrasia.alurachallengebackend7.model.comment.CommentResponse;
import br.com.akrasia.alurachallengebackend7.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comments-home")
public class CommentsHomeController {
    
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getCommentsHome(HttpServletRequest request) throws IOException {
        int quantity = 3;
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        List<CommentResponse> randomComments = commentService.getRandomComments(quantity, baseUrl);
        return ResponseEntity.ok(randomComments);
    }
}
