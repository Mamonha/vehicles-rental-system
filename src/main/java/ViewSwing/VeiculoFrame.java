/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ViewSwing;

import controllers.LocadoraController;
import controllers.VeiculoController;
import models.entities.VeiculoEntity;
import models.entities.LocadoraEntity;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Mamonha
 */
public class VeiculoFrame extends javax.swing.JFrame {
    
    protected VeiculoController veiculoController = new VeiculoController();
    protected LocadoraController locadoraController = new LocadoraController();
    protected VeiculoEntity veiculo = new VeiculoEntity();
    public List<LocadoraEntity> locadoras;
    /**
     * Creates new form VeiculoFrame
     */
    public VeiculoFrame() {
        initComponents();
        
          locadoras = locadoraController.index();
        
          DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            for (LocadoraEntity locadora : locadoras) {
                model.addElement(locadora.getNome());
            }

            LocadoraVeiculo.setModel(model); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        VisualizarVeiculosBtn = new javax.swing.JButton();
        CadastrarVeiculoBtn = new javax.swing.JButton();
        GerenciarVeiculosBtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        CardVeiculoPanel = new javax.swing.JPanel();
        CadVeiculo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ModeloVeiculoField = new javax.swing.JTextField();
        PlacaVeiculoField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        CadastrarVeiculoCad = new javax.swing.JButton();
        LocadoraVeiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DisponivelCheckbox = new javax.swing.JCheckBox();
        QuilometragemField = new javax.swing.JTextField();
        AnoField = new javax.swing.JTextField();
        CustoPorDiaField = new javax.swing.JTextField();
        VisualizarVeiculos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListarClientes = new javax.swing.JTable();
        GerenciarVeiculos = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaGerenciarClientes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Editar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(48, 191, 88));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image 1.png"))); // NOI18N

        VisualizarVeiculosBtn.setBackground(new java.awt.Color(125, 223, 32));
        VisualizarVeiculosBtn.setText("Visualizar Veículo");
        VisualizarVeiculosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarVeiculosBtnActionPerformed(evt);
            }
        });

        CadastrarVeiculoBtn.setBackground(new java.awt.Color(125, 223, 32));
        CadastrarVeiculoBtn.setText("Cadastrar Veículo");
        CadastrarVeiculoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarVeiculoBtnActionPerformed(evt);
            }
        });

        GerenciarVeiculosBtn.setBackground(new java.awt.Color(125, 223, 32));
        GerenciarVeiculosBtn.setText("Gerenciar Veículo");
        GerenciarVeiculosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerenciarVeiculosBtnActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(125, 223, 32));
        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarVeiculoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GerenciarVeiculosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VisualizarVeiculosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(78, 78, 78)
                .addComponent(CadastrarVeiculoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(VisualizarVeiculosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(GerenciarVeiculosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        CardVeiculoPanel.setLayout(new java.awt.CardLayout());

        CadVeiculo.setBackground(new java.awt.Color(5, 102, 44));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cadastrar Veículo");

        ModeloVeiculoField.setBackground(new java.awt.Color(204, 204, 204));
        ModeloVeiculoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeloVeiculoFieldActionPerformed(evt);
            }
        });

        PlacaVeiculoField.setBackground(new java.awt.Color(204, 204, 204));
        PlacaVeiculoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlacaVeiculoFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Modelo do veículo");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        CadastrarVeiculoCad.setText("Cadastrar");
        CadastrarVeiculoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarVeiculoCadActionPerformed(evt);
            }
        });

        LocadoraVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        LocadoraVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocadoraVeiculoActionPerformed(evt);
            }
        });

        jLabel6.setText("Locadora do veículo");

        jLabel7.setText("Placa do veículo");

        jLabel10.setText("Quilometragem");

        jLabel11.setText("Custo por dia");

        jLabel12.setText("Ano");

        DisponivelCheckbox.setText("Veículo disponível?");

        QuilometragemField.setBackground(new java.awt.Color(204, 204, 204));

        AnoField.setBackground(new java.awt.Color(204, 204, 204));
        AnoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnoFieldActionPerformed(evt);
            }
        });

        CustoPorDiaField.setBackground(new java.awt.Color(204, 204, 204));
        CustoPorDiaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustoPorDiaFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CadastrarVeiculoCad)
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel3)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DisponivelCheckbox)
                        .addGap(527, 527, 527))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addComponent(ModeloVeiculoField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(QuilometragemField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AnoField)
                                .addGap(85, 85, 85)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LocadoraVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(66, 66, 66))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PlacaVeiculoField)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustoPorDiaField))
                        .addGap(305, 305, 305))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModeloVeiculoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlacaVeiculoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuilometragemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustoPorDiaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LocadoraVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(DisponivelCheckbox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(CadastrarVeiculoCad))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout CadVeiculoLayout = new javax.swing.GroupLayout(CadVeiculo);
        CadVeiculo.setLayout(CadVeiculoLayout);
        CadVeiculoLayout.setHorizontalGroup(
            CadVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadVeiculoLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        CadVeiculoLayout.setVerticalGroup(
            CadVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadVeiculoLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        CardVeiculoPanel.add(CadVeiculo, "card2");

        VisualizarVeiculos.setBackground(new java.awt.Color(5, 102, 44));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Lista de Clientes");

        ListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(ListarClientes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(341, 341, 341))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VisualizarVeiculosLayout = new javax.swing.GroupLayout(VisualizarVeiculos);
        VisualizarVeiculos.setLayout(VisualizarVeiculosLayout);
        VisualizarVeiculosLayout.setHorizontalGroup(
            VisualizarVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisualizarVeiculosLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        VisualizarVeiculosLayout.setVerticalGroup(
            VisualizarVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisualizarVeiculosLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        CardVeiculoPanel.add(VisualizarVeiculos, "card3");

        GerenciarVeiculos.setBackground(new java.awt.Color(5, 102, 44));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        TabelaGerenciarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TabelaGerenciarClientes);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Gerenciar Veículos");

        Editar.setBackground(new java.awt.Color(125, 223, 32));
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Editar1.setBackground(new java.awt.Color(125, 223, 32));
        Editar1.setText("Remover");
        Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Editar)
                    .addComponent(Editar1))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(341, 341, 341))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Editar1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout GerenciarVeiculosLayout = new javax.swing.GroupLayout(GerenciarVeiculos);
        GerenciarVeiculos.setLayout(GerenciarVeiculosLayout);
        GerenciarVeiculosLayout.setHorizontalGroup(
            GerenciarVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GerenciarVeiculosLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        GerenciarVeiculosLayout.setVerticalGroup(
            GerenciarVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GerenciarVeiculosLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        CardVeiculoPanel.add(GerenciarVeiculos, "card4");

        getContentPane().add(CardVeiculoPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VisualizarVeiculosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarVeiculosBtnActionPerformed
        CardVeiculoPanel.removeAll();
        CardVeiculoPanel.add(VisualizarVeiculos);
        CardVeiculoPanel.repaint();
        CardVeiculoPanel.revalidate();
//
//        List<ClienteEntity> clientes = clienteController.index();;
//
//        // Define o modelo de tabela com as colunas
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID");
//        model.addColumn("Nome");
//        model.addColumn("Telefone");
//        model.addColumn("Email");
//        model.addColumn("Locadora");
//
//        for (ClienteEntity cliente : clientes) {
//            model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail(), cliente.getLocadora().getNome()});
//        }
//        System.out.println(model);
//        ListarClientes.setModel(model);
    }//GEN-LAST:event_VisualizarVeiculosBtnActionPerformed

    private void CadastrarVeiculoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarVeiculoBtnActionPerformed
        CardVeiculoPanel.removeAll();
        CardVeiculoPanel.add(CadVeiculo);
        CardVeiculoPanel.repaint();
        CardVeiculoPanel.validate();
    }//GEN-LAST:event_CadastrarVeiculoBtnActionPerformed

    private void GerenciarVeiculosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerenciarVeiculosBtnActionPerformed
        CardVeiculoPanel.removeAll();
        CardVeiculoPanel.add(GerenciarVeiculos);
        CardVeiculoPanel.repaint();
        CardVeiculoPanel.validate();

    }//GEN-LAST:event_GerenciarVeiculosBtnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ModeloVeiculoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeloVeiculoFieldActionPerformed

    }//GEN-LAST:event_ModeloVeiculoFieldActionPerformed

    private void PlacaVeiculoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlacaVeiculoFieldActionPerformed

    }//GEN-LAST:event_PlacaVeiculoFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CadastrarVeiculoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarVeiculoCadActionPerformed
        LocadoraEntity locadoraSelected = locadoraController.findByName((String)LocadoraVeiculo.getSelectedItem());
        float custoPorDia = Float.parseFloat(CustoPorDiaField.getText());
        int quilometragem = Integer.parseInt(QuilometragemField.getText());
        int ano = Integer.parseInt(AnoField.getText());
        veiculo.setModelo(ModeloVeiculoField.getText());
        veiculo.setPlaca(PlacaVeiculoField.getText());
        veiculo.setQuilometragem(quilometragem);
        veiculo.setLocadora(locadoraSelected);
        veiculo.setDisponivel(DisponivelCheckbox.isSelected());
        veiculo.setCustoPorDia(custoPorDia);
        veiculo.setAno(ano);

        veiculo.setLocadora(locadoraSelected);
        veiculoController.create(veiculo);
        JOptionPane.showMessageDialog(this, "Veiculo cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CadastrarVeiculoCadActionPerformed

    private void LocadoraVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocadoraVeiculoActionPerformed
        List<LocadoraEntity> locadoras = locadoraController.index();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (LocadoraEntity locadora : locadoras) {
            model.addElement(locadora.getNome());
        }

        // Define o modelo no JComboBox apenas uma vez, fora do loop
        LocadoraVeiculo.setModel(model);
    }//GEN-LAST:event_LocadoraVeiculoActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int colunaSelected = TabelaGerenciarClientes.getSelectedRow();

        Object valorColuna = TabelaGerenciarClientes.getValueAt(colunaSelected,1);
        Long idCliente = (long)TabelaGerenciarClientes.getValueAt(colunaSelected,0);
        System.out.println(valorColuna);
        if(valorColuna != null){
//            ModalEditarCliente modal = new ModalEditarCliente(this, idCliente, this);
//            modal.setVisible(true);
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar1ActionPerformed
        int colunaSelected = TabelaGerenciarClientes.getSelectedRow();

        Object valorColuna = TabelaGerenciarClientes.getValueAt(colunaSelected,1);
        Long idCliente = (long)TabelaGerenciarClientes.getValueAt(colunaSelected,0);

        if(valorColuna != null){
            ModalRemoverCliente modalRemover = new ModalRemoverCliente(this);
            modalRemover.setVisible(true);
            if(modalRemover.isConfirmado()){
//                clienteController.delete(clienteController.findById(idCliente));
                JOptionPane.showMessageDialog(this, "Usuário deletado com sucesso!");
                modalRemover.setVisible(false);
                repaint();
            }else{
                modalRemover.setVisible(false);
            }

        }
    }//GEN-LAST:event_Editar1ActionPerformed

    private void AnoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnoFieldActionPerformed

    private void CustoPorDiaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustoPorDiaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustoPorDiaFieldActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VeiculoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoField;
    private javax.swing.JPanel CadVeiculo;
    private javax.swing.JButton CadastrarVeiculoBtn;
    private javax.swing.JButton CadastrarVeiculoCad;
    private javax.swing.JPanel CardVeiculoPanel;
    private javax.swing.JTextField CustoPorDiaField;
    private javax.swing.JCheckBox DisponivelCheckbox;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Editar1;
    private javax.swing.JPanel GerenciarVeiculos;
    private javax.swing.JButton GerenciarVeiculosBtn;
    private javax.swing.JTable ListarClientes;
    private javax.swing.JComboBox<String> LocadoraVeiculo;
    private javax.swing.JTextField ModeloVeiculoField;
    private javax.swing.JTextField PlacaVeiculoField;
    private javax.swing.JTextField QuilometragemField;
    private javax.swing.JTable TabelaGerenciarClientes;
    private javax.swing.JPanel VisualizarVeiculos;
    private javax.swing.JButton VisualizarVeiculosBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
