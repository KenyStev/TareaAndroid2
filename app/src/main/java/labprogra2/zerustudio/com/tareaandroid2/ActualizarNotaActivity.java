package labprogra2.zerustudio.com.tareaandroid2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActualizarNotaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_nota);

        int pos = (int)getIntent().getExtras().get("numCuenta");
        Student selected = MainActivity.classRoom.search(pos);

        TextView nombre = (TextView)findViewById(R.id.txtName);
        TextView cuenta = (TextView)findViewById(R.id.txtNCuenta);

        nombre.setText(selected.getName());
        cuenta.setText(selected.getCuenta()+"");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actualizar_nota, menu);
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

    public void update(View view) {
        EditText nota = (EditText)findViewById(R.id.txtNota);
        double not = Double.parseDouble(nota.getText().toString());

        Intent i = new Intent();
        i.putExtra("NOTA", not);
        setResult(RESULT_OK, i);

        finish();
    }

    public void cancel(View view) {
        Intent i = new Intent();
        setResult(RESULT_CANCELED, i);
        finish();
    }
}
