package com.atletismo.Repository.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String nombres;

    @Column(name = "last_name")
    private String apellidos;

    @Column(name = "address")
    private String direccion;

    @Column(name = "province")
    private String ciudad;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone")
    private String telefono;

    @Column(name = "contact_name")
    private String contactoNombre;

    @Column(name = "contact_phone")
    private String contactoTelefono;

    @Column(name = "password")
    private String password;

    @Column(name = "birth_date")
    private Date fechaNacimiento;

    @Column(name = "gender")
    private Character sexo;

    @Column(name = "is_member")
    private Boolean estado;

    @Column(name = "is_approved")
    private Boolean estadoRegistro;

    @Column(name = "member_date")
    private Date fechaSuscripción;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Documentos> documentos;

    @OneToMany(mappedBy = "usuario")
    private List<Competidor> competidores;

}
