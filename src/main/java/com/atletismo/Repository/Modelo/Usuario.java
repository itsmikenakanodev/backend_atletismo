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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFechaSuscripción() {
        return fechaSuscripción;
    }

    public void setFechaSuscripción(Date fechaSuscripción) {
        this.fechaSuscripción = fechaSuscripción;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Documentos> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentos> documentos) {
        this.documentos = documentos;
    }

    public List<Competidor> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(List<Competidor> competidores) {
        this.competidores = competidores;
    }
}
