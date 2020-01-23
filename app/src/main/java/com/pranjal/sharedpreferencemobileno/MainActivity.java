package com.pranjal.sharedpreferencemobileno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS="shared_prefs";
    public static final String TEXT="text";
    private EditText mobileno;
    private EditText edshowall;
    private Button save;
    private Button showall;
    private String text="";
    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobileno=findViewById(R.id.edmobile);
        edshowall=findViewById(R.id.edshow);
        save=findViewById(R.id.btn_save);
        showall=findViewById(R.id.btn_showall);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("phone",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();

                if(count>0)
                editor.putString(" ",text+","+mobileno.getText().toString());
                else
                    editor.putString("",mobileno.getText().toString());
                editor.commit();
                count++;

                Toast t=Toast.makeText(MainActivity.this,"done",Toast.LENGTH_LONG);
                t.show();

            }
        });
        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("phone", MODE_PRIVATE);

                text = sharedPreferences.getString(" ", "");
                String s = text.replace(","," ");

                edshowall.setText(s);
                    //edshowall.setText("\n");


            }
        });
    }



}
