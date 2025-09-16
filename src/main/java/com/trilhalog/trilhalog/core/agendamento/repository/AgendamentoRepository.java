package com.trilhalog.trilhalog.core.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento,String>{

}
