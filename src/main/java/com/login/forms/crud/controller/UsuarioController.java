package com.login.forms.crud.controller;

import com.login.forms.crud.model.Usuario;
import com.login.forms.crud.model.dto.UsuarioDTO;
import com.login.forms.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Usuario> listUsuario = usuarioService.listUsuarios();
            if (!listUsuario.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listUsuario);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foram encontrados registros de usuários!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        try {
            boolean removed = usuarioService.remove(id);
            if (removed) {
                return ResponseEntity.status(HttpStatus.OK).body(removed);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível remover usuário!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioService.editUsuario(id, usuarioDTO);
            if (!Objects.isNull(usuario)) {
                return ResponseEntity.status(HttpStatus.OK).body(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível editar esses usuários!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping(value="/saveUsuario/")
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuarioSave = usuarioService.saveUsuario(usuarioDTO);
            if (!Objects.isNull(usuarioSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(usuarioSave);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nao foi possivel cadastrar usuário!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{usuarioUserName}")
    public ResponseEntity<?> getUsuarioUserName(@PathVariable String usuarioUserName) {
        try {
            Usuario usuarioExist = usuarioService.getUsuarioUserName(usuarioUserName);
            if (!Objects.isNull(usuarioExist)) {
                return ResponseEntity.status(HttpStatus.OK).body(usuarioExist);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foi encontrado registro desse usuário!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
