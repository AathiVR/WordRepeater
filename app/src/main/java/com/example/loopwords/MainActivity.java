package com.example.loopwords;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    MaterialButton b0,b2,b3;
    TextView tv1;
    EditText et1,et2;
    ImageButton b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        b1 = findViewById(R.id.b1);
        b0 = findViewById(R.id.b0);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        tv1 = findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);




            try {
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        et1.setText("");
                        et2.setText("");
                        tv1.setText("");



                    }
                });


                b0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String text = et1.getText().toString().trim();
                        String repeatime = et2.getText().toString().trim();

                       if(!text.isEmpty() && !repeatime.isEmpty()) {
                           int time = Integer.parseInt(repeatime);


                           for (int i = 0; i < time; i++) {


                               tv1.append(text + "                                                                                      ");
                               tv1.append("  ");
                               tv1.append("  ");
                               tv1.append("  ");
                           }
                       }
                       else if(text.isEmpty()){
                           Toast.makeText(MainActivity.this, " Insert Text  ", Toast.LENGTH_SHORT).show();
                       }
                       else if(repeatime.isEmpty())
                       {
                           Toast.makeText(MainActivity.this, " Insert Repeat Value", Toast.LENGTH_SHORT).show();
                       }


                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText", tv1.getText().toString());
                clipboard.setPrimaryClip(clip);


                Toast.makeText(MainActivity.this, "C o p i e d", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText", tv1.getText().toString());
                clipboard.setPrimaryClip(clip);


                Toast.makeText(MainActivity.this, "C o p i e d", Toast.LENGTH_SHORT).show();

            }
        });



    }
}