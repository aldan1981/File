package com.example.a14file;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnWrite;
    private Button btnRead;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText = findViewById( R.id.etText );
        btnWrite = findViewById( R.id.btnWrite );
        btnRead = findViewById( R.id.btnRead );
        show = findViewById( R.id.txView );
        Write();
        Read();
    }
    public void Write(){
        btnWrite.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MyText = (String)editText.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput( "file" , MODE_PRIVATE );
                    fileOutputStream.write( MyText.getBytes() );
                    fileOutputStream.close();
                    Toast.makeText( MainActivity.this, "File Saved", Toast.LENGTH_SHORT ).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );

    }
    public void Read(){
        btnRead.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput( "file" );
                    InputStreamReader inputStreamReader = new InputStreamReader( fileInputStream );
                    BufferedReader bufferedReader = new BufferedReader( inputStreamReader );
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while((lines = bufferedReader.readLine())!= null){
                        stringBuffer.append( lines + "\n" );
                    }
                    show.setText( stringBuffer );

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );


    }




}


















