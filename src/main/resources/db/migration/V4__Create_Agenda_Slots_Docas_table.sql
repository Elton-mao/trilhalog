CREATE TABLE docas(
	doca_id VARCHAR(36) PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE 
);

CREATE TABLE agenda_slots (
    agenda_slot_id VARCHAR(36) PRIMARY KEY,
    `data` DATE NOT NULL,
    hora TIME NOT NULL,
    vagas_totais INT NOT NULL,
    vagas_disponiveis INT,
    doca_id VARCHAR(36) NOT NULL,
    CONSTRAINT uq_doca_horario UNIQUE(doca_id, `data`, hora),
    FOREIGN KEY (doca_id) REFERENCES docas(doca_id)
);
