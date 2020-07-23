
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class PasteBtn extends JButton {


    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    public PasteBtn(JTextArea pasteArea) {

        JButton PasteBtn = new JButton("Copy");

        PasteBtn.addActionListener(new ActionListener() {
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
}
}


    




