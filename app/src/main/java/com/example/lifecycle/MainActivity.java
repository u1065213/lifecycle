package com.example.lifecycle;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find R id
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        //設定 button click 事件共用的傾聽 my Listener
        button.setOnClickListener(myListener);
        button2.setOnClickListener(myListener);
        button3.setOnClickListener(myListener);
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResum",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    private  Button.OnClickListener myListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:
                    Uri uri = Uri.parse("tel:0999123456");
                    Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                    break;
                case R.id.button2:
                    Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent1);
                    break;
                case  R.id.button3:
                    finish();
                    break;
            }

        }
    };
}
