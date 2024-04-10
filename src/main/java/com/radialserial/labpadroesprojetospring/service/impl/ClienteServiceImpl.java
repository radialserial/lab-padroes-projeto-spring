package com.radialserial.labpadroesprojetospring.service.impl;

import com.radialserial.labpadroesprojetospring.model.Cliente;
import com.radialserial.labpadroesprojetospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService} para ser usada por meio de {@link Autowired}.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // TODO Singleton: Injetar componentes do Spring com @Autowired;
    // TODO Strategy: Implementar métodos definidos na interface;
    // TODO Facade: Abstrair integrações com subsistemas;

    @Override
    public Iterable<Cliente> buscarTodos() {
        // TODO Buscar todos os clientes
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // TODO Buscar cliente por ID
        return null;
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        // TODO Verificar se endereço já existe (por meio de CEP);
        // Caso não exista, integrar com ViaCEP e persistir o retorno

        // TODO Inserir cliente, vinculando endereço (novo ou existente
    }

    @Override
    public void atualizar(Long id, Cliente cLiente) {
        // TODO Buscar cliente por ID, caso exista;

        // TODO Verificar se endereço já existe (por meio de CEP);
        // Caso não exista, integrar com ViaCEP e persistir o retorno

        // TODO Alterar cliente, vinculando o endereço (novo ou existente)
    }

    @Override
    public void deletar(Long id) {
        // TODO Deletar cliente
    }
}
