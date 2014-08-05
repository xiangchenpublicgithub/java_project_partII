package calculator;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.bind.Unmarshaller.Listener;

import utilities.Utilities;
/**
 * You will likely import more than a few Swing and other libraries above.
 * @author CS Department, UMD
 *
 */
public class InterestTableGUI extends JPanel {
    
    JLabel label1, label2, label3;
    JTextField text1, text2;
    JTextArea outPut;
    JButton button1, button2, button3;
    JSlider years;
    
    
    public InterestTableGUI(){        
        label1 = new JLabel("Principal: ");
        label2 = new JLabel("Rate(Percentage): ");
        label3 = new JLabel("Number of Years: ");
        
        text1 = new JTextField("", 10);
        text2 = new JTextField("", 5);
        outPut = new JTextArea(13, 31);
        outPut.setWrapStyleWord(true);
        outPut.setLineWrap(true);
        outPut.setEditable(false);
        JScrollPane scroll = new JScrollPane(outPut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        button1 = new JButton("SimpleInterest");
        button2 = new JButton("CompoundInterest");
        button3 = new JButton("BothInterest");
        
        
        
        ListenForButton1 listen1 = new ListenForButton1();
        ListenForButton2 listen2 = new ListenForButton2();
        ActionListener listen3 = new ActionListener() {
            double p, r;
            int y;
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == button3){
                    try{
                        p = Double.parseDouble(text1.getText());
                        r = Double.parseDouble(text2.getText());
                        y = years.getValue();
                    }catch(NumberFormatException ex){
                    }
                    outPut.setText(Utilities.bothInterestsTable(p, r, y));
                    
                }
            }
        }
        ;

        button1.addActionListener(listen1);
        button2.addActionListener(listen2);
        button3.addActionListener(listen3);

        years = new JSlider(1, 25, 1);
        years.setMinorTickSpacing(1);
        years.setMajorTickSpacing(4);
        years.setPaintTicks(true);
        years.setPaintLabels(true);
        
        this.add(scroll);
        this.add(label1);
        this.add(text1);
        this.add(label2);
        this.add(text2);
        
        
        
        
        this.add(label3);
        this.add(years);    
        
        
        this.add(button1);
        this.add(button2);
        this.add(button3);


    }
    
    private class ListenForButton1 implements ActionListener{
        double p, r;
        int y;
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == button1){
                try{
                    p = Double.parseDouble(text1.getText());
                    r = Double.parseDouble(text2.getText());
                    y = years.getValue();
                }catch(NumberFormatException ex){
                }
                outPut.setText(Utilities.simpleInterestTable(p, r, y));
            }
        }
    }
    private class ListenForButton2 implements ActionListener{
        double p, r;
        int y;
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == button2){
                try{
                    p = Double.parseDouble(text1.getText());
                    r = Double.parseDouble(text2.getText());
                    y = years.getValue();
                }catch(NumberFormatException ex){
                }
                outPut.setText(Utilities.compoundInterestTable(p, r, y));
                
            }
        }
    }  
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("InterestTable Calculator");
        f.add(new InterestTableGUI());
        f.setVisible(true);

    }
}
