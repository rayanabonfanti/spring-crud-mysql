package com.login.forms.crud.service;

import com.login.forms.crud.model.Usuario;
import com.login.forms.crud.model.dto.UsuarioDTO;
import com.login.forms.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("/usuarioService/")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioDTO.toConverterUsuarioDTO();
        Usuario existUsuario = getUsuarioUserName(usuario.getUsuarioUserName());
        if (Objects.isNull(existUsuario)) {
            usuarioRepository.save(usuario);
            return usuario;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Usuario usuario = getUsuarioId(id);
        usuarioRepository.deleteById(id);
        return true;
    }

    public Usuario editUsuario(Integer id, UsuarioDTO usuarioDTO) {
        Usuario usuario = getUsuarioId(id);
        if (!Objects.isNull(usuario)) {
            usuario.setUsuarioNomeCompleto(usuarioDTO.getUsuarioNomeCompleto());
            usuario.setUsuarioEmail(usuarioDTO.getUsuarioEmail());
            usuario.setUsuarioUserName(usuarioDTO.getUsuarioUserName());
            usuario.setUsuarioPassword(usuarioDTO.getUsuarioPassword());
            usuarioRepository.save(usuario);
            return usuario;
        }
        return null;
    }

    public Usuario getUsuarioUserName(String usuarioUserName){
        return usuarioRepository.findByUsuarioUserName(usuarioUserName);
    }

    public Usuario getUsuarioId(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElse(null);
    }

}
