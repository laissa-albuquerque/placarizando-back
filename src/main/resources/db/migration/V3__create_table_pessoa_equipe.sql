CREATE TABLE pessoa_equipe (
    id_pessoa INT,
    id_equipe INT,
    PRIMARY KEY (id_pessoa, id_equipe),
    CONSTRAINT fk_pe_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa),
    CONSTRAINT fk_pe_equipe FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe)
);
