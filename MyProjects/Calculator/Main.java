package MyProjects.Calculator;

public class Main {
    public static void main(String[] args) {
         CalculatorModel cModel=new CalculatorModel();
        CalculatorView cView=new CalculatorView("Calculator", 400, 400);
        CalculatorController controller=new CalculatorController(cModel, cView);
    }
}
