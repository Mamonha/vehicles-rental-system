package ViewSwing.modal;

import ViewSwing.ClienteFrame;
import controllers.ClienteController;
import controllers.LocadoraController;
import controllers.VeiculoController;
import models.entities.LocadoraEntity;
import models.entities.VeiculoEntity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ModalEditarVeiculo extends JDialog {

    public javax.swing.JTable TabelaGerenciarVeiculos;
    private JTextField modeloTextField;
    private JTextField placaTextField;
    private JTextField quilometragemTextField;
    private JTextField custoTextField;
    private JTextField anoTextField;
    private JComboBox<String> locadoraComboBox;
    private JCheckBox disponivelCheckBox;
    private LocadoraController locadoraController = new LocadoraController();
    private ClienteController clienteController = new ClienteController();
    private VeiculoController veiculoController = new VeiculoController();

    public ModalEditarVeiculo(JFrame parent, Long idSelected) {
        super(parent, "Editar Veículo", true); // true indica que é uma janela modal

        // Configurações da modal
        setSize(450, 400); // Ajuste o tamanho conforme necessário
        setLocationRelativeTo(parent); // Centraliza a modal em relação ao JFrame pai

        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e TextField para Modelo
        JLabel labelModelo = new JLabel("Modelo:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelModelo, constraints);

        modeloTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(modeloTextField, constraints);

        // Label e TextField para Placa
        JLabel labelPlaca = new JLabel("Placa:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelPlaca, constraints);

        placaTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(placaTextField, constraints);

        // Label e TextField para Quilometragem
        JLabel labelQuilometragem = new JLabel("Quilometragem:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelQuilometragem, constraints);

        quilometragemTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(quilometragemTextField, constraints);

        // Label e TextField para Custo por Dia
        JLabel labelCusto = new JLabel("Custo por dia:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelCusto, constraints);

        custoTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(custoTextField, constraints);

        // Label e TextField para Ano
        JLabel labelAno = new JLabel("Ano do veículo:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(labelAno, constraints);

        anoTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(anoTextField, constraints);

        // Label e JComboBox para Locadora
        JLabel labelLocadora = new JLabel("Locadora:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(labelLocadora, constraints);

        List<LocadoraEntity> locadoras = locadoraController.index();
        DefaultComboBoxModel<String> locadoraModel = new DefaultComboBoxModel<>();

        for (LocadoraEntity locadora : locadoras) {
            locadoraModel.addElement(locadora.getNome());
        }

        locadoraComboBox = new JComboBox<>(locadoraModel);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(locadoraComboBox, constraints);

        // Checkbox para Disponibilidade
        JLabel labelDisponivel = new JLabel("Disponível:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(labelDisponivel, constraints);

        disponivelCheckBox = new JCheckBox();
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(disponivelCheckBox, constraints);

        // Botão Salvar
        JButton salvarButton = new JButton("Salvar");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(salvarButton, constraints);

        getContentPane().add(panel);

        salvarButton.addActionListener(e -> {
            try {
                String modelo = modeloTextField.getText();
                String placa = placaTextField.getText();
                int quilometragem = Integer.parseInt(quilometragemTextField.getText());
                float custoPorDia = Float.parseFloat(custoTextField.getText());
                int ano = Integer.parseInt(anoTextField.getText());
                String locadoraSelecionada = (String) locadoraComboBox.getSelectedItem();
                LocadoraEntity locadoraQuery = locadoraController.findByName(locadoraSelecionada);
                boolean disponivel = disponivelCheckBox.isSelected();

                VeiculoEntity veiculoUpdated = new VeiculoEntity();
                veiculoUpdated.setModelo(modelo);
                veiculoUpdated.setPlaca(placa);
                veiculoUpdated.setQuilometragem(quilometragem);
                veiculoUpdated.setCustoPorDia(custoPorDia);
                veiculoUpdated.setAno(ano);
                veiculoUpdated.setLocadora(locadoraQuery);
                veiculoUpdated.setDisponivel(disponivel);
                veiculoUpdated.setId(idSelected);

                veiculoController.update(veiculoUpdated);

                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
