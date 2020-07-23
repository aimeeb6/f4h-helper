import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.awt.datatransfer.StringSelection;


public class Controller {
    private Model model;
    private Interface mainGui;
    
    public Controller(Model m, Interface i){
        model = m;
        mainGui = i;

    }

    public void initApp(){
        mainGui.getPasteButton().addActionListener(e ->  pasteAction());
    }

    public void pasteAction() {
        System.out.println("test");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
        try {
            mainGui.setPasteArea((String) clipboard.getData(flavor));
            model.setFieldName((String) clipboard.getData(flavor));
        } catch (UnsupportedFlavorException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
    
}