
public class Model {
    private String fieldName;
    private String controlName;
    private String controlNameLength;
    
    public void setFieldName(String inputText){
        fieldName = inputText;
        createControlName();
    }

    public void createControlName(){
        this.controlName = fieldName.toLowerCase();
        this.controlName = controlName.replaceAll("[^a-z0-9]/","");
        this.controlName = controlName.replace(' ', '-');
        setControlNameLength();
    }

    public void setControlNameLength(){
        int len = controlName.length();
        this.controlNameLength = Integer.toString(len);
    }

    public String getControlNameLength(){
       return this.controlNameLength;
    }

    public String getControlName(){
        return controlName;
    }

    
}
