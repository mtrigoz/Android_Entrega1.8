package www.runa.entrega18;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText addBoleta, addMes, addDatos;
    private TextView valido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMes = (EditText)findViewById(R.id.addMes);
        addDatos = (EditText)findViewById(R.id.addDatos);
        addBoleta = (EditText)findViewById(R.id.addBoleta);
        valido = (TextView)findViewById(R.id.valido);

    }
    public void addBoleta (View v){
        String addBoleta_String = addBoleta.getText().toString();
        int addBoleta_int = Integer.parseInt(addBoleta_String);

        if (addBoleta_int >= 190){
            valido.setText("Correcto el valor es aceptable: "+addBoleta_int);
        } else if ( addBoleta_int <= 190 ) {
            valido.setText("'RECUERDA' ingresa un valor superior a 190, este monto es incorrecto: " + addBoleta_int);
        }

    }
    //GUARDAR TEMPORALMENTE
    public void Guardar(View v){
        String mes = addMes.getText().toString();
        String datos = addDatos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("meses", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(mes, datos);
        obj_editor.commit();
        Toast.makeText(this,"Datos Guardados",Toast.LENGTH_SHORT).show();
    }

    //BUSCAR TEMPORALMENTE
    public void Buscar(View v){
        String mes = addMes.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("meses",Context.MODE_PRIVATE);
        String datos = preferencias.getString(mes,"");

        if (datos.length()==0){
            Toast.makeText(this,"No se enontraron datos", Toast.LENGTH_SHORT).show();

        }else{
            addDatos.setText(datos);


        }

    }
}