
package com.iudigital.IUD.RecH.domain;

import java.sql.Date;

public class RH {
    private int funcionario_id;
    private int tipo_identificacion_id;
    private String numero_identificacion;
    private String nombres;
    private String apellidos;
    private int estado_civil_id;
    private String sexo;
    private String direccion;
    private String telefono;
    private Date fecha_de_nacimiento;
    private int grupo_familiar_id;
    private int informacion_academica_id;   

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getTipo_identificacion_id() {
        return tipo_identificacion_id;
    }

    public void setTipo_identificacion_id(int tipo_identificacion_id) {
        this.tipo_identificacion_id = tipo_identificacion_id;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
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

    public int getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(int estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public int getGrupo_familiar_id() {
        return grupo_familiar_id;
    }

    public void setGrupo_familiar_id(int grupo_familiar_id) {
        this.grupo_familiar_id = grupo_familiar_id;
    }

    public int getInformacion_academica_id() {
        return informacion_academica_id;
    }

    public void setInformacion_academica_id(int informacion_academica_id) {
        this.informacion_academica_id = informacion_academica_id;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
    
    
    
}
