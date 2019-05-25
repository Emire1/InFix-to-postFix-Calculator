package expression;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;

/**
* This a GUI program that converts an infix to postfix
* and return the value of the input.
* 
* @author (T.M. Rao), Emmanuel Mireku. 
* 
*/

public class infixGUI extends Application
{
    //Declare GUI components.
	public final double USE_PREF_SIZE = 400;
	GridPane pane;
	Scene scene;
	Button calculateButton;
	Button exit;
	TextField infixExpressionTF;
	TextField postfixExpressionTF;
	TextField valueOfExpressionTF;
	Label expressionL;
	Label valueOfExpressionL;
	Label postfixExpressionL;
	
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void createGUIComponents()
    {
       //Instantiate GUI Components and build GUI
    	
    	expressionL = new Label("Enter infix Expression");
    	infixExpressionTF = new TextField();
    	postfixExpressionL = new Label("Infix to Postfix");
    	postfixExpressionTF = new TextField();
    	valueOfExpressionL = new Label("Value of Expression");
    	valueOfExpressionTF = new TextField();
    	calculateButton = new Button("Calculate");
    	exit = new Button("Exit");
    	
    	
    	pane = new GridPane();
    	pane.add(expressionL, 0, 0);
    	pane.add(infixExpressionTF, 1, 0);
    	pane.add(postfixExpressionL, 0, 1);
    	pane.add(postfixExpressionTF, 1, 1);
    	pane.add(valueOfExpressionL, 0, 2);
    	pane.add(valueOfExpressionTF, 1, 2);
    	pane.add(calculateButton, 0, 3);
    	pane.add(exit, 1, 3);
    	
    	
    	postfixExpressionTF.setEditable(false);
    	valueOfExpressionTF.setEditable(false);
    	
    	pane.setHgap(10);
    	pane.setVgap(10);
    	pane.setPadding(new Insets(10));
    	
    	infixExpressionTF.setPrefWidth(USE_PREF_SIZE);
    	postfixExpressionTF.setPrefWidth(USE_PREF_SIZE);
    	valueOfExpressionTF.setPrefWidth(USE_PREF_SIZE);
    	
        
    }
    public void attachHandlers()
    {
        calculateButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
            	try {
					ExpressionEvaluator expressionEval = new ExpressionEvaluator();
					String input = "";
					String post = "";
					input = infixExpressionTF.getText();
					Expression expression = new Expression(input);
					InfixToPostfixConverter i = new InfixToPostfixConverter(expression);
					i.convertToPostfix();
					post = i.getPostfix().toString();
					valueOfExpressionTF.setText(String.format("%s ", expressionEval.evaluate(expression)));
					postfixExpressionTF.setText(String.format("%s", post));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
            }
            
        });
        
        exit.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
            	Platform.exit();
            }
            
        });
    }
    
    public void start(Stage stage) {
        createGUIComponents();
        attachHandlers();

        scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Infix Calculator");
        stage.setWidth(500);
        stage.setHeight(190);
        stage.show();
    }
}
