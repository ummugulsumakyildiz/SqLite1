package com.example.deneme.sqlite1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Water Calculater App");

        dbHandler=new MyDbHandler(this,null,null,1);

        Button ButtonGlass=(Button) findViewById(R.id.Glassbtn);
        Button ButtonBottle=(Button) findViewById(R.id.Bottlebtn);
        Button ButtonArchive=(Button) findViewById(R.id.Archivebtn);

        ButtonArchive.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent archIntent=new Intent(v.getContext(),Archive.class);
                startActivityForResult(archIntent,0);
            }
        });

        ButtonGlass.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
               showToast1(v);
                dbHandler.addGlass();
            }
        });

        ButtonBottle.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                showToast2(v);
                dbHandler.addBottle();
            }
        });

    }

    public void showToast1(View view){

        Toast.makeText(this,"200 ml Eklediniz",Toast.LENGTH_SHORT).show();
    }

    public void showToast2(View view){

        Toast.makeText(this,"500 ml Eklediniz",Toast.LENGTH_SHORT).show();
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        return super.onOptionsItemSelected(item);
    }*/
}

