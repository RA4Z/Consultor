package br.com.weg.api.assembler;

import br.com.weg.api.model.PessoaDTO;
import br.com.weg.api.model.input.PessoaInputDTO;
import br.com.weg.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PessoaAssembler {

    private ModelMapper modelMapper;

    public PessoaDTO toModel(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Pessoa toEntity(PessoaInputDTO pessoaInputDTO) {
        return modelMapper.map(pessoaInputDTO, Pessoa.class);
    }

}
