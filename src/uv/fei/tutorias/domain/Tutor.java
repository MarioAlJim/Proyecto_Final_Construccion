package uv.fei.tutorias.domain;

import java.util.Objects;

public class Tutor {

    private String cuentaUV;
    private String contrasena;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;

    public void setCuentaUV(String cuentaUV) {
        this.cuentaUV = cuentaUV;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCuentaUV() {
        return cuentaUV;
    }

    public String getCorreo(){
        return correo;

    }

    public String getPassword(){
        return contrasena;

    }

    public String getNombre(){
        return nombre;

    }

    public String getApellidoPaterno(){
        return apellidoPaterno;

    }

    public String getApellidoMaterno(){
        return apellidoMaterno;

    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return cuentaUV == cuentaUV && Objects.equals(contrasena, tutor.contrasena) && Objects.equals(nombre, tutor.nombre) && Objects.equals(apellidoPaterno, tutor.apellidoPaterno) && Objects.equals(correo, tutor.correo);
    
    }
    
    private String nombreTutor;
    private String apellidoPaternoTutor;
    private String apellidoMaternoTutor;
    private int numeroDeTutorados;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getNumeroDeTutorados() {
        return numeroDeTutorados;
    }

    public void setNumeroDeTutorados(int numeroDeTutorados) {
        this.numeroDeTutorados = numeroDeTutorados;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getApellidoPaternoTutor() {
        return apellidoPaternoTutor;
    }

    public void setApellidoPaternoTutor(String apellidoPaternoTutor) {
        this.apellidoPaternoTutor = apellidoPaternoTutor;
    }

    public String getApellidoMaternoTutor() {
        return apellidoMaternoTutor;
    }

    public void setApellidoMaternoTutor(String apellidoMaternoTutor) {
        this.apellidoMaternoTutor = apellidoMaternoTutor;
    }

}

