package br.com.akrasia.alurachallengebackend7.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akrasia.alurachallengebackend7.model.destination.DestinationForm;
import br.com.akrasia.alurachallengebackend7.model.destination.DestinationResponse;
import br.com.akrasia.alurachallengebackend7.service.DestinationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public ResponseEntity<String> saveDestination(@Valid DestinationForm form) throws IOException {        
        destinationService.saveDestination(form);
        return ResponseEntity.ok("Destination saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationResponse> getDestination(@PathVariable Long id, HttpServletRequest request) {
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        return ResponseEntity.ok(destinationService.getDestination(id, baseUrl));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDestination(@PathVariable Long id, @Valid DestinationForm form) throws IOException {
        destinationService.updateDestination(id, form);
        return ResponseEntity.ok("Destination updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok("Destination deleted");
    }    
}
