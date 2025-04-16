CREATE TABLE IF NOT EXISTS TB_JOGADOR (
    id_jogador UUID PRIMARY KEY,
    nome_jogador VARCHAR(255) NOT NULL,
    nota INTEGER,
    id_time UUID NOT NULL,
    CONSTRAINT fk_jogador_time FOREIGN KEY (id_time) REFERENCES tb_time(id_time)
);
