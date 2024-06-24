package ViewSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModalRemoverCliente extends JDialog {

    private boolean confirmado;

    public ModalRemoverCliente(JFrame parent) {
        super(parent, "Confirmar Exclusão", true); // true indica que é uma janela modal
        setSize(300, 150);
        setLocationRelativeTo(parent); // Centraliza a modal em relação ao JFrame pai

        JPanel panel = new JPanel(new BorderLayout());

        JLabel mensagemLabel = new JLabel("Deseja realmente deletar este usuário?");
        panel.add(mensagemLabel, BorderLayout.CENTER);

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

        panel.add(botoesPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

}