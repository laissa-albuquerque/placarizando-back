CREATE TABLE IF NOT EXISTS TB_JOGADOR (
    id_jogador UUID PRIMARY KEY,
    nome_jogador VARCHAR(255) NOT NULL,
    nota INTEGER,
    codigo_campeonato VARCHAR(255) UNIQUE NOT NULL,
    id_time UUID
);
