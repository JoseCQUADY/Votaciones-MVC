package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SetProductNamesView {
    private static final Logger logger = Test.Main.logger;
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
        
        logger.info("Desde SetProductNamesView: SetProductNamesView.");
    }
    public void saveNamesButtonListener(ActionListener listener){
            saveButton.addActionListener(listener);
            logger.info("Desde SetProductNamesView: saveNamesButtonListener.");
    }
    public void closeWindow() {
        frame.dispose();
        logger.info("Desde SetProductNamesView: closeWindow.");
    }

        public JFrame getFrame() {
            logger.info("Desde SetProductNamesView: getFrame.");
            return frame;
            
        }

        public JTextField getTextField1() {
            logger.info("Desde SetProductNamesView: getTextField1.");
        return textField1;
        }

        public JTextField getTextField2() {
            logger.info("Desde SetProductNamesView: getTextField2.");
            return textField2;
        }

        public JTextField getTextField3() {
            logger.info("Desde SetProductNamesView: getTextField3.");
            return textField3;
        }
    }