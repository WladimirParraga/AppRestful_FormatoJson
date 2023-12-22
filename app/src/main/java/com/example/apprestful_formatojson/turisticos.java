package com.example.apprestful_formatojson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apprestful_formatojson.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import WebServices.WebService;
import java.util.Map;
import java.util.HashMap;
import WebServices.Asynchtask;
public class turisticos extends AppCompatActivity implements Asynchtask{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turisticos);

        Map<String, String> datos = new HashMap<>();


        WebService ws = new WebService(
                "https://jsonplaceholder.typicode.com/users",
                datos,
                turisticos.this,
                turisticos.this);

        ws.execute("GET", "Public-Merchant-Id", "84e1d0de1fbf437e9779fd6a52a9ca18");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.d("API_RESPONSE", result);  // Imprime la respuesta en la consola

        TextView txtBancos = findViewById(R.id.txtbanco);

        // Muestra el resultado JSON completo en el TextView
        txtBancos.setText("Respuesta WS: " + result);
    }
}