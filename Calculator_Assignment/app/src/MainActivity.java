package com.example.calculator_assignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText Display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = findViewById(R.id.text_bolx);
        Display.setShowSoftInputOnFocus(false);

        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.Display).equals(Display.getText().toString())){
                Display.setText("");
                }
            }

        });
    }
    //Update function in text box ;

    private void UpdateText(String strAdd){
    String previous_String = Display.getText().toString();
    int cursor_position = Display.getSelectionStart();
    String leftString = previous_String.substring(0,cursor_position);
    String rightString = previous_String.substring(cursor_position);
     if(getString(R.string.Display).equals(Display.getText().toString()))
     {
                  Display.setText(strAdd);
                  Display.setSelection(cursor_position + 1);
     }
else {
         Display.setText(String.format("%s%s%s", leftString, strAdd, rightString));
         Display.setSelection(cursor_position + 1);
     }

    }
    public void zero_btn(View view){
           UpdateText("0");
    }
    public void one_btn(View view){
        UpdateText("1");
    }
    public void two_btn(View view){
        UpdateText("2");
    }
    public void three_btn(View view){
        UpdateText("3");
    }
    public void four_btn(View view){
        UpdateText("4");
    }
    public void five_btn(View view){
        UpdateText("5");
    }
    public void six_btn(View view){
        UpdateText("6");
    }
    public void seven_btn(View view){
        UpdateText("7");
    }
    public void eight_btn(View view){
        UpdateText("8");
    }
    public void nine_btn(View view){
        UpdateText("9");
    }
    public void Clear_btn(View view){
        Display.setText("");
    }
    public void Parentheses_btn(View view){
          int cursor_position = Display.getSelectionStart();
          int open_bracket = 0;
          int close_bracket = 0;
          int length = Display.getText().length();

          for (int i=0; i<cursor_position; i++){
              if(Display.getText().toString().substring(i,i+1).equals("(")){
                  open_bracket += 1;
              }
              if(Display.getText().toString().substring(i,i+1).equals(")")){
                  close_bracket += 1;
              }
          }

          if(open_bracket == close_bracket || Display.getText().toString().substring(length - 1,length).equals("(")){

              UpdateText("(");
              Display.setSelection(cursor_position + 1);
          }
          else if( close_bracket < open_bracket && !Display.getText().toString().substring(length - 1,length).equals("(")){

              UpdateText(")");

          }
        Display.setSelection(cursor_position + 1);

    }
    public void Exponent_btn(View view){
        UpdateText("^");
    }
    public void Divide_btn(View view){
        UpdateText("/");
    }
    public void multiply_btn(View view){
        UpdateText("X");
    }
    public void Subtract_btn(View view){
        UpdateText("-");
    }
    public void Sum_btn(View view){
        UpdateText("+");
    }
    public void Equal_btn(View view){
        String user_input = Display.getText().toString();

        Expression exp = new Expression(user_input);

        String result = String.valueOf(exp.calculate());
        //display answer
        Display.setText(result);
        Display.setSelection(result.length());
    }
    public void Dot_btn(View view){
        UpdateText(".");
    }
    public void plus_Minus_btn(View view){
        UpdateText("-");
    }
    public void del_btn(View view){
        int cursor_position = Display.getSelectionStart();
        int length = Display.getText().length();

        if(cursor_position != 0 && length != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) Display.getText();
            selection.replace(cursor_position - 1,cursor_position,"");
            Display.setText(selection);
            Display.setSelection(cursor_position - 1);
        }

    }
}
