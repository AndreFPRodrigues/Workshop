package assistive.com.tecnicoworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListExample extends AppCompatActivity {

    ListView lista;
    EditText addBox;
    Button submit;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    //add item
    View.OnClickListener addItemListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            arrayList.add(addBox.getText().toString());
            addBox.setText("");
            arrayAdapter.notifyDataSetChanged();
        }
    };

    //Remove item from list
    AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("ListExample", arrayList.get(position).toString());
            arrayList.remove(position);
            arrayAdapter.notifyDataSetChanged();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addBox = (EditText) findViewById(R.id.addItem);
        submit = (Button) findViewById(R.id.buttonAdd);

        lista = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList();
        arrayList.add("Primeiro item");
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_selectable_list_item, arrayList);
        lista.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        lista.setOnItemClickListener(itemListener);

        submit.setOnClickListener(addItemListener);

    }
}