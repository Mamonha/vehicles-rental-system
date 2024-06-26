package ViewSwing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(5, 102, 44));
        jPanel4.setLayout(new BorderLayout());

        jPanel3.setBackground(new java.awt.Color(48, 191, 88));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image 1.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(125, 223, 32));
        jButton1.setText("Locadoras");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setBackground(new java.awt.Color(125, 223, 32));
        jButton2.setText("Clientes");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton3.setBackground(new java.awt.Color(125, 223, 32));
        jButton3.setText("Veículos");
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

        jButton5.setBackground(new java.awt.Color(125, 223, 32));
        jButton5.setText("Locações");
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));

        jButton6.setBackground(new java.awt.Color(125, 223, 32));
        jButton6.setText("Sair");
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)
                                .addContainerGap(54, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(81, 81, 81)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        // Creating datasets for each chart
        DefaultCategoryDataset locacoesDataset = new DefaultCategoryDataset();
        locacoesDataset.addValue(5, "Locações", "Jan");
        locacoesDataset.addValue(7, "Locações", "Feb");
        locacoesDataset.addValue(6, "Locações", "Mar");

        DefaultCategoryDataset clientesDataset = new DefaultCategoryDataset();
        clientesDataset.addValue(4, "Clientes", "Jan");
        clientesDataset.addValue(6, "Clientes", "Feb");
        clientesDataset.addValue(8, "Clientes", "Mar");

        DefaultPieDataset vehiclesDataset = new DefaultPieDataset();
        vehiclesDataset.setValue("Carros", 50);
        vehiclesDataset.setValue("Motos", 20);
        vehiclesDataset.setValue("Caminhões", 30);

        DefaultCategoryDataset areaDataset = new DefaultCategoryDataset();
        areaDataset.addValue(1, "Locações Cumulativas", "Jan");
        areaDataset.addValue(3, "Locações Cumulativas", "Feb");
        areaDataset.addValue(6, "Locações Cumulativas", "Mar");

        // Creating the charts
        JFreeChart locacoesChart = ChartFactory.createBarChart("Quantidade de Locações por Mês", "Mês", "Quantidade", locacoesDataset, PlotOrientation.VERTICAL, true, true, false);
        JFreeChart clientesChart = ChartFactory.createLineChart("Quantidade de Clientes por Mês", "Mês", "Quantidade", clientesDataset, PlotOrientation.VERTICAL, true, true, false);
        JFreeChart vehiclesChart = ChartFactory.createPieChart("Distribuição de Veículos", vehiclesDataset, true, true, false);
        JFreeChart areaChart = ChartFactory.createAreaChart("Evolução Cumulativa de Locações", "Mês", "Quantidade", areaDataset, PlotOrientation.VERTICAL, true, true, false);

        // Creating chart panels
        ChartPanel locacoesChartPanel = new ChartPanel(locacoesChart);
        locacoesChartPanel.setPreferredSize(new java.awt.Dimension(280, 200));

        ChartPanel clientesChartPanel = new ChartPanel(clientesChart);
        clientesChartPanel.setPreferredSize(new java.awt.Dimension(280, 200));

        ChartPanel vehiclesChartPanel = new ChartPanel(vehiclesChart);
        vehiclesChartPanel.setPreferredSize(new java.awt.Dimension(280, 200));

        ChartPanel areaChartPanel = new ChartPanel(areaChart);
        areaChartPanel.setPreferredSize(new java.awt.Dimension(280, 200));

        // Creating a panel to hold all charts
        JPanel chartsPanel = new JPanel();
        chartsPanel.setLayout(new GridLayout(2, 2));
        chartsPanel.add(locacoesChartPanel);
        chartsPanel.add(clientesChartPanel);
        chartsPanel.add(vehiclesChartPanel);
        chartsPanel.add(areaChartPanel);

        // Adding side panel and charts panel to main panel
        jPanel4.add(jPanel3, BorderLayout.WEST);
        jPanel4.add(chartsPanel, BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LocadoraFrame frame = new LocadoraFrame();
        frame.setVisible(true);
        dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        ClienteFrame frame = new ClienteFrame();
        frame.setVisible(true);
        dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        VeiculoFrame frame = new VeiculoFrame();
        frame.setVisible(true);
        dispose();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        LocacaoFrame frame = new LocacaoFrame();
        frame.setVisible(true);
        dispose();
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    }