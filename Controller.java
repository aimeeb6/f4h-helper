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
        mainGui.getSelectPasteButton().addActionListener(e -> selectPasteAction());
    }

    public void pasteAction() {
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
    public void selectPasteAction(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
        try {
            mainGui.setSelectPasteArea((String) clipboard.getData(flavor));
            setSelectCopyArea();
            model.splitSelectList();
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
        mainGui.setCounterLabel(model.getControlNameLength());
    }

    public void setSelectCopyArea(){
        model.setSelectName(mainGui.getSelectPasteArea().getText());
        mainGui.setSelectCopyArea(model.getSelectCodeString());
        mainGui.setCounterLabel(model.getControlNameLength());
    }

    public void copyAction(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(mainGui.getCopyArea());
        clipboard.setContents(stringSelection, null);

    }
}

