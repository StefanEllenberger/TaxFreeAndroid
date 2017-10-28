package stefellenberger.taxfreeapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.graphics.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button addProduct;
    public Button reset;
    ArrayList<Product> products;
    ArrayAdapter<Product> itemsAdapter;
    ListView list;
    boolean OK;
    TextView greenred;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

    }

    public void init() {
        products = new ArrayList<>();
        list = (ListView) findViewById(R.id.list);
        itemsAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);
        list.setAdapter(itemsAdapter);

        addProduct = (Button) findViewById(R.id.addProduct);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, selectProduct.class);
                startActivityForResult(i, 0);
            }
        });

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                products = new ArrayList<>();
                itemsAdapter.clear();
            }
        });


        greenred = (TextView) findViewById(R.id.greenred);
        greenred.setBackgroundColor(Color.GREEN);
        OK = true;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        itemsAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);
        list.setAdapter(itemsAdapter);

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Product result = (Product) data.getSerializableExtra(selectProduct.EXTRA_MESSAGE);
            products.add(result);
            list.invalidateViews();
        }
        //check quota
        Quota q = new Quota();
        OK = q.add(products);

        if (OK){
            greenred.setBackgroundColor(Color.GREEN);
            greenred.setText("Kvote OK");
        } else {
            greenred.setBackgroundColor(Color.RED);
            greenred.setText("Overskredet kvote");
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
}
