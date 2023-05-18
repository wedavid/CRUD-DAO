/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iudigital.IUD.RecH.presentacion;

import com.iudigital.IUD.RecH.controller.RHController;
import com.iudigital.IUD.RecH.domain.RH;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wedav
 */
public class Main extends javax.swing.JFrame {

    private final RHController funcionarioRHController;
    private final static String[] COLUMNS = {"ID", "TIPO ID", "# ID", "NOMBRES", "APELLIDOS", "EST. CIVIL", "SEXO",
        "DIRECCION", "TELEFONO", "FEC. NACIMIENTO", "GR. FAMILIAR", "INF. ACADEMICA"};
    private final static String SELECCIONE = "--SELECCIONES--";

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        txtFuncionarioID.setEditable(false);
        funcionarioRHController = new RHController();
        listFuncionarios();
        addListener();
    }

    private void listFuncionarios() {

        cbxFuncionario.removeAllItems();
        RH funcionario1 = new RH();
        funcionario1.setNombres(SELECCIONE);
        funcionario1.setApellidos("");
        cbxFuncionario.addItem(funcionario1);
        DefaultTableModel defaulTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaulTableModel.addColumn(COLUMN);
        }

        tblRH.setModel(defaulTableModel);
        try {
            List<RH> funcionarios = funcionarioRHController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaulTableModel.setRowCount((funcionarios.size()));
            int row = 0;
            for (RH funcionario : funcionarios) {
                defaulTableModel.setValueAt(funcionario.getFuncionario_id(), row, 0);
                defaulTableModel.setValueAt(funcionario.getTipo_identificacion_id(), row, 1);
                defaulTableModel.setValueAt(funcionario.getNumero_identificacion(), row, 2);
                defaulTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaulTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaulTableModel.setValueAt(funcionario.getEstado_civil_id(), row, 5);
                defaulTableModel.setValueAt(funcionario.getSexo(), row, 6);
                defaulTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaulTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaulTableModel.setValueAt(funcionario.getFecha_de_nacimiento(), row, 9);
                defaulTableModel.setValueAt(funcionario.getGrupo_familiar_id(), row, 10);
                defaulTableModel.setValueAt(funcionario.getInformacion_academica_id(), row, 11);
                row++;
                cbxFuncionario.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionario.addItemListener(event -> {
            RH seledtedFuncionario = (RH) event.getItem();
            if (seledtedFuncionario.getNombres().equals(SELECCIONE)) {
                txtFuncionarioID.setText("");
                txtTipoIDEdit.setText("");
                txtIDEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                txtGrupoFamiliarEdit.setText("");
                txtInformacionAcademicaEdit.setText("");
            } else {
                txtFuncionarioID.setText(String.valueOf(seledtedFuncionario.getFuncionario_id()));
                txtTipoIDEdit.setText(String.valueOf(seledtedFuncionario.getTipo_identificacion_id()));
                txtIDEdit.setText(seledtedFuncionario.getNumero_identificacion());
                txtNombresEdit.setText(seledtedFuncionario.getNombres());
                txtApellidosEdit.setText(seledtedFuncionario.getApellidos());
                txtEstadoCivilEdit.setText(String.valueOf(seledtedFuncionario.getEstado_civil_id()));
                txtSexoEdit.setText(seledtedFuncionario.getSexo());
                txtDireccionEdit.setText(seledtedFuncionario.getDireccion());
                txtTelefonoEdit.setText(seledtedFuncionario.getTelefono());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fechaNacimientoString = dateFormat.format(seledtedFuncionario.getFecha_de_nacimiento());
                txtFechaNacimientoEdit.setText(fechaNacimientoString);
                txtGrupoFamiliarEdit.setText(String.valueOf(seledtedFuncionario.getGrupo_familiar_id()));
                txtInformacionAcademicaEdit.setText(String.valueOf(seledtedFuncionario.getInformacion_academica_id()));
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPRH = new javax.swing.JPanel();
        lblTipID = new javax.swing.JLabel();
        lblNoID = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEstCivil = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblGrupoFamiliar = new javax.swing.JLabel();
        lblInformacionAcademica = new javax.swing.JLabel();
        txtTipoID = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtGrupoFamiliar = new javax.swing.JTextField();
        txtInformacionAcademica = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPRH1 = new javax.swing.JPanel();
        lblFuncionario = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        lblID = new javax.swing.JLabel();
        txtFuncionarioID = new javax.swing.JTextField();
        lblTipIDEdit = new javax.swing.JLabel();
        txtTipoIDEdit = new javax.swing.JTextField();
        lblNoIDEdit = new javax.swing.JLabel();
        txtIDEdit = new javax.swing.JTextField();
        lblNombresEdit = new javax.swing.JLabel();
        txtNombresEdit = new javax.swing.JTextField();
        lblApellidosEdit = new javax.swing.JLabel();
        txtApellidosEdit = new javax.swing.JTextField();
        lblEstadoCivilEdit = new javax.swing.JLabel();
        txtEstadoCivilEdit = new javax.swing.JTextField();
        lblSexoEdit = new javax.swing.JLabel();
        txtSexoEdit = new javax.swing.JTextField();
        lblDireccionEdit = new javax.swing.JLabel();
        txtDireccionEdit = new javax.swing.JTextField();
        lblTelefonoEdit = new javax.swing.JLabel();
        txtTelefonoEdit = new javax.swing.JTextField();
        lblFechaNacimientoEdit = new javax.swing.JLabel();
        txtFechaNacimientoEdit = new javax.swing.JTextField();
        lblGrupoFamiliarEdit = new javax.swing.JLabel();
        txtGrupoFamiliarEdit = new javax.swing.JTextField();
        lblInformacionAcademicaEdit = new javax.swing.JLabel();
        txtInformacionAcademicaEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("RECURSOS HUMANOS IUD");

        jPRH.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipID.setText("TIPO ID");

        lblNoID.setText("# ID");

        lblNombres.setText("NOMBRES");

        lblApellidos.setText("APELLIDOS");

        lblEstCivil.setText("EST. CIVIL");

        lblSexo.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblTelefono.setText("TELEFONO");

        lblFechaNacimiento.setText("FEC. NACIMIENTO");

        lblGrupoFamiliar.setText("GR. FAMILIAR");

        lblInformacionAcademica.setText("INF. ACADEMICA");

        txtTipoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoIDActionPerformed(evt);
            }
        });

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        btnCrear.setText("Guardar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRHLayout = new javax.swing.GroupLayout(jPRH);
        jPRH.setLayout(jPRHLayout);
        jPRHLayout.setHorizontalGroup(
            jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRHLayout.createSequentialGroup()
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPRHLayout.createSequentialGroup()
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblTipID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblNoID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(lblNombres))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRHLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRHLayout.createSequentialGroup()
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtDireccion)
                                .addGap(71, 71, 71)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPRHLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)
                                .addComponent(lblTelefono)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)))
                .addGap(32, 32, 32)
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRHLayout.createSequentialGroup()
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addGap(71, 71, 71))
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblEstCivil))
                            .addGroup(jPRHLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblGrupoFamiliar))
                            .addComponent(txtGrupoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPRHLayout.createSequentialGroup()
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPRHLayout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPRHLayout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPRHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInformacionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInformacionAcademica))))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPRHLayout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(btnCrear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPRHLayout.setVerticalGroup(
            jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRHLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipID)
                    .addComponent(lblNoID)
                    .addComponent(lblNombres)
                    .addComponent(lblApellidos)
                    .addComponent(lblSexo)
                    .addComponent(lblEstCivil))
                .addGap(14, 14, 14)
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblGrupoFamiliar)
                    .addComponent(lblInformacionAcademica))
                .addGap(18, 18, 18)
                .addGroup(jPRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrupoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInformacionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblRH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPRH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Crear Funcionario", jPanel1);

        jPRH1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        lblFuncionario.setText("FUNCIONARIO");

        cbxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionarioActionPerformed(evt);
            }
        });

        lblID.setText("ID");

        lblTipIDEdit.setText("TIPO ID");

        lblNoIDEdit.setText("# ID");

        lblNombresEdit.setText("NOMBRES");

        lblApellidosEdit.setText("APELLIDOS");

        txtApellidosEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosEditActionPerformed(evt);
            }
        });

        lblEstadoCivilEdit.setText("EST. CIVIL");

        lblSexoEdit.setText("SEXO");

        lblDireccionEdit.setText("DIRECCION");

        lblTelefonoEdit.setText("TELEFONO");

        lblFechaNacimientoEdit.setText("FEC. NACIMIENTO");

        txtFechaNacimientoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoEditActionPerformed(evt);
            }
        });

        lblGrupoFamiliarEdit.setText("GR. FAMILIAR");

        lblInformacionAcademicaEdit.setText("INF. ACADEMICA");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRH1Layout = new javax.swing.GroupLayout(jPRH1);
        jPRH1.setLayout(jPRH1Layout);
        jPRH1Layout.setHorizontalGroup(
            jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRH1Layout.createSequentialGroup()
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPRH1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(lblDireccionEdit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPRH1Layout.createSequentialGroup()
                        .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPRH1Layout.createSequentialGroup()
                                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPRH1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPRH1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lblFuncionario))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRH1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblTipIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(78, 78, 78)
                                .addComponent(lblNoIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRH1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPRH1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuncionarioID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPRH1Layout.createSequentialGroup()
                                        .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPRH1Layout.createSequentialGroup()
                                        .addComponent(txtTipoIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(txtIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRH1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPRH1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPRH1Layout.createSequentialGroup()
                                    .addComponent(txtGrupoFamiliarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtInformacionAcademicaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPRH1Layout.createSequentialGroup()
                                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPRH1Layout.createSequentialGroup()
                                .addComponent(lblGrupoFamiliarEdit)
                                .addGap(72, 72, 72)
                                .addComponent(lblInformacionAcademicaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPRH1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblNombresEdit)
                        .addGap(92, 92, 92)
                        .addComponent(lblApellidosEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(221, 221, 221))
            .addGroup(jPRH1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(btnActualizar)
                .addGap(58, 58, 58)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPRH1Layout.setVerticalGroup(
            jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRH1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblNoIDEdit)
                    .addComponent(lblNombresEdit)
                    .addComponent(lblEstadoCivilEdit)
                    .addComponent(lblTipIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidosEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblFechaNacimientoEdit)
                    .addComponent(lblGrupoFamiliarEdit)
                    .addComponent(lblInformacionAcademicaEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInformacionAcademicaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrupoFamiliarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPRH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPRH1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPRH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Editar Funcionario", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoIDActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosEditActionPerformed

    private void txtFechaNacimientoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoEditActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        if (txtTipoID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo ID");
            txtTipoID.requestFocus();
            return;
        }

        if (txtID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID");
            txtID.requestFocus();
            return;
        }

        if (txtNombres.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre");
            txtNombres.requestFocus();
            return;
        }

        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el apellido");
            txtApellidos.requestFocus();
            return;
        }

        if (txtEstadoCivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado civil");
            txtEstadoCivil.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechaNacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimiento.requestFocus();
            return;
        }

        if (txtGrupoFamiliar.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el grupo familiar");
            txtGrupoFamiliar.requestFocus();
            return;
        }

        if (txtInformacionAcademica.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la informacion academica");
            txtInformacionAcademica.requestFocus();
            return;
        }

        try {
            RH funcionario = new RH();
            funcionario.setTipo_identificacion_id(Integer.parseInt(txtTipoID.getText().trim()));
            funcionario.setNumero_identificacion(txtID.getText().trim());
            funcionario.setNombres(txtNombres.getText().trim());
            funcionario.setApellidos(txtApellidos.getText().trim());
            funcionario.setEstado_civil_id(Integer.parseInt(txtEstadoCivil.getText().trim()));
            funcionario.setSexo(txtSexo.getText().trim());
            funcionario.setDireccion(txtDireccion.getText().trim());
            funcionario.setTelefono(txtTelefono.getText().trim());
            String fechaNacimientoText = txtFechaNacimiento.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.util.Date fechaNacimientoUtil = dateFormat.parse(fechaNacimientoText);
                java.sql.Date fechaNacimientoSql = new java.sql.Date(fechaNacimientoUtil.getTime());
                funcionario.setFecha_de_nacimiento(fechaNacimientoSql);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            funcionario.setGrupo_familiar_id(Integer.parseInt(txtGrupoFamiliar.getText().trim()));
            funcionario.setInformacion_academica_id(Integer.parseInt(txtInformacionAcademica.getText().trim()));

            funcionarioRHController.crear(funcionario);
            txtTipoID.setText("");
            txtID.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");
            txtGrupoFamiliar.setText("");
            txtInformacionAcademica.setText("");
            listFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No fue posible crear el funcionario!");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtFuncionarioID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario");
            txtFuncionarioID.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar el funcinario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioRHController.eliminarFuncionario(Integer.parseInt(txtFuncionarioID.getText()));
                txtFuncionarioID.setText("");
                txtTipoID.setText("");
                txtID.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                txtEstadoCivil.setText("");
                txtSexo.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtFechaNacimiento.setText("");
                txtGrupoFamiliar.setText("");
                txtInformacionAcademica.setText("");
                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Se eliminó el funcionario correctamente!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtFuncionarioID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciones un funcionario de la lista");
            txtFuncionarioID.requestFocus();
            return;
        }

        if (txtTipoIDEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo ID");
            txtTipoIDEdit.requestFocus();
            return;
        }

        if (txtIDEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID");
            txtIDEdit.requestFocus();
            return;
        }

        if (txtNombresEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre");
            txtNombresEdit.requestFocus();
            return;
        }

        if (txtApellidosEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el apellido");
            txtApellidosEdit.requestFocus();
            return;
        }

        if (txtEstadoCivilEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado civil");
            txtEstadoCivilEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la direccion");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtTelefonoEdit.requestFocus();
            return;
        }

        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        if (txtGrupoFamiliarEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el grupo familiar");
            txtGrupoFamiliarEdit.requestFocus();
            return;
        }

        if (txtInformacionAcademicaEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la informacion academica");
            txtInformacionAcademicaEdit.requestFocus();
            return;
        }

        RH funcionario = new RH();
        funcionario.setTipo_identificacion_id(Integer.parseInt(txtTipoIDEdit.getText().trim()));
        funcionario.setNumero_identificacion(txtIDEdit.getText().trim());
        funcionario.setNombres(txtNombresEdit.getText().trim());
        funcionario.setApellidos(txtApellidosEdit.getText().trim());
        funcionario.setEstado_civil_id(Integer.parseInt(txtEstadoCivilEdit.getText().trim()));
        funcionario.setSexo(txtSexoEdit.getText().trim());
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setTelefono(txtTelefonoEdit.getText().trim());
        String fechaNacimientoText = txtFechaNacimientoEdit.getText().trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date fechaNacimientoUtil = dateFormat.parse(fechaNacimientoText);
            java.sql.Date fechaNacimientoSql = new java.sql.Date(fechaNacimientoUtil.getTime());
            funcionario.setFecha_de_nacimiento(fechaNacimientoSql);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        funcionario.setGrupo_familiar_id(Integer.parseInt(txtGrupoFamiliarEdit.getText().trim()));
        funcionario.setInformacion_academica_id(Integer.parseInt(txtInformacionAcademicaEdit.getText().trim()));

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {
                funcionarioRHController.actualizarFuncionario(Integer.parseInt(txtFuncionarioID.getText()), funcionario);
                txtFuncionarioID.setText("");
                txtTipoIDEdit.setText("");
                txtIDEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                txtGrupoFamiliarEdit.setText("");
                txtInformacionAcademicaEdit.setText("");
                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Se ha actualizado el funcionario con éxito!");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el funcionario!");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<RH> cbxFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPRH;
    private javax.swing.JPanel jPRH1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstCivil;
    private javax.swing.JLabel lblEstadoCivilEdit;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaNacimientoEdit;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblGrupoFamiliar;
    private javax.swing.JLabel lblGrupoFamiliarEdit;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInformacionAcademica;
    private javax.swing.JLabel lblInformacionAcademicaEdit;
    private javax.swing.JLabel lblNoID;
    private javax.swing.JLabel lblNoIDEdit;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNombresEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipID;
    private javax.swing.JLabel lblTipIDEdit;
    private javax.swing.JTable tblRH;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtEstadoCivilEdit;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEdit;
    private javax.swing.JTextField txtFuncionarioID;
    private javax.swing.JTextField txtGrupoFamiliar;
    private javax.swing.JTextField txtGrupoFamiliarEdit;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDEdit;
    private javax.swing.JTextField txtInformacionAcademica;
    private javax.swing.JTextField txtInformacionAcademicaEdit;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombresEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipoID;
    private javax.swing.JTextField txtTipoIDEdit;
    // End of variables declaration//GEN-END:variables
}
