
public class mainApp {

    public static void main(String args[]){
        Interface gui = new Interface();
        Model model = new Model();
        Controller control = new Controller(model, gui);
        control.initApp();
    }
}