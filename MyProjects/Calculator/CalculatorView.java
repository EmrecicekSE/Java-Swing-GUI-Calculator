package MyProjects.Calculator;

import java.awt.Font;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{



    private  JButton plusButton,minesButton,multipleButton,divideButton,zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,clearButton,dotButton,equalsButton,backButton;
    private  JPanel panel;
    private JTextField textField;
    private  JButton[] buttons;


    CalculatorView(String title,int width,int height){
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        createButtons();
        addButtonsToArray();
        setupLayout();
        setVisible(true);
    }

    void createPanel(){
        panel=new JPanel();
        
    }    
    void createButtons(){
        plusButton=createButton("+");
        minesButton=createButton("-");
        multipleButton=createButton("X");
        divideButton=createButton("/");
        zeroButton=createButton("0");
        oneButton=createButton("1");
        twoButton=createButton("2");
        threeButton=createButton("3");
        fourButton=createButton("4");
        fiveButton=createButton("5");
        sixButton=createButton("6");
        sevenButton=createButton("7");
        eightButton=createButton("8");
        nineButton=createButton("9");
        clearButton=createButton("C");
        dotButton=createButton(".");
        equalsButton=createButton("=");
        backButton=createButton("<-");
        buttons=new JButton[18];
        textField=new JTextField();
    }

    void addButtonsToArray(){
        buttons[0]=sevenButton;
        buttons[1]=eightButton;
        buttons[2]=nineButton;

        buttons[3]=fourButton;
        buttons[4]=fiveButton;
        buttons[5]=sixButton;

        buttons[6]=oneButton;
        buttons[7]=twoButton;
        buttons[8]=threeButton;

        buttons[9]=zeroButton;
        buttons[10]=plusButton;
        buttons[11]=minesButton;

        buttons[12]=multipleButton;
        buttons[13]=divideButton;
        buttons[14]=dotButton;
        
        buttons[15]=backButton;
        buttons[16]=clearButton;
        buttons[17]=equalsButton;


    }

    JButton createButton(String sign){
        JButton btn=new JButton(sign);
        btn.setFont(new Font("Courier New", Font.BOLD, 22));    
        

        btn.setOpaque(true);
        btn.setBorderPainted(false);
        return btn;
    }

    void setupLayout(){
        this.setLayout(new BorderLayout());
        colorOfPanel(Color.LIGHT_GRAY);


        textField.setEditable(false);
        textField.setMargin(new Insets(5, 5, 5, 5));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setPreferredSize(new Dimension(90, 70));
        textField.setFont(new Font("Arial", Font.BOLD, 28));


        panel.setLayout(new GridLayout(6,3,10,10));
        

       
    colorOfPanel(new Color(0,0,0));


    colorOfNumberButtons(new Color(20,30,60), Color.WHITE);


    colorOfOperatorButtons(new Color(25, 70, 100), Color.WHITE);


    colorOfClearButton(new Color(57, 83, 79), Color.WHITE);

    colorOfBackButton(new Color(150, 83, 79), Color.WHITE);

    colorOfEqualButton(new Color(0, 70, 26), Color.WHITE);


      colorOfTextField(new Color(30, 40, 42),Color.WHITE); 
        
        this.addButtonsToPanel();
        this.add(textField,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);

    }

    

    private void addButtonsToPanel(){
        for(int i=0;i<buttons.length;i++){
            panel.add(buttons[i]);
        }
    }

    private void colorOfTextField(Color backGround,Color foreGround){
        textField.setBackground(backGround);
        textField.setForeground(foreGround);
    }

    private void colorOfNumberButtons(Color backGround,Color foreGround){
        for(int i=0;i<10;i++){
            buttons[i].setBackground(backGround);
            buttons[i].setForeground(foreGround);    
            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setOpaque(true);
        }
    }
    private void colorOfOperatorButtons(Color backGround,Color foreGround){
        for(int i=10;i<15;i++){
            buttons[i].setBackground(backGround);
            buttons[i].setForeground(foreGround);    
            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setOpaque(true);
        }
    }
    private void colorOfClearButton(Color backGround,Color foreGround){
            
            clearButton.setBackground(backGround);
            clearButton.setForeground(foreGround);    
            clearButton.setFocusPainted(false);
            clearButton.setBorderPainted(false);
            clearButton.setOpaque(true);
    }

    private void colorOfPanel(Color c){
        panel.setBackground(c);
    }

    private void colorOfBackButton(Color backGround,Color foreGround){
        backButton.setBackground(backGround);
            backButton.setForeground(foreGround);    
            backButton.setFocusPainted(false);
            backButton.setBorderPainted(false);
            backButton.setOpaque(true);
    }

    private void colorOfEqualButton(Color backGround,Color foreGround){
        equalsButton.setBackground(backGround);
            equalsButton.setForeground(foreGround);    
            equalsButton.setFocusPainted(false);
            equalsButton.setBorderPainted(false);
            equalsButton.setOpaque(true);
    }

    public JButton getButtonAt(int index){
        return buttons[index];
    }





    public String getScreenText(){
        return textField.getText();
    }
    public void addScreenText(String text){
        String oldText=textField.getText();
        textField.setText(oldText+text);
    }
    public void setScreenText(String text){
        textField.setText(text);
    }

    public void addCalculatorListener(ActionListener listener) {
    for (int i = 0; i < buttons.length; i++) {
        buttons[i].addActionListener(listener);
    }
}

}
