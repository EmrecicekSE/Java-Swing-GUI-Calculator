package MyProjects.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController implements ActionListener{
    private CalculatorView cView;
    private CalculatorModel cModel;
    private String currentOperator;
    private double firstNumber,secondNumber;
    private boolean isOperatorClicked;
    CalculatorController(CalculatorModel cModel,CalculatorView cView){
        this.cModel=cModel;
        this.cView=cView;
        currentOperator="";
        firstNumber=0;
        isOperatorClicked=false;

        cView.addCalculatorListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Code...
        String lastString=e.getActionCommand(); // "+","-","9" 
        int AsciiCodeOfLastString=getASCIIcode(lastString); //ascii number


        if(isNumber(AsciiCodeOfLastString)){    // NUMBER
            if(isOperatorClicked){
                clearScreen();
                cView.addScreenText(lastString);
                isOperatorClicked=false;
            }
            else{
                cView.addScreenText(lastString);
            }
        }


        if(isOperetor(lastString)){         // "+",-,/,X
        try{
            String st=cView.getScreenText();
            if(lastString.equals("-") && st.isEmpty()){
                cView.setScreenText("-");
            }
            else{
                firstNumber=Double.parseDouble(st);     // firstNumbera kaydedildi
            currentOperator=lastString;
            cView.setScreenText(lastString);
            isOperatorClicked=true;
            }
            
        }
        catch(NumberFormatException ex){
            resetFields();
            cView.setScreenText("NumberFormatException");
            }
        }


        if(isEqual(lastString)){    // =
            String st=cView.getScreenText();
            secondNumber=Double.parseDouble(st);
            try{
                double result=cModel.calculate(firstNumber,secondNumber,currentOperator);
                if(checkDoubleToInt(result)){
                    cView.setScreenText(String.valueOf(DoubleToInt(result)));
                }
                else{
                    cView.setScreenText(String.valueOf(result));    //format
                }
                
                isOperatorClicked = true;

            }
            catch(CalculatorModelException ex){
                resetFields();
                cView.setScreenText("CalculatorModelException");
            }
            catch(ArithmeticException ex){
                resetFields();
                cView.setScreenText("ArithmeticException");
            }
        }


        if(isDot(AsciiCodeOfLastString)){
            if(isOperatorClicked){
                clearScreen();
                cView.setScreenText("0.");
                isOperatorClicked=false;
            }
            else{
                if(!cView.getScreenText().contains(".")){
                    if(!cView.getScreenText().isEmpty()){
                        cView.addScreenText(".");
                    }
                    else{
                        cView.setScreenText("0.");
                    }
                }
            }
        }


        if(isBack(lastString)){         //      <-
            String st=cView.getScreenText();
            if(st.length()>0 && (isNumber(getASCIIcode(st)) || isOperetor(st)||isDot(getASCIIcode(st)))){
                String newScreen=st.substring(0,st.length()-1);
                cView.setScreenText(newScreen);
            }
        }


        if(isClear(lastString)){        // "C"
            resetAll();
        }
    }

    private static boolean checkDoubleToInt(double number){
        String st=String.valueOf(number);
        String[] arr=st.split("\\.");
        if(Double.parseDouble(arr[1])!=0){
            return false;
        }
        return true;
        
    }
    private static int DoubleToInt(double number){
        return (int)number;
    }


    

    private static boolean isBack(String operator){
        return operator.equals("<-");
    }


    private static boolean isClear(String operator){
        return operator.equals("C");
    }

    private static boolean isEqual(String operator){
        return operator.equals("=");
    }

    private static boolean isOperetor(String t){
        return (t.equals("+")||t.equals("-")||t.equals("X")||t.equals("/"));
    }

    private void clearScreen(){
        cView.setScreenText("");
    }
    
    private void resetFields(){
        currentOperator="";
        firstNumber=0;
        isOperatorClicked=false;
    }
    private void resetAll(){
        cView.setScreenText("");
        resetFields();
    }

    private int getASCIIcode(String text){
        char ch=text.charAt(0);
        return (int)ch;
    }

    private boolean isNumber(int ASCII){
        return (ASCII>=48 && ASCII<=57);
    }
    private boolean isDot(int ASCII){
        return (ASCII==46);
    }

    

}