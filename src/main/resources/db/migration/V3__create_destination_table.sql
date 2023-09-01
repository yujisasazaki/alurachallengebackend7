CREATE TABLE destination (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    photo_id BIGINT,

    CONSTRAINT fk_destination_photo_id FOREIGN KEY (photo_id) REFERENCES photo(id),
    CONSTRAINT ck_destination_name CHECK (char_length(name) <= 255)    
);