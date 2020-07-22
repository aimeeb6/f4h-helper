import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class javaApp extends JFrame {

    private static final long serialVersionUID = 1L;
    public JTabbedPane tabbedPane;
    public JPanel controlPanel = new JPanel();
    public JPanel selectPanel = new JPanel();

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
        JTextArea pasteArea = new JTextArea("            ");
        JButton pasteBtn = new JButton("Paste");

        pasteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                DataFlavor flavor = DataFlavor.stringFlavor;
                if (clipboard.isDataFlavorAvailable(flavor)) {
                try {
                    pasteArea.setText( (String) clipboard.getData(flavor));
                } catch (UnsupportedFlavorException e) {
                    System.out.println(e);
                } catch (IOException e) {
                    System.out.println(e);
                }
                }
            }
            });
        
        JTextArea copyArea = new JTextArea("              ");
        JButton copyBtn = new JButton("Copy");
        copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(copyArea.getText());
                clipboard.setContents(stringSelection, null);
             

            }
            });

    
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