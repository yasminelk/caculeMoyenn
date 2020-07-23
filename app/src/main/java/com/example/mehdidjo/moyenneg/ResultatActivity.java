package com.example.mehdidjo.moyenneg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultatActivity extends AppCompatActivity {

    private String moy1;
    private String moy2;
    private String moy3;
    private String moy4;
    private String moy5;

    private TextView moduleView1;
    private TextView moduleView2;
    private TextView moduleView3;
    private TextView moduleView4;
    private TextView moduleView5;
    private TextView moyenneView;
    private TextView creditView;
    private TextView statusView;

    private double moyenne1;
    private double moyenne2;
    private double moyenne3;
    private double moyenne4;
    private double moyenne5;
    private double moyenneGen;
    private int sommecredit=0;
    java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        Bundle bundle = getIntent().getExtras();
        moy1 = bundle.getString("Moyenne1");
        moy2 = bundle.getString("Moyenne2");
        moy3 = bundle.getString("Moyenne3");
        moy4 = bundle.getString("Moyenne4");
        moy5 = bundle.getString("Moyenne5");

        Log.v("Resultat" , "---> Moyenne 1  : "+moy1);
        Log.v("Resultat" , "---> Moyenne 2  : "+moy2);
        Log.v("Resultat" , "---> Moyenne 3  : "+moy3);
        Log.v("Resultat" , "---> Moyenne 4  : "+moy4);
        Log.v("Resultat" , "---> Moyenne 5  : "+moy5);


        moduleView1 = findViewById(R.id.module1);
        moduleView2 = findViewById(R.id.module2);
        moduleView3 = findViewById(R.id.module3);
        moduleView4 = findViewById(R.id.module4);
        moduleView5 = findViewById(R.id.module5);
        moyenneView = findViewById(R.id.moyG);
        creditView = findViewById(R.id.credit);
        statusView = findViewById(R.id.status);

        moyenne1 = Double.parseDouble(moy1);
        moyenne2 = Double.parseDouble(moy2);
        moyenne3 = Double.parseDouble(moy3);
        moyenne4 = Double.parseDouble(moy4);
        moyenne5 = Double.parseDouble(moy5);

        moduleView1.setText(df.format(moyenne1));
        moduleView2.setText(df.format(moyenne2));
        moduleView3.setText(df.format(moyenne3));
        moduleView4.setText(df.format(moyenne4));
        moduleView5.setText(df.format(moyenne5));



        if (moyenne1>10){sommecredit = sommecredit + 3;}
        if (moyenne2>10){sommecredit = sommecredit + 2;}
        if (moyenne3>10){sommecredit = sommecredit + 3;}
        if (moyenne4>10){sommecredit = sommecredit + 3;}
        if (moyenne5>10){sommecredit = sommecredit + 2;}

        moyenneGen = ((moyenne1*2)+(moyenne2*2)+(moyenne3*3)+(moyenne4*3)+(moyenne5*1))/11;


        moyenneView.setText( String.valueOf(df.format(moyenneGen)) );
        creditView.setText(String.valueOf(sommecredit) );

        if(moyenneGen > 10 ){
            statusView.setText("Admis");
            creditView.setText(String.valueOf(13) );
        }else {
            statusView.setText("Ajourné");
        }
        
    }
}
