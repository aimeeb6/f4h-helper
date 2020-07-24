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
        mainGui.getCopyButton().addActionListener(e ->  copyAction(mainGui.getCopyArea()));
        mainGui.getConvertButton().addActionListener(e -> setCopyArea());
        mainGui.getSelectConvertButton().addActionListener(e -> setSelectCopyArea());
        mainGui.getSelectPasteButton().addActionListener(e -> selectPasteAction());
        mainGui.getSelectCopyButton().addActionListener(e ->  copyAction(mainGui.getSelectCopyArea()));
        mainGui.getBackSlashDelimiter().addItemListener(e -> backSlashStateChanged());
        mainGui.getCommaDelimiter().addItemListener(e -> commaStateChanged());
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
        } catch (UnsupportedFlavorException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

    public void backSlashStateChanged(){
        mainGui.getCommaDelimiter().setSelected(false);
    }

    public void commaStateChanged(){
        mainGui.getBackSlashDelimiter().setSelected(false);
    }

    public void setCopyArea(){
        model.setFieldName(mainGui.getPasteArea().getText());
        mainGui.setCopyArea(model.getControlName());
        mainGui.setCounterLabel(model.getControlNameLength());
        System.out.println(model.getControlName());
    }

    public void setSelectCopyArea(){
        checkDelimiterChanged();
        model.setSelectName(mainGui.getSelectPasteArea().getText());
        model.splitSelectList();
        mainGui.setSelectCopyArea(model.getSelectCodeString());
        mainGui.setCounterLabel(model.getControlNameLength());
    }

    public void checkDelimiterChanged(){
        if(mainGui.getBackSlashDelimiter().isSelected()){
            model.setDelimiter("/");
        }else if(mainGui.getCommaDelimiter().isSelected()){
            model.setDelimiter(",");
        }else{
            model.setDelimiter("\n");
        }

    }

    public void copyAction(String t){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(t);
        clipboard.setContents(stringSelection, null);

    }
}

