package br.com.akrasia.alurachallengebackend7;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import br.com.akrasia.alurachallengebackend7.model.destination.DestinationForm;
import br.com.akrasia.alurachallengebackend7.service.DestinationService;
import br.com.akrasia.alurachallengebackend7.service.PhotoStorageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DestinationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DestinationService destinationService;

    @MockBean
    private PhotoStorageService photoStorageService;

    @Test
    public void saveDestination_shouldReturnOk() throws Exception {
        DestinationForm form = createDestinationForm("name", new BigDecimal(10));
        mockMvc.perform(multipart("/destination")
            .file((MockMultipartFile)form.file())
            .param("name", form.name())
            .param("price", form.price().toString()))
        .andExpect(status().isOk());
    }

    @Test
    public void saveDestination_withInvalidFile_shouldReturnBadRequest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/html", "not an image".getBytes());
        mockMvc.perform(multipart("/destination")
            .file(file)
            .param("name", "name")
            .param("price", "10"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void saveDestination_withInvalidPrice_shouldReturnBadRequest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", "an image".getBytes());
        mockMvc.perform(multipart("/destination")
            .file(file)
            .param("name", "name")
            .param("price", "-10"))
        .andExpect(status().isBadRequest());

        mockMvc.perform(multipart("/destination")
            .file(file)
            .param("name", "name")
            .param("price", "0"))
        .andExpect(status().isBadRequest());

        mockMvc.perform(multipart("/destination")
            .file(file)
            .param("name", "name")
            .param("price", "a"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getDestination_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/destination/1"))
        .andExpect(status().isOk());
    }

    @Test
    public void updateDestination_shouldReturnOk() throws Exception {
        DestinationForm form = createDestinationForm("name", new BigDecimal(10));
        mockMvc.perform(multipart("/destination/1")
            .file((MockMultipartFile)form.file())
            .param("name", form.name())
            .param("price", form.price().toString())
            .with(request -> {
                request.setMethod("PUT");
                return request;
            }))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteDestination_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/destination/1"))
            .andExpect(status().isOk());
    }
    

    public DestinationForm createDestinationForm(String name, BigDecimal price) {
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", "an image".getBytes());
        return new DestinationForm(name, price, file);
    }
}
