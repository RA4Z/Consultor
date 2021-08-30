package br.com.weg.domain.service;

import br.com.weg.api.assembler.UsuarioAssembler;
import br.com.weg.api.model.UsuarioDTO;
import br.com.weg.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    UsuarioAssembler usuarioAssembler;
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listar() {
        return usuarioAssembler.toCollectionModel(usuarioRepository.findAll());
    }

    public List<UsuarioDTO> listarEmail(String email) {
        return usuarioAssembler.toCollectionModel(usuarioRepository.encontrarEmail(email));
    }
}
