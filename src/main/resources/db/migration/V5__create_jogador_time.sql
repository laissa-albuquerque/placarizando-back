CREATE TABLE IF NOT EXISTS TB_JOGADOR_TIME (
    id UUID PRIMARY KEY,
    id_jogador UUID,
    id_time UUID,
    codigo_campeonato VARCHAR(255) UNIQUE NOT NULL
);
