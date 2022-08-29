package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText p,r,y,et4;
    Button b1;
    TextView tv1,tv2,emi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p=findViewById(R.id.pri);
        r=findViewById(R.id.roi);
        y=findViewById(R.id.year);
        b1=findViewById(R.id.btn1);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        emi=findViewById(R.id.emi);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a=p.getText().toString();
                String b=r.getText().toString();
                String c=y.getText().toString();

                if(TextUtils.isEmpty(a))
                {
                    p.setError("Please enter principle");
                    p.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(b))
                {
                    p.setError("Please enter Rate of Intrest");
                    p.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(c))
                {
                    p.setError("Please enter month");
                    p.requestFocus();
                    return;
                }

                float pri=Float.parseFloat(a);
                float roi=Float.parseFloat(b);
                float yer=Float.parseFloat(c);

                double em=Math.pow(1+(roi/12/100),yer);
                double d=em-1;
                double dd=em/d;
                float emm=(float) (pri*(roi/12/100)*dd);
                emi.setText(""+emm);

                float e=(float) (emm*yer-pri);
                tv1.setText(""+e);

                float ee=(float) (pri+e);
                tv2.setText(""+ee);



            }
        });




        
    }
}