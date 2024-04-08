package es.ifp.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class StartActivity extends AppCompatActivity {

    protected TextView text1;
    protected Button boton1;
    protected Button boton2;
    protected Button  boton3;
    protected Button  boton4;


    private int num1=0;
    private int num2=0;
    private int resultado=0;
    private int orden=0;
    private Random random;
    private int otra_vez=1;
    private int res1=0;
    private int res2=0;
    private Intent pasar_pantalla;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(TextView) findViewById(R.id.text1_start);
        boton1=(Button) findViewById(R.id.boton1_start);
        boton2=(Button) findViewById(R.id.boton2_start);
        boton3=(Button) findViewById(R.id.boton3_start);
        boton4=(Button) findViewById(R.id.boton4_start);


        random=new Random();
        num1=random.nextInt(9);
        num2=random.nextInt(9);
        resultado=num1+num2;

        orden= random.nextInt(2);

        text1.setText(String.valueOf(num1) + " + " + String.valueOf(num2));

        do{
         res1=random.nextInt(18);
         res2=  random.nextInt(18);
        }while ((res1==res2)||(res1==resultado)||(res2==resultado));

        if (orden==0){
            boton1.setText(String.valueOf(resultado));
            boton2.setText(String.valueOf(res1));
            boton3.setText(String.valueOf(res2));
        } else if (orden==1) {
            boton1.setText(String.valueOf(res1));
            boton2.setText(String.valueOf(resultado));
            boton3.setText(String.valueOf(res2));

        }else {
            boton1.setText(String.valueOf(res1));
            boton2.setText(String.valueOf(res2));
            boton3.setText(String.valueOf(resultado));

        }

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado= Integer.parseInt(boton1.getText().toString());
                if(resultado==(num1+num2)){
                    Toast.makeText(StartActivity.this, "Has acertado", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.respuesta_correcta);
                    mp.start();
                    pasar_pantalla=new Intent(StartActivity.this, StartActivity.class);
                    finish();
                    startActivity(pasar_pantalla);
                }
                else {
                    Toast.makeText(StartActivity.this, "Prueba otra vez", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.error);
                    mp.start();
                }
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado= Integer.parseInt(boton2.getText().toString());
                if(resultado==(num1+num2)){
                    Toast.makeText(StartActivity.this, "Has acertado", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.respuesta_correcta);
                    mp.start();
                    pasar_pantalla=new Intent(StartActivity.this, StartActivity.class);
                    finish();
                    startActivity(pasar_pantalla);
                }
                else {
                    Toast.makeText(StartActivity.this, "Prueba otra vez", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.error);
                    mp.start();
                }
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado= Integer.parseInt(boton3.getText().toString());
                if(resultado==(num1+num2)){
                    Toast.makeText(StartActivity.this, "Has acertado", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.respuesta_correcta);
                    mp.start();
                    pasar_pantalla=new Intent(StartActivity.this, StartActivity.class);
                    finish();
                    startActivity(pasar_pantalla);
                }
                else {
                    Toast.makeText(StartActivity.this, "Prueba otra vez", Toast.LENGTH_SHORT).show();
                    mp=MediaPlayer.create(StartActivity.this,R.raw.error);
                    mp.start();
                }
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}