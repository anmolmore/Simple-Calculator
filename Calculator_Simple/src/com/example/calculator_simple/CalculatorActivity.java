package com.example.calculator_simple;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity implements OnClickListener{
	
	/**
	 * symbolFlag - For arithmatic operations chosen
	 * token1 = first Number
	 * token2 = second Number
	 */
	private static boolean symbolFlag = false;
	private static String token1 = "";
	private static String token2 = "";
	private static String operation ="" ;
	private static float token1_float = 0;
	private static float token2_float = 0;
	private static float result = 0;
	private static String textToShow = "";
	
	//initializing all buttons
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_add;
    Button button_bracket;
    Button button_clear;
    Button button_del;
    Button button_divide;
    Button button_dot;
    Button button_equal;
    Button button_multiply;
    Button button_negative;
    Button button_sub;
    EditText resultText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
      //initializing all buttons
        button_0 = (Button)findViewById(R.id.button_0);
        button_1 = (Button)findViewById(R.id.button_1);
        button_2 = (Button)findViewById(R.id.button_2);
        button_3 = (Button)findViewById(R.id.button_3);
        button_4 = (Button)findViewById(R.id.button_4);
        button_5 = (Button)findViewById(R.id.button_5);
        button_6 = (Button)findViewById(R.id.button_6);
        button_7 = (Button)findViewById(R.id.button_7);
        button_8 = (Button)findViewById(R.id.button_8);
        button_9 = (Button)findViewById(R.id.button_9);
        button_add = (Button)findViewById(R.id.button_add);
        button_bracket = (Button)findViewById(R.id.button_bracket);
        button_clear = (Button)findViewById(R.id.button_clear);
        button_del = (Button)findViewById(R.id.button_del);
        button_divide = (Button)findViewById(R.id.button_divide);
        button_dot = (Button)findViewById(R.id.button_dot);
        button_equal = (Button)findViewById(R.id.button_equal);
        button_multiply = (Button)findViewById(R.id.button_multiply);
        button_negative = (Button)findViewById(R.id.button_negative);
        button_sub = (Button)findViewById(R.id.button_sub);
        
        //initialize editText View
        resultText = (EditText) findViewById(R.id.editText1);
        
        //add onClickListener for each Buttons
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_bracket.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_negative.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// Get the button clicked
        Button button = (Button)v;
        final String clickedButtonText = button.getText().toString();        
        
        //clear and reset everything
        if(v==button_clear) {
        	symbolFlag = false;
        	token1 = "";
        	token2 = "";
        	operation ="" ;
        	token1_float = 0;
        	token2_float = 0;
        	result = 0;
        	textToShow = "";
        	resultText.setText(textToShow);
        }
        
        //condition for numbers clicked
        else if(v==button_0 || v==button_1 || v==button_2 || v==button_3 || v==button_4 ||
		   v==button_5 || v==button_6 || v==button_7 || v==button_8 || v==button_9 ||
		   v==button_dot) {
        	//append text on screen
            textToShow += clickedButtonText;
            resultText.setText(textToShow);
            
			if(symbolFlag) {
				token2 += clickedButtonText;
				Log.d("token2",token2);
			}
			else {
				token1 += clickedButtonText;
				Log.d("token1",token1);
			}
			
		}
		
		//condition for arithmatic operation clicked
		else if(v==button_add || v==button_multiply || v==button_divide || v==button_sub) {
			
			//append text on screen
	        textToShow += clickedButtonText;
	        resultText.setText(textToShow);
	        
			operation = clickedButtonText;
			if(token1!="") {
				token1_float = Float.valueOf(token1);
				symbolFlag = true;
				Log.d("token1_float",Float.toString(token1_float));
			}
			else if(token2!="") {
				token2_float = Float.valueOf(token2);
				symbolFlag = false;
				Log.d("token2_float",Float.toString(token2_float));
			}
				
		}
		
		//do the calculation
		else if(v==button_equal) {
			token2_float = Float.valueOf(token2);
			symbolFlag = false;
			Log.d("token2_float",Float.toString(token2_float));
			
			if(operation.equals("+"))  //addition
				result = token1_float + token2_float;
			else if(operation.equals("X"))  //multiplication
				result = token1_float * token2_float;
			else if(operation.equals("-"))  //substraction
				result = token1_float - token2_float;
			else if(operation.equals("/"))  //division
				result = token1_float / token2_float;
			resultText.setText(Float.toString(result));
			
			//after showing the result, reset everything
			symbolFlag = false;
        	token1 = "";
        	token2 = "";
        	operation ="" ;
        	token1_float = 0;
        	token2_float = 0;
        	result = 0;
        	textToShow = "";
		}
	}
}
