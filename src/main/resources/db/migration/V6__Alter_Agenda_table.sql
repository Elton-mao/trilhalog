ALTER TABLE agendamentos 
    ADD CONSTRAINT agendamento_usuario
    Foreign KEY (usuario_id) REFERENCES usuarios(usuario_id); 

    ALTER TABLE agendamentos 
    ADD CONSTRAINT agenda_slot_agendamento
    Foreign KEY (agenda_slot_id) REFERENCES agenda_slots( agenda_slot_id); 

    ALTER TABLE agendamentos 
    ADD CONSTRAINT carga_agendamento
    Foreign KEY (carga_id) REFERENCES cargas(carga_id) ON DELETE CASCADE; 