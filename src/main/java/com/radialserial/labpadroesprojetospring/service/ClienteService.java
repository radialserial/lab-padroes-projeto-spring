package com.radialserial.labpadroesprojetospring.service;

import com.radialserial.labpadroesprojetospring.model.Cliente;

/**
 * Interface para o padrão <b>Strategy</b>.
 */
public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(Cliente cliente);

    void atualizar(Long id, Cliente cLiente);

    void deletar(Long id);
}
