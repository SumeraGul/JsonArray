package com.example.jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sana \",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Ali\",\"salary\":\"60000\"}] }";
    TextView output ;
    String data ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.txtoutput);
        try {
            JSONObject obj = new JSONObject(strJson);
            JSONArray array = obj.getJSONArray("Employee");
            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                int id = Integer.parseInt(object.optString("id").toString());
                String name = object.optString("name").toString();
                Float salary = Float.parseFloat(object.optString("salary").toString());
                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
        }
            output.setText(data);




            } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}