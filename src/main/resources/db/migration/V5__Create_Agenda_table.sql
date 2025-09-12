
CREATE TABLE agendamentos(
    agendamento_id VARCHAR(36) PRIMARY KEY,
    status_agendamento VARCHAR(30),
    tipo_agendamento VARCHAR(30) NOT NULL,
    agenda_slot_id VARCHAR(36) NOT NULL,
    carga_id VARCHAR(36) NOT NULL UNIQUE,
    usuario_id VARCHAR(36) NOT NULL
);
