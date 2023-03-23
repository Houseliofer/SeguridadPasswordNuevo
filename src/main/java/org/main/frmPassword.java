package org.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class frmPassword extends JFrame{
    private JTextField textField1;
    private JButton enviarButton;
    private JButton reiniciarButton;
    private JLabel lblMensaje;
    private JPanel panel;

    public frmPassword(){
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                if(texto.equals(""))
                    JOptionPane.showMessageDialog(null, "Por favor ingresa algo", "Mensaje", JOptionPane.WARNING_MESSAGE);
                else {

                    SeguridadPassword.NivelSeguridad p = SeguridadPassword.assessPassword(texto);

                    enviarButton.setEnabled(false);
                    textField1.setEnabled(false);
                    lblMensaje.setText("Su Contraseña es: " + String.valueOf(p));
                }
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                enviarButton.setEnabled(true);
                textField1.setEnabled(true);
                lblMensaje.setText("");
            }
        });

        textField1.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // Obtener el carácter que se está intentando escribir
                char ch = e.getKeyChar();

                // Comprobar si el carácter es un espacio
                if (ch == ' ') {
                    e.consume(); // Consumir el evento, lo que impide que se escriba el espacio
                }
            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

            }


        });
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        frmPassword panel = new frmPassword();
        panel.setContentPane(new frmPassword().panel);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
        panel.pack();
    }

}
