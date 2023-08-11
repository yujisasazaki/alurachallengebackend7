package br.com.akrasia.alurachallengebackend7.model.comment;

public record CommentResponse (
    String author,
    String content,
    String photoUrl
){

    public CommentResponse(Comment comment, String photoUrl) {
        this(comment.getAuthor(), comment.getContent(), photoUrl);
    }
}