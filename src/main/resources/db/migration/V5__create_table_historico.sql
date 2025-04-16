CREATE TABLE historico (
    id_historico INT PRIMARY KEY,
    id_equipe INT,
    id_placar INT,
    data DATE NOT NULL,
    qnt_pontos INT,
    total_pontos INT,
    CONSTRAINT fk_historico_equipe FOREIGN KEY (id_equipe) REFERENCES equipe(id_equipe),
    CONSTRAINT fk_historico_placar FOREIGN KEY (id_placar) REFERENCES placar(id_placar)
);
