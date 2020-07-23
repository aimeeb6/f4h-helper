import java.awt.*;
import javax.swing.*;

public class javaApp extends JFrame  {

    private static final long serialVersionUID = 1L;
    public JTabbedPane tabbedPane;
    public JPanel controlPanel = new JPanel();
    public JPanel selectPanel = new JPanel();
    public JTextArea pasteArea;
    public JTextArea pasteArea;
    public Controller controller =  new Controller();


    public void createFrame(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
      setTitle("Swing Counter");
      setVisible(true);    // show i
    }

    public void createTabbedPane(){
        tabbedPane = new JTabbedPane();  
        controlNameTab();
        tabbedPane.add("Control Name",controlPanel);
        tabbedPane.add("Select Panel",selectPanel); 
    }

    public void controlNameTab(){
        pasteArea = new JTextArea("            ");
        JButton pasteBtn = new JButton("Paste");
        pasteBtn.addActionListener(e ->  controller.pasteAction());

        
        JTextArea copyArea = new JTextArea("              ");
        JButton copyBtn = new JButton("Copy");
        pasteBtn.addActionListener(e ->  controller.copyAction());
    
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(pasteArea);
        controlPanel.add(pasteBtn);
        controlPanel.add(copyArea);
        controlPanel.add(copyBtn);

        
    }

    public javaApp(){
        createTabbedPane();
        JFrame frame = new JFrame("Form Builder");
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new javaApp();
    }
}