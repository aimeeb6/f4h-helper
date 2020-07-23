import java.awt.*;
import javax.swing.*;

public class Interface extends JFrame  {

    private static final long serialVersionUID = 1L;
    public JPanel controlPanel = new JPanel();
    private JTextArea pasteArea;
    private JButton pasteButton;
    private JTextArea copyArea;
    private JButton copyButton; 


    public void createFrame(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
      setTitle("Swing Counter");
      setVisible(true);    // show i
    }

    public JButton getPasteButton() {
        return pasteButton;
       }
    
    public void setPasteArea(String pasteText) {
        this.pasteArea.setText(pasteText);
    }

    public JButton getCopyButton() {
        return copyButton;
       }
    
    public void setCopyArea(String pasteText) {
        this.copyArea.setText(pasteText);
    }

    public void controlNameTab(){
        pasteArea = new JTextArea("            ");
        pasteButton = new JButton("Paste");
        
        copyArea = new JTextArea("            ");
        copyButton = new JButton("Copy");
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(pasteArea);
        controlPanel.add(pasteButton);
        controlPanel.add(copyArea);
        controlPanel.add(copyButton);
    }

    public Interface(){
        controlNameTab();
        JFrame frame = new JFrame("Form Builder");
        frame.add(controlPanel, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}