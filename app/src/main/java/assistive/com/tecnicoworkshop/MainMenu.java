package assistive.com.tecnicoworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    TextView welcome;
    Button service;
    Button lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent received = getIntent();
        Bundle extra  = received.getExtras();

        String name="user";
        if(extra!=null)
            name = extra.getString("name");

        welcome = (TextView) findViewById(R.id.welcomeMessage);
        welcome.setText("Welcome " + name);

        service = (Button) findViewById(R.id.service);
        service.setOnClickListener(serviceListener);

        lista = (Button) findViewById(R.id.lista);
        lista.setOnClickListener(listaListener);
    }

    View.OnClickListener serviceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Libraries.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ListExample.class);
            startActivity(intent);
        }
    };
}
