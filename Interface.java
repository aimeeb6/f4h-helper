import java.awt.*;
import javax.swing.*;

public class Interface extends JFrame  {

    private static final long serialVersionUID = 1L;
    public JPanel controlPanel = new JPanel();
    public JPanel selectPanel = new JPanel();
    public JTabbedPane tabbedPane;
    private JTextArea selectPasteArea;
    private JButton selectPasteButton;
    private JTextArea selectCopyArea;
    private JButton selectCopyButton;
    private JTextArea pasteArea;
    private JButton pasteButton;
    private JTextArea copyArea;
    private JButton copyButton; 
    private JButton convertButton = new JButton("Convert");
    private JLabel charCounterLabel = new JLabel("The control name character count is ", SwingConstants.CENTER);


    public void createFrame(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300, 150);
      setTitle("Swing Counter");
      setVisible(true);    // show i
    }

    public JButton getPasteButton() {
        return pasteButton;
    }

    public void setPasteArea(String pasteText) {
        this.pasteArea.setText(pasteText);
    }

    public JTextArea getPasteArea() {
        return this.pasteArea;
    }

    public JButton getCopyButton() {
        return copyButton;
    }
    
    public void setCopyArea(String copyText) {
        this.copyArea.setText(copyText);
    }

    public String getCopyArea() {
        return this.copyArea.getText();
    }

    public JButton getConvertButton(){
        return convertButton;
    }

    public void setCounterLabel(String text){
        this.charCounterLabel.setText("The control name character count is " + text);
    }

    public JButton getSelectPasteButton(){
        return selectPasteButton;
    }
    public void setSelectPasteArea(String pasteText) {
        this.selectPasteArea.setText(pasteText);
    }
    
    public JButton getSelectCopyButton() {
        return selectCopyButton;
    }
    
    public void setSelectCopyArea(String copyText) {
        this.selectCopyArea.setText(copyText);
    }

    public String getSelectCopyArea() {
        return this.selectCopyArea.getText();
    }
    
    public JTextArea getSelectPasteArea() {
        return this.selectPasteArea;
    }

    

    public void controlNameTab(){
        pasteArea = new JTextArea();
        pasteButton = new JButton("Paste");
        JScrollPane pasteAreaScroll = new JScrollPane(pasteArea);

        copyArea = new JTextArea();
        copyButton = new JButton("Copy");
        JScrollPane copyAreaScroll = new JScrollPane(copyArea);

        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 40;
        c.ipadx = 170;
        controlPanel.add(pasteAreaScroll, c);

        c.gridx = 2;
        c.gridy = 0;
        c.ipady = 20;
        c.ipadx = 0;
        c.insets = new Insets(10,10,10,10);
        controlPanel.add(pasteButton, c);

        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 40;
        c.ipadx = 170;
        c.insets = new Insets(0,0,0,0);
        controlPanel.add(copyAreaScroll, c);

        c.gridx = 2;
        c.gridy = 1;
        c.ipady = 20;
        c.ipadx = 0;
        c.insets = new Insets(10,10,10,10);
        controlPanel.add(copyButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;      //make this component tall
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 3;
        controlPanel.add(charCounterLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 4;
        controlPanel.add(convertButton, c);

    }

    public void selectTab(){
        selectPasteArea = new JTextArea();
        selectPasteButton = new JButton("Paste");
        JScrollPane selectPasteAreaScroll = new JScrollPane(selectPasteArea);

        selectCopyArea = new JTextArea();
        selectCopyButton = new JButton("Copy");
        JScrollPane selectCopyAreaScroll = new JScrollPane(selectCopyArea);

        selectPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        c.ipadx = 200;
        selectPanel.add(selectPasteAreaScroll, c);

        c.gridx = 2;
        c.gridy = 0;
        c.ipady = 20;
        c.ipadx = 0;
        c.insets = new Insets(10,10,10,10);
        selectPanel.add(selectPasteButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 40;
        c.ipadx = 200;
        c.insets = new Insets(0,0,0,0);
        selectPanel.add(selectCopyAreaScroll, c);

        c.gridx = 2;
        c.gridy = 1;
        c.ipady = 20;
        c.ipadx = 0;
        c.insets = new Insets(10,10,10,10);
        selectPanel.add(selectCopyButton, c);
    }

    public void createTabbedPane(){
        tabbedPane = new JTabbedPane();  
        controlNameTab();
        selectTab();
        tabbedPane.add("Control Name",controlPanel);
        tabbedPane.add("Select Panel",selectPanel); 
    }

    public Interface(){
        createTabbedPane();
        JFrame frame = new JFrame("Form Builder");
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(300, 290);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.toFront();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}