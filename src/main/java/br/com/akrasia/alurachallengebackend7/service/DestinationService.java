package br.com.akrasia.alurachallengebackend7.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akrasia.alurachallengebackend7.model.destination.Destination;
import br.com.akrasia.alurachallengebackend7.model.destination.DestinationForm;
import br.com.akrasia.alurachallengebackend7.model.destination.DestinationResponse;
import br.com.akrasia.alurachallengebackend7.model.photo.Photo;
import br.com.akrasia.alurachallengebackend7.repository.DestinationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository repository;

    @Autowired
    private PhotoStorageService photoService;

    public void saveDestination(@Valid DestinationForm form) throws IOException {
        Photo photo = photoService.storePhoto(form.file());
        Destination destination = new Destination(null, form.name(), form.price(), photo);
        repository.save(destination);
    }

    public DestinationResponse getDestination(Long id, String baseUrl) {
        Destination destination = repository.findById(id).get();
        String photoUrl = baseUrl + "/photo/" + destination.getPhoto().getId().toString();
        DestinationResponse response = new DestinationResponse(destination, photoUrl);
        return response;
    }

    public List<DestinationResponse> getDestination(String name, String baseUrl) {
        List<Destination> destinations = repository.findByName(name).get();
        if (destinations.isEmpty()) {
            throw new EntityNotFoundException("Destination not found");
        }
        List<DestinationResponse> responses = destinations.stream().map(destination -> {
            String photoUrl = baseUrl + "/photo/" + destination.getPhoto().getId().toString();
            return new DestinationResponse(destination, photoUrl);
        }).collect(Collectors.toList());
        return responses;
    }

    public void updateDestination(Long id, DestinationForm form) throws IOException {            
        Destination destination = repository.findById(id).get();
        Photo photo = photoService.storePhoto(form.file());
        destination.update(photo, form.name(), form.price());
        repository.save(destination);
    }

    public void deleteDestination(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Destination not found");
        repository.deleteById(id);
    }

}
