package br.com.weg.domain.service;


import br.com.weg.domain.exception.NegocioException;
import br.com.weg.domain.model.Pessoa;
import br.com.weg.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public Pessoa buscar(Long pessoaId){
        return pessoaRepository.findById(pessoaId).orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
    }
}