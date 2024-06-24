package ViewSwing;

import controllers.ClienteController;
import controllers.LocadoraController;
import models.entities.ClienteEntity;
import models.entities.LocadoraEntity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ModalEditarCliente extends JDialog {
    public javax.swing.JTable TabelaGerenciarClientes;
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JTextField telefoneTextField;
    private JComboBox<String> locadoraComboBox;
    private LocadoraController locadoraController = new LocadoraController();
    private ClienteController clienteController = new ClienteController();

    public ModalEditarCliente(JFrame parent, Long idSelected, ClienteFrame clienteFrame) {
        super(parent, "Editar Cliente", true); // true indica que é uma janela modal

        // Configurações da modal
        setSize(450, 300); // Ajuste o tamanho conforme necessário
        setLocationRelativeTo(parent); // Centraliza a modal em relação ao JFrame pai

        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e TextField para Nome
        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNome, constraints);

        nomeTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nomeTextField, constraints);

        // Label e TextField para Email
        JLabel labelEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelEmail, constraints);

        emailTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(emailTextField, constraints);

        // Label e TextField para Telefone
        JLabel labelTelefone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelTelefone, constraints);

        telefoneTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(telefoneTextField, constraints);

        // Label e JComboBox para Locadora
        JLabel labelLocadora = new JLabel("Locadora:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelLocadora, constraints);

        // Carregar as locadoras do banco de dados
        List<LocadoraEntity> locadoras = locadoraController.index();
        DefaultComboBoxModel<String> locadoraModel = new DefaultComboBoxModel<>();

        // Preencher o modelo do JComboBox com os nomes das locadoras
        for (LocadoraEntity locadora : locadoras) {
            locadoraModel.addElement(locadora.getNome());
        }

//        int colunaSelected = ClienteFrame.TabelaGerenciarClientes.getSelectedRow();

//        Object idCliente = TabelaGerenciarClientes.getValueAt(colunaSelected,0);

        // Criar o JComboBox com o modelo preenchido
        locadoraComboBox = new JComboBox<>(locadoraModel);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(locadoraComboBox, constraints);

        // Botão Salvar
        JButton salvarButton = new JButton("Salvar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(salvarButton, constraints);

        getContentPane().add(panel);

        salvarButton.addActionListener(e -> {

            String nome = nomeTextField.getText();
            String email = emailTextField.getText();
            String telefone = telefoneTextField.getText();
            String locadoraSelecionada = (String) locadoraComboBox.getSelectedItem();
            LocadoraEntity locadoraQuery = locadoraController.findByName(locadoraSelecionada);

            ClienteEntity clienteUpdated = new ClienteEntity();

            clienteUpdated.setNome(nome);
            clienteUpdated.setEmail(email);
            clienteUpdated.setTelefone(telefone);
            clienteUpdated.setLocadora(locadoraQuery);
            clienteUpdated.setId(idSelected);

            clienteController.update(clienteUpdated);

            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            dispose();

        });
    }
}
