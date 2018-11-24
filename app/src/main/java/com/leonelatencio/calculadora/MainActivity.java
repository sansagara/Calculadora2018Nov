package com.leonelatencio.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private CharSequence oper1;
    private CharSequence oper2;
    private CharSequence selectedOperation;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        display = findViewById(R.id.display);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Ajustes seleccionado", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void digitSelected(View view) {
        if (display.getText() == selectedOperation) {
            display.setText("");
        }
        Button selectedButton = (Button) view;
        CharSequence selectedDigit = selectedButton.getText();
        display.append(selectedDigit);
    }

    public void operationSelected(View view) {
        Button selectedButton = (Button) view;
        selectedOperation = selectedButton.getText();
        oper1 = display.getText();
        display.setText("");
    }

    public void equalsSelected(View view) {
        oper2 = display.getText();
        result = 0;
        if (selectedOperation.toString().equals("+")) {
            Toast.makeText(this, "Suma", Toast.LENGTH_SHORT).show();
            result = Integer.parseInt(oper1.toString()) + Integer.parseInt(oper2.toString());
        }
        if (selectedOperation.toString().equals("-")) {
            Toast.makeText(this, "Resta", Toast.LENGTH_SHORT).show();
            result = Integer.parseInt(oper1.toString()) - Integer.parseInt(oper2.toString());
        }
        if (selectedOperation.toString().equals("*")) {
            Toast.makeText(this, "Mult", Toast.LENGTH_SHORT).show();
            result = Integer.parseInt(oper1.toString()) * Integer.parseInt(oper2.toString());
        }
        Toast.makeText(this, oper1.toString() + selectedOperation.toString() + oper2.toString(), Toast.LENGTH_LONG).show();
        display.setText(String.valueOf(result));
    }
}
