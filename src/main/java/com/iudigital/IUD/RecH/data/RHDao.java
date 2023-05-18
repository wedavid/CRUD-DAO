package com.iudigital.IUD.RecH.data;

import com.iudigital.IUD.RecH.domain.RH;
import com.iudigital.IUD.RecH.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RHDao {

    private static final String GET_Funcionario = "select * from public.funcionarios";
    private static final String CREATE_Funcionario = "INSERT INTO public.funcionarios (tipo_identificacion_id, numero_identificacion, nombres, apellidos, "
            + "estado_civil_id, sexo, direccion, telefono, fecha_de_nacimiento, grupo_familiar_id, informacion_academica_id)"
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_Funcionario_BY_ID = "select * from public.funcionarios f where funcionario_id = ? ";
    private static final String UPDATE_Funcionario = "update Funcionarios set tipo_identificacion_id = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, "
            + "estado_civil_id = ?, sexo = ?, direccion = ?, telefono = ?, fecha_de_nacimiento = ?, grupo_familiar_id = ?, informacion_academica_id = ? where funcionario_id = ?";
    private static final String DELETE_Funcionario = "delete from Funcionarios where funcionario_id = ? ";

    public List<RH> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<RH> Funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_Funcionario);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RH funcionario = new RH();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_de_nacimiento(resultSet.getDate("Fecha_de_nacimiento"));
                funcionario.setGrupo_familiar_id(resultSet.getInt("grupo_familiar_id"));
                funcionario.setInformacion_academica_id(resultSet.getInt("informacion_academica_id"));
                Funcionarios.add(funcionario);
            }
            return Funcionarios;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(RH funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_Funcionario);
            preparedStatement.setInt(1, funcionario.getTipo_identificacion_id());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setInt(5, funcionario.getEstado_civil_id());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setDate(9, funcionario.getFecha_de_nacimiento());
            preparedStatement.setInt(10, funcionario.getGrupo_familiar_id());
            preparedStatement.setInt(11, funcionario.getInformacion_academica_id());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public RH obtenerFuncionarios(int funcionario_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RH funcionario = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_Funcionario_BY_ID);
            preparedStatement.setInt(1, funcionario_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new RH();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_de_nacimiento(resultSet.getDate("Fecha_de_nacimiento"));
                funcionario.setGrupo_familiar_id(resultSet.getInt("grupo_familiar_id"));
                funcionario.setInformacion_academica_id(resultSet.getInt("informacion_academica_id"));
            }
            return funcionario;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarFuncionario(int funcionario_id, RH funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_Funcionario);
            preparedStatement.setInt(1, funcionario.getTipo_identificacion_id());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setInt(5, funcionario.getEstado_civil_id());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setDate(9, funcionario.getFecha_de_nacimiento());
            preparedStatement.setInt(10, funcionario.getGrupo_familiar_id());
            preparedStatement.setInt(11, funcionario.getInformacion_academica_id());
            preparedStatement.setInt(12, funcionario_id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarFuncionario(int funcionario_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_Funcionario);
            preparedStatement.setInt(1, funcionario_id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
