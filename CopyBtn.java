import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class CopyBtn extends JComponent {

    private static final long serialVersionUID = 1L;

    public CopyBtn(JTextArea copyArea) {

        JButton copyBtn = new JButton("Copy");

           copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(copyArea.getText());
                clipboard.setContents(stringSelection, null);

            }
            });
    }

}    




