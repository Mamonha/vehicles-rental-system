package ViewSwing.modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModalLocarVeiculo extends JDialog {

    private boolean confirmado;

    public ModalLocarVeiculo(JFrame parent) {
        super(parent, "Confirmar Locação", true);
        setSize(300, 150);
        setLocationRelativeTo(parent); // Centraliza a modal em relação ao JFrame pai

        double total = 150.0;
        JLabel mensagemLabel2 = new JLabel("Total de R$ " + total);
        JLabel mensagemLabel = new JLabel("Deseja confirmar a locação?");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usando BoxLayout para organizar os componentes verticalmente
        mensagemLabel2.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o JLabel
        mensagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o JLabel

        panel.add(mensagemLabel2);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre as mensagens
        panel.add(mensagemLabel);

        JPanel botoesPanel = new JPanel(new FlowLayout());

        JButton simButton = new JButton("Sim");
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                setVisible(false);
            }
        });
        botoesPanel.add(simButton);

        JButton naoButton = new JButton("Não");
        naoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                setVisible(false);
            }
        });
        botoesPanel.add(naoButton);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre as mensagens e os botões
        panel.add(botoesPanel);

        getContentPane().add(panel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public static void main(String[] args) {
        // Exemplo de uso do modal
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);

        ModalLocarVeiculo modal = new ModalLocarVeiculo(frame);
        modal.setVisible(true);

        if (modal.isConfirmado()) {
            System.out.println("Locação confirmada.");
        } else {
            System.out.println("Locação cancelada.");
        }
    }
}
