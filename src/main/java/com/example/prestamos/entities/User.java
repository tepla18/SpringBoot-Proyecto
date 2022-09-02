package com.example.prestamos.entities;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombres")
    private String nombres;
    @Column (name = "apellidos")
    private String apellidos;
    @Column (name = "edad")
    private int edad;
    @Column (name = "numeroDocumento")
    private String numeroDocumento;
    @Column (name = "correoElectronico")
    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name = "tipoDocumentoId")
    private TipoDocumento tipoDocumento;

    @Column(name = "perfil")
    private EnumPerfil perfil;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public EnumPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(EnumPerfil perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
