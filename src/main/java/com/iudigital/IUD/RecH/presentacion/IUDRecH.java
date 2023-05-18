package com.iudigital.IUD.RecH.presentacion;

import com.iudigital.IUD.RecH.controller.RHController;
import com.iudigital.IUD.RecH.domain.RH;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IUDRecH {

    public static void crear(RHController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el tipo de identificacion del funcionario = ");
            int tipo_identificacion_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El tipo de identificacion es: " + tipo_identificacion_id);
            System.out.println("---------------------------");

            System.out.println("Digite el numero de identificacion del funcionario: ");
            String numero_identificacion = sc.nextLine();
            System.out.println("El numero de identificacion es: " + numero_identificacion);
            System.out.println("---------------------------");

            System.out.println("Digite el nombre del funcionario: ");
            String nombres = sc.nextLine();
            System.out.println("El nombre es: " + nombres);
            System.out.println("---------------------------");

            System.out.println("Digite el apellido del funcionario: ");
            String apellidos = sc.nextLine();
            System.out.println("El apellido es: " + apellidos);
            System.out.println("---------------------------");

            System.out.println("Digite el estado civil del funcionario = ");
            int estado_civil_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El estado civil es: " + estado_civil_id);
            System.out.println("---------------------------");

            System.out.println("Digite el sexo del funcionario: ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("---------------------------");

            System.out.println("Digite la direccion del funcionario: ");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: " + direccion);
            System.out.println("---------------------------");

            System.out.println("Digite telefono del funcionario: ");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            System.out.println("---------------------------");

            System.out.println("Digite la fecha de nacimiento del funcionario (dd/MM/yyyy): ");
            String fecha_nacimiento = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(dateFormat.parse(fecha_nacimiento));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            java.sql.Date fecha_de_nacimiento = new java.sql.Date(calendar.getTime().getTime());
            System.out.println("La fecha de nacimiento es: " + dateFormat.format(fecha_de_nacimiento));
            System.out.println("---------------------------");

            System.out.println("Digite el grupo familiar del funcionario = ");
            int grupo_familiar_id = sc.nextInt();
            System.out.println("El grupo familiar es: " + grupo_familiar_id);
            System.out.println("---------------------------");

            System.out.println("Digite la informacion academica del funcionario = ");
            int informacion_academica_id = sc.nextInt();
            System.out.println("La informacion academica es: " + informacion_academica_id);
            System.out.println("---------------------------");

            RH funcionario = new RH();
            funcionario.setTipo_identificacion_id(tipo_identificacion_id);
            funcionario.setNumero_identificacion(numero_identificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstado_civil_id(estado_civil_id);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFecha_de_nacimiento(fecha_de_nacimiento);
            funcionario.setGrupo_familiar_id(grupo_familiar_id);
            funcionario.setInformacion_academica_id(informacion_academica_id);
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado exitosamente!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void obtenerFuncionarios(RHController funcionarioController) {
        try {
            List<RH> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("funcionario_id: " + funcionario.getFuncionario_id());
                    System.out.println("Tipo de identificacion: " + funcionario.getTipo_identificacion_id());
                    System.out.println("Numero de identificacion: " + funcionario.getNumero_identificacion());
                    System.out.println("Nombres: " + funcionario.getNombres());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("Estado civil: " + funcionario.getEstado_civil_id());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Direccion: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("Fecha de nacimiento: " + funcionario.getFecha_de_nacimiento());
                    System.out.println("Grupo familiar: " + funcionario.getGrupo_familiar_id());
                    System.out.println("Informacion academica: " + funcionario.getInformacion_academica_id());
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println(" ");

                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void eliminarFuncionario(RHController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el ID del funcionario a eliminar:");
            int funcionario_id = sc.nextInt();
            System.out.println("El ID del funcionario a eliminar es: " + funcionario_id);
            RH funcionarioExiste = funcionarioController.obtenerFuncionario(funcionario_id);
            if (funcionarioExiste == null) {
                System.out.println("No existe funcionario!");
                return;
            }
            funcionarioController.eliminarFuncionario(funcionario_id);
            System.out.println("Funcionario eliminado exitosamente!");
            obtenerFuncionarios(funcionarioController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void actualizarFuncionario(RHController funcionarioController) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el ID del funcionario a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        try {
            
            RH funcionario = funcionarioController.obtenerFuncionario(id);            
            if (funcionario == null) {
                System.out.println("El funcionario con ID " + id + " no existe.");
                return;
            }
            
            System.out.println("Datos actuales del funcionario:");
            System.out.println("Tipo de identificación: " + funcionario.getTipo_identificacion_id());
            System.out.println("Número de identificación: " + funcionario.getNumero_identificacion());
            System.out.println("Nombres: " + funcionario.getNombres());
            System.out.println("Apellidos: " + funcionario.getApellidos());
            System.out.println("Estado civil: " + funcionario.getEstado_civil_id());
            System.out.println("Sexo: " + funcionario.getSexo());
            System.out.println("Dirección: " + funcionario.getDireccion());
            System.out.println("Teléfono: " + funcionario.getTelefono());
            System.out.println("Fecha de nacimiento: " + funcionario.getFecha_de_nacimiento());
            System.out.println("Grupo familiar: " + funcionario.getGrupo_familiar_id());
            System.out.println("Información académica: " + funcionario.getInformacion_academica_id());
            System.out.println("---------------------------");
            
            System.out.println("Digite el tipo de identificación del funcionario: ");
            int tipo_identificacion_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El tipo de identificación es: " + tipo_identificacion_id);
            System.out.println("---------------------------");

            System.out.println("Digite el número de identificación del funcionario: ");
            String numero_identificacion = sc.nextLine();
            System.out.println("El número de identificación es: " + numero_identificacion);
            System.out.println("---------------------------");

            System.out.println("Digite el nombre del funcionario: ");
            String nombres = sc.nextLine();
            System.out.println("El nombre es: " + nombres);
            System.out.println("---------------------------");

            System.out.println("Digite el apellido del funcionario: ");
            String apellidos = sc.nextLine();
            System.out.println("El apellido es: " + apellidos);
            System.out.println("---------------------------");

            System.out.println("Digite el estado civil del funcionario: ");
            int estado_civil_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El estado civil es: " + estado_civil_id);
            System.out.println("---------------------------");

            System.out.println("Digite el sexo del funcionario: ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("---------------------------");

            System.out.println("Digite la dirección del funcionario: ");
            String direccion = sc.nextLine();
            System.out.println("La dirección es: " + direccion);
            System.out.println("---------------------------");

            System.out.println("Digite el teléfono del funcionario: ");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            System.out.println("---------------------------");

            System.out.println("Digite la fecha de nacimiento del funcionario (dd/MM/yyyy): ");
            String fecha_nacimiento = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(dateFormat.parse(fecha_nacimiento));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            java.sql.Date fecha_de_nacimiento = new java.sql.Date(calendar.getTime().getTime());
            System.out.println("La fecha de nacimiento es: " + dateFormat.format(fecha_de_nacimiento));
            System.out.println("---------------------------");

            System.out.println("Digite el grupo familiar del funcionario: ");
            int grupo_familiar_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El grupo familiar es: " + grupo_familiar_id);
            System.out.println("---------------------------");

            System.out.println("Digite la información académica del funcionario: ");
            int informacion_academica_id = sc.nextInt();
            sc.nextLine();
            System.out.println("La información académica es: " + informacion_academica_id);
            System.out.println("---------------------------");
            
            funcionario.setTipo_identificacion_id(tipo_identificacion_id);
            funcionario.setNumero_identificacion(numero_identificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstado_civil_id(estado_civil_id);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFecha_de_nacimiento(fecha_de_nacimiento);
            funcionario.setGrupo_familiar_id(grupo_familiar_id);
            funcionario.setInformacion_academica_id(informacion_academica_id);
                     
            funcionarioController.actualizarFuncionario(funcionario.getFuncionario_id(), funcionario);

            System.out.println("El funcionario con ID " + id + " ha sido actualizado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: entrada inválida.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el funcionario con ID " + id + ": " + e.getMessage());
        }
    }
        

    public static void main(String[] args) {
        RHController funcionarioController = new RHController();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Elija una opción:");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crear(funcionarioController);
                    break;
                case 2:
                    obtenerFuncionarios(funcionarioController);
                    break;
                case 3:
                    actualizarFuncionario(funcionarioController);
                    break;
                case 4:
                    eliminarFuncionario(funcionarioController);
                    break;
                case 0:
                    System.out.println("Regresa pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        sc.close();
    }
}
