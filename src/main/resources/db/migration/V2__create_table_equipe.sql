CREATE TABLE equipe (
    id_equipe INT PRIMARY KEY,
    nome_equipe VARCHAR(255) NOT NULL,
    id_lider INT,
    cor_equipe VARCHAR(255),
    CONSTRAINT fk_lider FOREIGN KEY (id_lider) REFERENCES pessoa(id_pessoa)
);
