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

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.service.AgendaSlotService;

import jakarta.validation.Valid;

/**
 * Controlador REST para gerenciar os slots de agenda (horários disponíveis).
 * 
 * <p>Esta classe é anotada com {@link RestController}, expondo endpoints para
 * operações CRUD (Criar, Ler, Atualizar, Deletar) relacionadas aos slots de agenda.
 * O mapeamento base para as requisições é "/api/agendaslot".</p>
 * 
 * <p>Utiliza {@link AgendaSlotService} para a lógica de negócio e DTOs como
 * {@link AgendaSlotRequest} e {@link AgendaSlotResponse} para a comunicação.</p>
 */
@RestController
@RequestMapping("api/agendaslot")
public class AgendaSlotController {
	private final AgendaSlotService service;

	/**
     * Construtor que injeta a dependência do serviço de slots de agenda.
     * 
     * @param service O serviço que gerencia a lógica de negócio dos slots de agenda.
     */
	public AgendaSlotController(AgendaSlotService service) {
		this.service = service;
	}

	/**
     * Retorna uma lista de todos os slots de agenda.
     * 
     * <p><b>Exemplo de Resposta (JSON):</b></p>
     * <pre>
     * [
     *   {
     *     "id": "1",
     *     "inicio": "2025-10-25T09:00:00",
     *     "fim": "2025-10-25T10:00:00",
     *     "status": "DISPONIVEL"
     *   }
     * ]
     * </pre>
     * 
     * @return Uma lista de {@link AgendaSlotResponse}.
     */
	@GetMapping
	public List<AgendaSlotResponse> listarTodos(){
		return service.listarTodos();
	}
	
	/**
     * Cadastra um novo slot de agenda.
     * 
     * <p>Retorna o status HTTP 201 (Created) em caso de sucesso.</p>
     * 
     * <p><b>Exemplo de Requisição (JSON):</b></p>
     * <pre>
     * {
     *   "inicio": "2025-10-27T11:00:00",
     *   "fim": "2025-10-27T12:00:00",
     *   "docaId": "D1"
     * }
     * </pre>
     * 
     * @param request O corpo da requisição com os dados do novo slot, validado pela anotação {@link Valid}.
     * @return O {@link AgendaSlotResponse} do slot criado.
     */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendaSlotResponse cadastrar(@RequestBody @Valid AgendaSlotRequest request) {
		return service.cadastrar(request);
	}
	
	/**
     * Atualiza um slot de agenda existente.
     * 
     * <p>Retorna o status HTTP 200 (OK) em caso de sucesso.</p>
     * 
     * @param id O ID do slot a ser atualizado.
     * @param request O corpo da requisição com os dados atualizados.
     * @return O {@link AgendaSlotResponse} do slot atualizado.
     * @throws com.trilhalog.trilhalog.core.exceptions.custom.AgendaSlotNotFoundException Se o slot com o ID fornecido não for encontrado.
     */
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public AgendaSlotResponse editar(@PathVariable String id, @RequestBody AgendaSlotRequest request) {
		return service.editar(id, request);
	}
	
	/**
     * Busca um slot de agenda pelo seu ID.
     * 
     * @param id O ID do slot a ser buscado.
     * @return O {@link AgendaSlotResponse} correspondente ao ID.
     * @throws com.trilhalog.trilhalog.core.exceptions.custom.AgendaSlotNotFoundException Se o slot com o ID fornecido não for encontrado.
     */
	@GetMapping("/{id}")
	public AgendaSlotResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	/**
     * Deleta um slot de agenda pelo seu ID.
     * 
     * <p>Retorna o status HTTP 204 (No Content) em caso de sucesso.</p>
     * 
     * @param id O ID do slot a ser deletado.
     * @throws com.trilhalog.trilhalog.core.exceptions.custom.AgendaSlotNotFoundException Se o slot com o ID fornecido não for encontrado.
     */
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String id) {
		service.deletar(id);

	}

}
