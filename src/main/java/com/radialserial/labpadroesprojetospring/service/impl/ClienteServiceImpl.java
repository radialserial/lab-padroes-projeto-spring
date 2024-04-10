package com.radialserial.labpadroesprojetospring.service.impl;

import com.radialserial.labpadroesprojetospring.model.Cliente;
import com.radialserial.labpadroesprojetospring.model.ClienteRepository;
import com.radialserial.labpadroesprojetospring.model.Endereco;
import com.radialserial.labpadroesprojetospring.model.EnderecoRepository;
import com.radialserial.labpadroesprojetospring.service.ClienteService;
import com.radialserial.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService} para ser usada por meio de {@link Autowired}.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    private final ViaCepService viaCepService;

    /**
     * Construtor de Serviço de Cliente usando injeção por construtor ao invés de injeção por field.
     *
     * @see <a href="https://www.youtube.com/watch?v=aX-bgylmprA">Por que recomenda-se usar injeção por construtor</a>
     */
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // TODO deixar implementação de Optional mais robusta
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository
                .findById(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    return enderecoRepository.save(novoEndereco);
                });

        cliente.setEndereco(endereco);

        return clienteRepository.save(cliente);
    }

}
