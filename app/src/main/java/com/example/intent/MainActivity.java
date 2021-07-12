package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String input, answer;
    EditText edtmanhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtmanhinh = findViewById(R.id.edtso);
    }

    public void eventButton(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "M-":
                input = "";
                break;
            case "=":
                answer = input;
                KqNP();
                KqNPchia();
                KqNPTru();
                KqNPCong();
                break;
            case "x":
                input += "*";
                KqNP();
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    //in ket qua
                    KqNP();
                    KqNPchia();
                    KqNPTru();
                    KqNPCong();
                }
                input += data;
        }
        edtmanhinh.setText(input);
    }



    private void KqNP() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            } catch (Exception e) {

            }
        }
    }

    private void KqNPchia() {
        if (input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try {
                double chia = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = chia + "";
            } catch (Exception e) {

            }
        }
    }

    private void KqNPTru() {
        if (input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try {
                double tru = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = tru + "";
            } catch (Exception e) {

            }
        }
    }

    private void KqNPCong() {
        if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double cong = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = cong + "";
            } catch (Exception e) {

            }
        }
        String n[]=input.split("\\.");
        if(n.length >1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
    }

}
