CREATE TABLE photo (
	id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name TEXT NOT NULL,
	type TEXT NOT NULL,

	CONSTRAINT ck_photo_name CHECK (char_length(name) <= 255),
	CONSTRAINT ck_photo_type CHECK (char_length(type) <= 255)
);