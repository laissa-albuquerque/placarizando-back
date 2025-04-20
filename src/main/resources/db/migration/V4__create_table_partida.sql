CREATE TABLE IF NOT EXISTS  TB_PARTIDA (
    id_partida UUID PRIMARY KEY,
    data_jogo_inicial TIMESTAMP NOT NULL,
    id_set UUID,
    codigo_campeonato VARCHAR(255) UNIQUE NOT NULL,
    CONSTRAINT fk_partida_set FOREIGN KEY (id_set) REFERENCES TB_SET(id_set)
);