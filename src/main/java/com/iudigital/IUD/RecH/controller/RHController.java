package com.iudigital.IUD.RecH.controller;

import com.iudigital.IUD.RecH.data.RHDao;
import com.iudigital.IUD.RecH.domain.RH;
import java.sql.SQLException;
import java.util.List;

public class RHController {

    private RHDao funcionarioDao;

    public RHController() {
        funcionarioDao = new RHDao();
    }

    public List<RH> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }
    
    public void crear(RH funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);    
    }
    
    public RH obtenerFuncionario(int funcionario_id) throws SQLException {
        return funcionarioDao.obtenerFuncionarios(funcionario_id);
    }
    
    public void actualizarFuncionario(int funcionario_id, RH funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(funcionario_id, funcionario);
    }
    
    public void eliminarFuncionario(int funcionario_id) throws SQLException {
        funcionarioDao.eliminarFuncionario(funcionario_id);
    }
}
