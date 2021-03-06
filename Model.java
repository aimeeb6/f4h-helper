import java.util.Arrays;


public class Model {
    private String fieldName;
    private String controlName;
    private String controlNameLength;
    private String selectsList;
    private String splitLine[];
    private String selectCodeString = "  ";
    private String delimiter = "\n";
    
    public void setFieldName(String inputText){
        fieldName = inputText;
        createControlName();
    }
    public void setSelectName(String inputText){
        this.selectsList = "";
        this.selectCodeString = "  ";
        this.selectsList = inputText;
    }

    public String getSelectCodeString(){
        return selectCodeString;
    }
    
    public String selectCode(){
        for(String v : splitLine){
            this.selectCodeString = selectCodeString.concat("<item>\n");
            this.selectCodeString = selectCodeString.concat("\t" +"<label>"+v+"</label>\n");
            this.selectCodeString = selectCodeString.concat("\t"+"<value>"+(v.toLowerCase().replaceAll("[^a-z0-9\\s]","").replace(' ', '-'))+"</value>\n");
            this.selectCodeString = selectCodeString.concat("\t"+"<hint/>\n");
            this.selectCodeString = selectCodeString.concat("</item>\n");
            this.selectCodeString = selectCodeString.concat("\n");
        }
        return this.selectCodeString;
    }

    public void splitSelectList(){
        splitLine = selectsList.split(delimiter);
        selectCode();
    }

    public void setDelimiter(String d){
        this.delimiter = d;

    }

    public String getSelectCode(){
        return selectCodeString;
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
