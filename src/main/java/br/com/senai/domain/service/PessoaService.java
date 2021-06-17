package br.com.senai.domain.service;

import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> listarPorNome(@PathVariable String pessoaNome) {
        return pessoaRepository.findByNome(pessoaNome);
    }

    public List<Pessoa> listarNomeContaining(@PathVariable String nomeContaining) {
        return pessoaRepository.findByNomeContaining(nomeContaining);
    }

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa){
        boolean emailvalidation = pessoaRepository.findByEmail(pessoa.getEmail())
                .isPresent();

        if(emailvalidation) {
            throw new NegocioException("Já existe uma pessoa com este e-mail cadastrado.");
        }

        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public ResponseEntity<Object> excluir(Long pessoaId) {

        if(!pessoaRepository.existsById(pessoaId)) {
            throw new NegocioException("Não existe ninguém com esse ID!");
        }
        pessoaRepository.deleteById(pessoaId);
        return null;
    }

    @Transactional
    public ResponseEntity<Pessoa> editar( Long pessoaId, Pessoa pessoa){
        if(!pessoaRepository.existsById(pessoaId)) {
            throw new NegocioException("Não existe ninguém com esse ID!");
        }
        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(pessoa);
    }

    public Pessoa buscar(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
    }
}
