package br.com.senai.domain.service;

import br.com.senai.api.assembler.EntregaAssembler;
import br.com.senai.api.model.EntregaDTO;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private PessoaService pessoaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    public Entrega solicitar(Entrega entrega) {
        Pessoa pessoa = pessoaService.buscar(entrega.getPessoa().getId());
        entrega.setPessoa(pessoa);

        return entregaRepository.save(entrega);
    }
    public List<EntregaDTO> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    public List<EntregaDTO> filtroStatus(String status) {
        return entregaAssembler.toCollectionModel(entregaRepository.findByStatus(status));
    }

    public ResponseEntity<EntregaDTO> buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    return ResponseEntity.ok(entregaAssembler.toModel(entrega));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}