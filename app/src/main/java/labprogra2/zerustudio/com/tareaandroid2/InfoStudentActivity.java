package labprogra2.zerustudio.com.tareaandroid2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class InfoStudentActivity extends ActionBarActivity {
    final int UPDATE_NOTA=2;
    Student selected;
    TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);

        selected = MainActivity.classRoom.getStudents().get(Integer.parseInt(getIntent().getExtras().get("position")+""));

        TextView name = (TextView)findViewById(R.id.txtName);
        TextView cuenta = (TextView)findViewById(R.id.txtNCuenta);
        nota = (TextView)findViewById(R.id.txtNota);

        name.setText(selected.getName());
        cuenta.setText(selected.getCuenta()+"");
        nota.setText(selected.getNotaFinal()+"");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateNata(View view) {
        Intent i = new Intent(this, ActualizarNotaActivity.class);
        i.putExtra("numCuenta", selected.getCuenta());
        startActivityForResult(i, UPDATE_NOTA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==UPDATE_NOTA){
            if(resultCode==RESULT_OK){
                double notaNew = (double)data.getExtras().get("NOTA");

                if(notaNew<=0 || notaNew>=100){
                    Toast.makeText(this, "No se puede Actualizar la nota: "+notaNew, Toast.LENGTH_LONG).show();
                }else{
                    selected.setNotaFinal(notaNew);
                    nota.setText(selected.getNotaFinal()+"");
                    Toast.makeText(this, "Nota Actualizada con Exito!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Actualizacion Cancelada!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
