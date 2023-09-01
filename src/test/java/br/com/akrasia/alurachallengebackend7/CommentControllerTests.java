package br.com.akrasia.alurachallengebackend7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import br.com.akrasia.alurachallengebackend7.model.comment.CommentForm;
import br.com.akrasia.alurachallengebackend7.service.CommentService;
import br.com.akrasia.alurachallengebackend7.service.PhotoStorageService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @MockBean
    private PhotoStorageService photoStorageService;

    @Value("${photo.folder_path}")
    private String FOLDER_PATH;
    
    @Test
    public void saveComment_shouldReturnOk() throws Exception {
        CommentForm form = createCommentForm("author", "content");
        mockMvc.perform(multipart("/comment")
            .file((MockMultipartFile)form.file())
            .param("author", form.author())
            .param("content", form.content()))
        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("saveComment with invalid file should return bad request")
    public void saveComment_shouldReturnBadRequest() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/html", "not an image".getBytes());
        mockMvc.perform(multipart("/comment")
            .file(file)
            .param("author", "author")
            .param("content", "content"))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void getComment_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/comment/1"))
        .andExpect(status().isOk());
    }

    @Test
    public void updateComment_shouldReturnOk() throws Exception {
        CommentForm form = createCommentForm("author", "content");
        mockMvc.perform(multipart("/comment/1")
            .file((MockMultipartFile)form.file())
            .param("author", form.author())
            .param("content", form.content())
            .with(request -> {
                request.setMethod("PUT");
                return request;
            }))
        .andExpect(status().isOk());
    }

    @Test
    public void deleteComment_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/comment/1"))
        .andExpect(status().isOk());
    }

    public CommentForm createCommentForm(String author, String content) {
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", "an image".getBytes());
        CommentForm form = new CommentForm(author, content, file);
        return form;
    }
}
