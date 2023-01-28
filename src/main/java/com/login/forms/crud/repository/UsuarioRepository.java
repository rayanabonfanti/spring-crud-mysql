package com.login.forms.crud.repository;

import com.login.forms.crud.model.Usuario;
import com.login.forms.crud.model.interfaces.UsuarioInterfaceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuarioUserName(String usuarioUserName);
    Optional<Usuario> findById(Integer id);
}
