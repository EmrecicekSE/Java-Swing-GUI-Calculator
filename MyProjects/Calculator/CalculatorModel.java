package MyProjects.Calculator;


public class CalculatorModel {


    public double calculate(double num1,double num2,String operator)throws ArithmeticException,CalculatorModelException{
        Double result;
        switch(operator){
            case "+":{result=num1+num2; break;}
            case "-":{result=num1-num2; break;}
            case "X":{result=num1*num2; break;}
            case "/":{
                if(num2==0){
                    throw new ArithmeticException();
                }
                result=num1/num2;
                break;
            }
            default:{
                throw new CalculatorModelException();
            }
        }
        return result;

        
    }
}

