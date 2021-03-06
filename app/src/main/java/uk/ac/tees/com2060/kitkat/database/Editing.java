package uk.ac.tees.com2060.kitkat.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Editing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        List<ListInfo> item = new ArrayList<ListInfo>();

        final DatabaseHandler dh = new DatabaseHandler(this);

        final int ID = 0;

        item = dh.getOne(ID);

        Button svBtn = (Button) findViewById(R.id.save_button1);
        Button cnclBtn = (Button) findViewById(R.id.cancel_button1);

        final EditText name = (EditText) findViewById(R.id.editTextName1);
        final EditText contents = (EditText) findViewById(R.id.editTextContents1);
        final EditText category = (EditText) findViewById(R.id.editTextCat1);

        name.setText(item.get(0).toString());
        contents.setText(item.get(1).toString());
        category.setText(item.get(2).toString());


        svBtn.setOnClickListener(


                new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {

                        Log.d("Database:", "Updating Entry...");  //For personal testing
                        dh.updateByID(ID, name.getText().toString(), contents.getText().toString(), category.getText().toString());
                    }
                }
        );


        //This method kills the activity
        cnclBtn.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v){
                        finish();
                    }
                }
        );

    }
}

