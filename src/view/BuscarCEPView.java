package view;

import util.ViaCEPUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarCEPView extends JFrame {
    private JTextField txtCep;
    private JTextArea txtResultado;
    private JButton btnBuscar;

    public BuscarCEPView() {
        setTitle("Buscar CEP");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("CEP:"));
        txtCep = new JTextField();
        panel.add(txtCep);
        add(panel, BorderLayout.NORTH);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        btnBuscar = new JButton("Buscar");
        add(btnBuscar, BorderLayout.SOUTH);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String resultado = ViaCEPUtil.buscarEnderecoPorCEP(txtCep.getText());
                    txtResultado.setText(resultado);
                } catch (Exception ex) {
                    txtResultado.setText("Erro: " + ex.getMessage());
                }
            }
        });
    }
}
