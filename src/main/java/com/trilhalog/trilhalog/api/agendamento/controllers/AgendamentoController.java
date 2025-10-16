package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.repository.AgendamentoRepository;
import com.trilhalog.trilhalog.core.agendamento.service.AgendamentoService;

/**
 * Controlador REST para gerenciar agendamentos.
 * 
 * <p>Esta classe é anotada com {@link RestController}, o que a torna um bean do Spring
 * que lida com requisições HTTP. O mapeamento base para as requisições é "/api/agendamento",
 * definido pela anotação {@link RequestMapping}.</p>
 * 
 * <p>Este controlador utiliza {@link AgendamentoService} para a lógica de negócio
 * e se comunica com o cliente através de DTOs como {@link AgendamentoRequest} e
 * {@link AgendamentoResponse}.</p>
 */
@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {

	private final AgendamentoService service;
	private final AgendamentoRepository repository;

	/**
     * Construtor para injeção de dependências do serviço de agendamento e repositório.
     * 
     * @param service O serviço que implementa a lógica de negócio para agendamentos.
     * @param repository O repositório para acesso direto aos dados, usado para fins de teste.
     */
	public AgendamentoController(AgendamentoService service,AgendamentoRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	/**
     * Retorna uma lista de todos os agendamentos.
     * 
     * <p>Este método lida com requisições GET para "/api/agendamento".</p>
     * 
     * <p><b>Exemplo de Resposta (JSON):</b></p>
     * <pre>
     * [
     *   {
     *     "id": "1",
     *     "dataAgendamento": "2025-10-25T10:00:00",
     *     "status": "AGENDADO",
     *     ...
     *   }
     * ]
     * </pre>
     * 
     * @return Uma lista de {@link AgendamentoResponse} contendo os dados dos agendamentos.
     */
	@GetMapping
	public List<AgendamentoResponse> buscarTodos() {
		return service.buscarTodos();
		
		}
	
	/**
     * Método de teste para buscar um agendamento pelo ID.
     * 
     * <p><b>Atenção:</b> Este é um endpoint de teste e não deve ser usado em produção.</p>
     * 
     * @param id O ID do agendamento a ser buscado.
     * @return Uma string "ok" se a operação for concluída.
     * @deprecated Para fins de teste.
     */
	@GetMapping("/{id}")
	public String buscarteste(@PathVariable String id) {
		System.out.println(repository.findAll());
		return "ok";
	}

	/**
     * Cria um novo agendamento.
     * 
     * <p>Este método lida com requisições POST para "/api/agendamento".
     * Retorna o status HTTP 201 (Created) em caso de sucesso.</p>
     * 
     * <p><b>Exemplo de Requisição (JSON):</b></p>
     * <pre>
     * {
     *   "transportadoraId": "123",
     *   "dataAgendamento": "2025-10-26T14:00:00",
     *   "tipoAgendamento": "CARGA"
     * }
     * </pre>
     * 
     * <p><b>Exemplo de Resposta (JSON):</b></p>
     * <pre>
     * {
     *   "id": "2",
     *   "dataAgendamento": "2025-10-26T14:00:00",
     *   "status": "PENDENTE",
     *   ...
     * }
     * </pre>
     * 
     * @param request O corpo da requisição contendo os dados do agendamento a ser criado.
     * @return Um {@link AgendamentoResponse} com os dados do agendamento criado.
     */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendamentoResponse agendar(@RequestBody AgendamentoRequest request) {
		return service.agendar(request);
	}

	/**
     * Deleta um agendamento pelo seu ID.
     * 
     * <p>Este método lida com requisições DELETE para "/api/agendamento".
     * Retorna o status HTTP 204 (No Content) em caso de sucesso.</p>
     * 
     * @param id O ID do agendamento a ser deletado.
     */
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(String id) {
		service.deletar(id);
	}

	/**
     * Altera o status de um agendamento existente.
     * 
     * <p>Este método lida com requisições PUT para "/api/agendamento".</p>
     * 
     * @param id O ID do agendamento a ser alterado.
     * @param status O novo status do agendamento.
     */
	@PutMapping
	public void alterarStatus(String id, StatusDoAgendamento status) {
		service.alterarStatus(id, status);
	}

}
