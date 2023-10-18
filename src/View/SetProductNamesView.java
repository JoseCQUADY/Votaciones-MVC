package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetProductNamesView {
    private JFrame frame;
    private JLabel[] productLabels;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton saveButton;
    
    public SetProductNamesView(){
        
        frame = new JFrame("Votación de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productLabels = new JLabel[3];
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
 
        saveButton = new JButton("Guardar");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            productLabels[i] = new JLabel("Nombre:");
            
            panel.add(productLabels[i]);   
            
        }
        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(saveButton);
        frame.add(panel);
        frame.pack();
        
    }
    public void saveNamesButtonListener(ActionListener listener){
            saveButton.addActionListener(listener);
    }

        public JFrame getFrame() {
            return frame;
        }

        public JTextField getTextField1() {
        return textField1;
        }

        public JTextField getTextField2() {
            return textField2;
        }

        public JTextField getTextField3() {
            return textField3;
        }
    }