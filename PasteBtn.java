import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PasteBtn extends JButton {

    private static final long serialVersionUID = 1L;

    public PasteBtn(JTextArea pasteArea) {

        JButton PasteBtn = new JButton("Copy");

        PasteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                String pasteText = new DefaultEditorKit.PasteAction().toString();

                if(pasteText != null){
                    pasteArea.setText(pasteText);
                }
            }
            });
    }

}    




