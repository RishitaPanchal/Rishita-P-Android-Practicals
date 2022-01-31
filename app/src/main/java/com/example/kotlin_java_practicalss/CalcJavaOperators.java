package com.example.kotlin_java_practicalss;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcJavaOperators extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    Button btnadd, btnsub, btnmul, btndiv, btnmod, btnshiftl, btnshiftr;
    int id;
    int n1, n2;

    String num1, num2;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_java_operators);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        ans = (TextView)findViewById(R.id.answer);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnmod = (Button) findViewById(R.id.btnmod);
        btnshiftl = (Button) findViewById(R.id.btnshiftl);
        btnshiftr = (Button) findViewById(R.id.btnshiftr);
        // n1 = Integer.parseInt(num1);

        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnmod.setOnClickListener(this);
        btnshiftr.setOnClickListener(this);
        btnshiftl.setOnClickListener(this);
    }
    public void onClick(View view) {
        Integer res;
        num1 = et1.getText().toString();
        num2 = et2.getText().toString();
        switch (view.getId()) {
            case R.id.btnadd:
                res = Integer.parseInt(num1)+Integer.parseInt(num2);
                ans.setText("Addition:"+res.toString());
                break;
            case R.id.btnsub:
                res = Integer.parseInt(num1)-Integer.parseInt(num2);
                ans.setText("Subtraction:"+res.toString());
                break;
            case R.id.btnmul:
                res = Integer.parseInt(num1)*Integer.parseInt(num2);
                ans.setText("Multiplication:"+res.toString());
                break;
            case R.id.btndiv:
                res = Integer.parseInt(num1)/Integer.parseInt(num2);
                ans.setText("Division:"+res.toString());
                break;
            case R.id.btnmod:
                res = Integer.parseInt(num1)%Integer.parseInt(num2);
                ans.setText("Modulous:"+res.toString());
                break;
            case R.id.btnshiftl:
                res = Integer.parseInt(num1)<<Integer.parseInt(num2);
                ans.setText("Left shift:"+res.toString());
                break;
            case R.id.btnshiftr:
                res = Integer.parseInt(num1)>>Integer.parseInt(num2);
                ans.setText("Right shift:"+res.toString());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}