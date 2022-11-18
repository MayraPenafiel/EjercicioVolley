package com.example.apivolley;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.apivolley.model.Animales;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    ListView listview;
    ArrayAdapter<String> arrayAdapter;
    ArrayList <String>  datos = new ArrayList<>();
    int num=0;
    int aninum;

    //Enlazar la vista con los datos a mostrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);
        listview=findViewById(R.id.listViewAnimales);
        listview.setAdapter(arrayAdapter);
        //mensaje=findViewById(R.id.etxtnumero);

        obtenerDatos();
    }

    //Metodo para conectar al Web Service

    private void obtenerDatos(){

        //aninum = getIntent().getIntExtra("etxtnumero",0);
        //num=mensaje.getText().charAt(0);
        String url="https://zoo-animal-api.herokuapp.com/animals/rand/10";
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
           @Override
            public void onResponse(JSONArray response) {
            //Recibir Informacion
                //Pasar de Json a la Clase Animales
                   pasarJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Manejar Error
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        //llamar al servicio de volley para hacer la peticion
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    //Metodo para pasar de Json a la clase publicacion
    private void pasarJson(JSONArray array){
        datos.add("_____________________________________________");
        for (int i=0;i<=array.length();i++) {
            JSONObject json;
            Animales ani = new Animales();

            try {
                //Setear Clases con los datos del Web service
                json = array.getJSONObject(i);
                ani.setId(json.getInt("id"));
                ani.setNombre(json.getString("name"));
                ani.setNombreLatin(json.getString("latin_name"));
                ani.setTipo(json.getString("animal_type"));
                ani.setActividad(json.getString("active_time"));
                ani.setLongitudMin(json.getInt("length_min"));
                ani.setLongitudMax(json.getInt("length_max"));
                ani.setPesoMin(json.getInt("weight_min"));
                ani.setPesoMax(json.getInt("weight_max"));
                ani.setTiempoVida(json.getInt("lifespan"));
                ani.setHabitat(json.getString("habitat"));
                ani.setDieta(json.getString("diet"));
                ani.setRangoGeografico(json.getString("geo_range"));
                ani.setImagen(json.getString("image_link"));

                //Agregar datos al arrayList enlazado con la lista de la vista
                datos.add("ID: "+ani.getId() + "");
                datos.add("Nombre: "+ani.getNombre());
                datos.add("Nombre Cientifico: "+ani.getNombreLatin());
                datos.add("Imagen: "+ani.getImagen());
                datos.add("Tiempo de Actividad: "+ani.getActividad());
                datos.add("Alimentacion: "+ani.getDieta());
                datos.add("Habitat: "+ani.getHabitat());
                datos.add("Tiempo de Vida: "+ani.getTiempoVida()+" años");
                datos.add("_____________________________________________");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayAdapter.notifyDataSetChanged();
        }
    }
}