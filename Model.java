
public class Model {
    private String fieldName;
    private String controlName;
    
    public void setFieldName(String inputText){
        fieldName = inputText;
        createControlName();

    }

    public void createControlName(){
        this.controlName = fieldName.replaceAll("[^a-z0-9]","");
        this.controlName = controlName.replace(' ', '-');
    }

    public String getControlName(){
        return controlName;
    }

    
}
