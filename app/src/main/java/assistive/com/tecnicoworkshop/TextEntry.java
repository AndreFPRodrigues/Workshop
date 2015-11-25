package assistive.com.tecnicoworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextEntry extends AppCompatActivity {

    TextView title;
    EditText nameEdit;
    Button confirm;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_entry);

        //get views
        title = (TextView) findViewById(R.id.title);
        nameEdit = (EditText) findViewById(R.id.editName);
        confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(confirmListener);
        ll = (LinearLayout) findViewById(R.id.verticalParent);

        //criamos a texview
        TextView addText = new TextView(getApplicationContext());
        addText.setText("Adicionado programaticamente");

        //adicionamo-la ao llinearlayout
        ll.addView(addText);



    }

    View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = nameEdit.getText().toString();
            //title.setText(name);

            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            intent.putExtra("name",name);
            startActivity(intent);
        }
    };
}
