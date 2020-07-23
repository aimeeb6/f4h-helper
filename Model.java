
public class Model {
    private String fieldName;
    private String controlName;
    private String controlNameLength;
    
    public void setFieldName(String inputText){
        fieldName = inputText;
        createControlName();
    }

    public void createControlName(){
        this.controlName = fieldName.replaceAll("[^a-z0-9]","");
        this.controlName = this.controlName.replace(' ', '-');
    }

    public setControlNameLenght(){
        int len = controlName.length();
        this.controlNameLength = controlName + Integer.toString(len);
    }

    public String getControlName(){
        return controlName;
    }

    
}
