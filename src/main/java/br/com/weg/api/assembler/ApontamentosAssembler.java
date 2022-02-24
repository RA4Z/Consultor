package br.com.weg.api.assembler;

import br.com.weg.api.model.input.ApontamentoInputDTO;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.api.model.ApontamentoDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ApontamentosAssembler {

    private ModelMapper modelMapper;

    public ApontamentoDTO toModel(Apontamento apontamento){
        return modelMapper.map(apontamento, ApontamentoDTO.class);
    }

    public List<ApontamentoDTO> toCollectionModel(List<Apontamento> apontamentos){
        return apontamentos.stream()
                .map((this::toModel))
                        .collect(Collectors.toList());
    }
    public Apontamento toEntity(ApontamentoInputDTO apontamentoInputDTO) {
        return modelMapper.map(apontamentoInputDTO, Apontamento.class);
    }

}
