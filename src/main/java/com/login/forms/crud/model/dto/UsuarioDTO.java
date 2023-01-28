package com.login.forms.crud.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.login.forms.crud.model.Usuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    @JsonProperty
    private String usuarioNomeCompleto;

    @JsonProperty
    private String usuarioEmail;

    @JsonProperty
    private String usuarioUserName;

    @JsonProperty
    private String usuarioPassword;

    public Usuario toConverterUsuarioDTO() {
        Usuario datas = new Usuario();
        datas.setUsuarioNomeCompleto(this.usuarioNomeCompleto);
        datas.setUsuarioEmail(this.usuarioEmail);
        datas.setUsuarioUserName(this.usuarioUserName);
        datas.setUsuarioPassword(this.usuarioPassword);
        return datas;
    }

}
