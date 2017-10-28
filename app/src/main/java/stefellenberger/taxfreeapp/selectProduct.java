package stefellenberger.taxfreeapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectProduct extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "app";

    public Button smallbeer;
    public Button largebeer;
    public Button smallpack;
    public Button largepack;

    public Button bottlewine;
    public Button smallboxwine;
    public Button largeboxwine;

    public Button halfspirit;
    public Button fullspirit;

    public Button cigarettes;
    public Button halfsnus;
    public Button fullsnus;






    public void init(){
        smallbeer = (Button) findViewById(R.id.SMALLBEER);
        largebeer = (Button) findViewById(R.id.LARGEBEER);
        smallpack = (Button) findViewById(R.id.SMALLPACK);
        largepack = (Button) findViewById(R.id.LARGEPACK);

        bottlewine = (Button) findViewById(R.id.BOTTLEWINE);
        smallboxwine = (Button) findViewById(R.id.SMALLBOXWINE);
        largeboxwine = (Button) findViewById(R.id.LARGEBOXWINE);

        halfspirit = (Button) findViewById(R.id.HALFSPIRIT);
        fullspirit = (Button) findViewById(R.id.FULLSPIRIT);

        cigarettes = (Button) findViewById(R.id.CIGARETTES);
        halfsnus = (Button) findViewById(R.id.HALFSNUS);
        fullsnus = (Button) findViewById(R.id.FULLSNUS);


        smallbeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.SMALLBEER);
            }
        });
        largebeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.LARGEBEER);
            }
        });
        smallpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.SMALLPACK);
            }
        });
        largepack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.LARGEPACK);
            }
        });
        bottlewine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.BOTTLEWINE);
            }
        });
        smallboxwine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.SMALLBOXWINE);
            }
        });
        largeboxwine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.LARGEBOXWINE);
            }
        });
        halfspirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.HALFSPIRIT);
            }
        });
        fullspirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.FULLSPIRIT);
            }
        });
        cigarettes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.CIGARETTES);
            }
        });
        halfsnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.HALFSNUS);
            }
        });
        fullsnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProduct(Product.WHOLESNUS);
            }
        });

    }

/*
    smallbeer (Category.BEER, 330),
    largebeer (Category.BEER, 500),
    smallpack (Category.BEER, smallbeer.amount * 6),
    largepack (Category.BEER, largebeer.amount * 6),

    bottlewine (Category.WINE, 750),
    smallboxwine (Category.WINE, bottlewine.amount * 2),
    largeboxwine (Category.WINE, bottlewine.amount * 4),

    halfspirit (Category.SPIRIT, 500),
    fullspirit (Category.SPIRIT, 1000),

    cigarettes (Category.TOBACCO, 200),
    halfsnus (Category.TOBACCO, 110),
    WHOLESNUS (Category.TOBACCO, 210);
*/



    public void sendProduct(Product product){
        String r = product.toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_MESSAGE, product);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product2);
        init();
    }
}
