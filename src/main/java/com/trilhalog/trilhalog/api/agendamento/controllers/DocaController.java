package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.service.DocaService;

import jakarta.validation.Valid;

/**
 * Controlador REST para gerenciar as docas.
 * 
 * <p>Esta classe é anotada com {@link RestController} e mapeia as requisições
 * para o caminho base "/api/doca". Ela fornece endpoints para operações CRUD
 * relacionadas às docas.</p>
 * 
 * <p>A lógica de negócio é delegada ao {@link DocaService}, e a comunicação
 * com o cliente é feita através dos DTOs {@link DocaRequest} e {@link DocaResponse}.</p>
 */
@RestController
@RequestMapping("api/doca")
public class DocaController {
	private final DocaService service;

	/**
     * Construtor que injeta a dependência do serviço de docas.
     * 
     * @param service O serviço responsável pela lógica de negócio das docas.
     */
	public DocaController(DocaService service) {
		this.service = service;
	}
 
	/**
     * Retorna uma lista de todas as docas cadastradas.
     * 
     * <p><b>Exemplo de Resposta (JSON):</b></p>
     * <pre>
     * [
     *   {
     *     "id": "D1",
     *     "nome": "Doca Principal",
     *     "disponivel": true
     *   },
     *   {
     *     "id": "D2",
     *     "nome": "Doca Auxiliar",
     *     "disponivel": false
     *   }
     * ]
     * </pre>
     * 
     * @return Uma lista de {@link DocaResponse}.
     */
	@GetMapping
	public List<DocaResponse> listarTodos(){
		return service.listarTodos(); 
	}
	
	/**
     * Cadastra uma nova doca.
     * 
     * <p>Retorna o status HTTP 201 (Created) em caso de sucesso.</p>
     * 
     * <p><b>Exemplo de Requisição (JSON):</b></p>
     * <pre>
     * {
     *   "nome": "Doca de Carga Pesada",
     *   "disponivel": true
     * }
     * </pre>
     * 
     * @param request O corpo da requisição com os dados da nova doca, validado com {@link Valid}.
     * @return O {@link DocaResponse} da doca criada.
     */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DocaResponse cadastrar(@RequestBody @Valid DocaRequest request) {
		return service.cadastrar(request);
	}

	/**
     * Atualiza uma doca existente.
     * 
     * <p>Retorna o status HTTP 200 (OK) em caso de sucesso.</p>
     * 
     * @param id O ID da doca a ser atualizada.
     * @param request O corpo da requisição com os dados atualizados.
     * @return O {@link DocaResponse} da doca atualizada.
     * @throws com.trilhalog.trilhalog.core.exceptions.custom.DocaNotFoundException Se a doca com o ID fornecido não for encontrada.
     */
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public DocaResponse editar(@PathVariable String id, @RequestBody DocaRequest request) {
		return service.editar(id, request);
	}
    
    /**
     * Busca uma doca pelo seu ID.
     * 
     * @param id O ID da doca a ser buscada.
     * @return O {@link DocaResponse} correspondente ao ID.
     * @throws com.trilhalog.trilhalog.core.exceptions.custom.DocaNotFoundException Se a doca com o ID fornecido não for encontrada.
     */
	@GetMapping("/{id}")
	public DocaResponse buscarPorid(@PathVariable String id) {
		return service.buscarPorid(id);
	}
}
