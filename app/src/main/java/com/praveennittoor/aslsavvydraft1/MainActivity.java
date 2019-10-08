package com.praveennittoor.aslsavvydraft1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    // Create an ArrayAdapter using the string array and a default spinner layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       // Intent a=new Intent(getApplicationContext(),VideoCapture.class);
        //startActivity(a);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                Toast.makeText
                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();
               // final Spinner cardStatusSpinner1 = (Spinner) findViewById(R.id.spinner);
                //final String[] cardStatusString = new String[1];

                final Button saveBtn = (Button) findViewById(R.id.selectbutton);
                saveBtn .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        EditText edit = (EditText)findViewById(R.id.editText);
                        TextView tview = (TextView)findViewById(R.id.editText);
                        String result = edit.getText().toString();
                        tview.setText(result);
                        System.out.println("Selected cardStatusString : " + selectedItemText+ "\ntext output" +" "+ result); //this will print the result
                        Bundle basket= new Bundle();
                        basket.putString("username", result);
                        basket.putString("aslVid",selectedItemText);
                        Intent a=new Intent(MainActivity.this,SecondScreen.class);
                        a.putExtras(basket);
                        startActivity(a);
                    }
                });
              //  Intent sendStuff = new Intent(this, SecondScreen.class);
               // sendStuff.putExtra(key, stringvalue);
                //startActivity(sendStuff);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}
