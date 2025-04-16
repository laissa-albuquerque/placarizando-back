CREATE TABLE placar (
    id_placar INT PRIMARY KEY,
    id_equipe INT,
    pontos INT NOT NULL,
    data DATE NOT NULL,
    CONSTRAINT fk_placar_equipe FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe)
);
