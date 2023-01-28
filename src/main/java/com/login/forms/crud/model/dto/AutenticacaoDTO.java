package com.login.forms.crud.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutenticacaoDTO {

    @JsonProperty
    private String usuarioUserName;

    @JsonProperty
    private String usuarioPassword;

}
