package com.example.testapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

    private Button button;
    private Button button1;

    private ListView listView;



    


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        button1 = findViewById((R.id.button2)); 
        
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(view);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addItem(view);
            }
        });
        items = new ArrayList<>() ;
        itemsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items);
        listView.setAdapter(itemsAdapter);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void removeItem(View view) {

        itemsAdapter.remove(items.get(0));

    }



    private void addItem(View view) {

        EditText input = findViewById(R.id.editTextTextPersonName2);
        String itemText = input.getText().toString();
        if(!(itemText.equals(""))) {
            itemsAdapter.add((itemText));
            
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(), "please enter text" , Toast.LENGTH_LONG).show();
        }
        
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}