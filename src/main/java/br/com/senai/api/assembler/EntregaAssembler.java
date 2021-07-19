package br.com.senai.api.assembler;

import br.com.senai.api.model.EntregaDTO;
import br.com.senai.api.model.input.EntregaInputDTO;
import br.com.senai.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaDTO toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInputDTO entregaInputDTO) {
        return modelMapper.map(entregaInputDTO, Entrega.class);
    }

    }
