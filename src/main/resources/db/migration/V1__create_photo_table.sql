CREATE TABLE photo (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(255),
  type VARCHAR(255)
);