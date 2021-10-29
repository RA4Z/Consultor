package br.com.weg.api.assembler;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.api.model.input.CardsInputDTO;
import br.com.weg.domain.model.Cards;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CardsAssembler {

    private ModelMapper modelMapper;

    public CardsDTO toModel(Cards cards) {
        return modelMapper.map(cards, CardsDTO.class);
    }

    public List<CardsDTO> toCollectionModel(List<Cards> entregases) {
        return entregases.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Cards toEntity(CardsInputDTO cardsInputDTO) {
        return modelMapper.map(cardsInputDTO, Cards.class);
    }

    }
