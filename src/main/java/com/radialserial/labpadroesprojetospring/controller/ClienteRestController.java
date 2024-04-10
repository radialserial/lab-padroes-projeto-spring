package com.radialserial.labpadroesprojetospring.controller;

import com.radialserial.labpadroesprojetospring.model.Cliente;
import com.radialserial.labpadroesprojetospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST que atua como uma <b>Facade</b>.
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    private final ClienteService clienteService;

    /**
     * Construtor de Controller de Cliente usando injeção por construtor ao invés de injeção por field.
     *
     * @see <a href="https://www.youtube.com/watch?v=aX-bgylmprA">Por que recomenda-se usar injeção por construtor</a>
     */
    @Autowired
    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.inserir(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
