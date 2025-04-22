CREATE TABLE IF NOT EXISTS TB_JOGADOR_TIME (
    id UUID PRIMARY KEY,
    id_jogador UUID,
    id_time UUID,
    codigo_torneio VARCHAR(255) NOT NULL
);
