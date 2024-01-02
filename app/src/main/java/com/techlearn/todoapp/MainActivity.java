package com.techlearn.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<todoappModel> todoModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setTodoappModels();

        todoAdapter adapter = new todoAdapter(this, todoModel);
        recyclerView.setAdapter(adapter);
        todoModel.add(new todoappModel("Task 1"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void setTodoappModels(){

        EditText editText = findViewById(R.id.editTextTextPersonName);
        FloatingActionButton floatingActionButton= findViewById(R.id.floatingbutton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = editText.getText().toString();
                todoModel.add(new todoappModel(value));

                editText.getText().clear();

            }
        });
    }

}
