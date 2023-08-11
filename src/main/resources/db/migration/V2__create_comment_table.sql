CREATE TABLE comment (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    author TEXT NOT NULL,
    content TEXT NOT NULL,
    photo_id BIGINT,

    CONSTRAINT fk_comment_photo_id FOREIGN KEY (photo_id) REFERENCES photo(id),
    CONSTRAINT ck_comment_author CHECK (char_length(author) <= 255),
    CONSTRAINT ck_comment_content CHECK (char_length(content) <= 255)
);