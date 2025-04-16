CREATE TABLE IF NOT EXISTS TB_SET (
    id_set UUID PRIMARY KEY,
    primeiro_set_timeA INTEGER,
    primeiro_set_timeB INTEGER,
    segundo_set_timeA INTEGER,
    segundo_set_timeB INTEGER,
    terceiro_set_timeA INTEGER,
    terceiro_set_timeB INTEGER,
    id_timeA UUID NOT NULL,
    id_timeB UUID NOT NULL,
    vencedor_timeA_partida BOOLEAN,
    vencedor_timeB_partida BOOLEAN
);
