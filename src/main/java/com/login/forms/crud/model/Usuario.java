package com.login.forms.crud.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "usuario_nome_completo", nullable = false)
    private String usuarioNomeCompleto;

    @Column(name = "usuario_email", nullable = false)
    private String usuarioEmail;

    @Column(name = "usuario_username", nullable = false)
    private String usuarioUserName;

    @Column(name = "usuario_password", nullable = false)
    private String usuarioPassword;
}
