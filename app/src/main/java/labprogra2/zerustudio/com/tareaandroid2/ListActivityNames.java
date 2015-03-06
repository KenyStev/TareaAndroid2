package labprogra2.zerustudio.com.tareaandroid2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;


public class ListActivityNames extends ListActivity {
    /*
    public static ClassRoom classRoom = new ClassRoom();

    static{
        classRoom.addStudent("Keny",21411165);
        classRoom.addStudent("KenyStev",21411166);
        classRoom.addStudent("Kenshi",21411167);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*String[] values = new String[classRoom.getStudents().size()];
        for(int l=0; l < classRoom.getStudents().size(); l++){
            values[l] = classRoom.getStudents().get(l).toString();
        }

        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.activity_list, R.id.txtName, classRoom.getStudents());
        setListAdapter(adapter);

        Button addStudent = (Button)findViewById(R.id.addStudent);
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
}
