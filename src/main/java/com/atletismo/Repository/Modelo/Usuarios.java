package com.atletismo.Repository.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Usuarios {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_seq")
    @SequenceGenerator(name = "usuarios_id_seq", sequenceName = "usuarios_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "first_name")
    private String nombres;

    @Column(name = "last_name")
    private String apellidos;

    @Column(name = "address")
    private String direccion;

    @Column(name = "province")
    private String ciudad;

    @Column(name = "usua_email",nullable = false)
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

}
