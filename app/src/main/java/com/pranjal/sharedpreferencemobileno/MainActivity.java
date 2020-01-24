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

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String TEXT = "text";
    private EditText meditTextMobileNumber;
    private TextView mTextResult;
    private Button mSave;
    private Button mShowall;
    private String text = "";
    int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meditTextMobileNumber = findViewById(R.id.edmobile);
        mTextResult = findViewById(R.id.edshow);
        mSave = findViewById(R.id.btn_save);
        mShowall = findViewById(R.id.btn_showall);

    }

    public void Save(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("NumberFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Mobile", text + meditTextMobileNumber.getText().toString() + ",");
        editor.commit();

    }

    public void ShowAll(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences("NumberFile", MODE_PRIVATE);
        text = sharedPreferences.getString("Mobile", "");
        text = text.replace(",", "\n");
        Toast.makeText(this,"Show All",Toast.LENGTH_SHORT).show();
        mTextResult.setText(text);

    }
}
