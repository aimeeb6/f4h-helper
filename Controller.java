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
        mainGui.getCopyButton().addActionListener(e ->  copyAction());
        mainGui.getConvertButton().addActionListener(e -> setCopyArea());
    }

    public void pasteAction() {
        System.out.println("test");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
        try {
            mainGui.setPasteArea((String) clipboard.getData(flavor));
            setCopyArea();
        } catch (UnsupportedFlavorException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

    public void setCopyArea(){
        model.setFieldName(mainGui.getPasteArea().getText());
        mainGui.setCopyArea(model.getControlName());
        System.out.println(model.getControlName());
    }

    public void copyAction(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(mainGui.getCopyArea());
        clipboard.setContents(stringSelection, null);

    }
}

