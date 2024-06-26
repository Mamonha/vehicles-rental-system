package ViewSwing.modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModalRemoverVeiculo extends JDialog {

    private boolean confirmado;

    public ModalRemoverVeiculo(JFrame parent) {
        super(parent, "Confirmar Exclusão", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel mensagemLabel = new JLabel("Deseja realmente deletar este veiculo?");
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
