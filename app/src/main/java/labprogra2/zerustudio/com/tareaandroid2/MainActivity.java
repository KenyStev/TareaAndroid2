package labprogra2.zerustudio.com.tareaandroid2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    public static ClassRoom classRoom = new ClassRoom();
    static final int ADD_STUDENT = 1;

    static{
        classRoom.addStudent("Keny",21411165);
        classRoom.addStudent("KenyStev",21411166);
        classRoom.addStudent("Kenshi",21411167);
        classRoom.addStudent("Eduar",21411168);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    repaint();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void repaint(){
        final ListView listview = (ListView) findViewById(R.id.listStudents);

        final ArrayList<String> values = new ArrayList<>();
        for(int l=0; l < classRoom.getStudents().size(); l++){
            values.add(classRoom.getStudents().get(l).toString());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list, R.id.txtName, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                showInfoStudent(position);
            }

        });
    }

    private void showInfoStudent(int pos) {
        Intent i = new Intent(this, InfoStudentActivity.class);
        i.putExtra("position", pos);
        startActivity(i);
    }

    public void ADD(View view) {
        Intent i = new Intent(this, AddStudentActivity.class);
        startActivityForResult(i, ADD_STUDENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==ADD_STUDENT){
            if(resultCode==RESULT_OK){

                String name = (String) data.getExtras().get("NAME");
                int cuenta = (int) data.getExtras().get("CUENTA");

                if(classRoom.addStudent(name, cuenta)){
                    Toast.makeText(this, "Se Agrego correctamente! " + name, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Codigo ya fue tomado!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Operacion Cancelada!", Toast.LENGTH_LONG).show();
            }
        }
        repaint();
    }

    public void addStudent(View view) {
        String name = ((EditText)findViewById(R.id.etNameStudent)).getText().toString();
        int cuenta = Integer.parseInt(((EditText) findViewById(R.id.etNoCuenta)).getText().toString());

        if(classRoom.addStudent(name, cuenta)){
            repaint();
            Toast.makeText(this, "Se Agrego correctamente! " + name, Toast.LENGTH_LONG).show();
            ((EditText)findViewById(R.id.etNameStudent)).setText("");
            ((EditText)findViewById(R.id.etNoCuenta)).setText("");
        }else{
            Toast.makeText(this, "Codigo ya fue tomado!", Toast.LENGTH_LONG).show();
        }
    }

    public void cancel(View view) {
        ((EditText)findViewById(R.id.etNameStudent)).setText("");
        ((EditText)findViewById(R.id.etNoCuenta)).setText("");
    }
}



