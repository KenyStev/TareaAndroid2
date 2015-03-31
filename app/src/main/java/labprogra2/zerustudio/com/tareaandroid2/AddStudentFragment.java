package labprogra2.zerustudio.com.tareaandroid2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by zerokull on 03-13-15.
 */
public class AddStudentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_student,
                container, false);
        return view;
    }

    public void addStudent(View view) {
        String name = ((EditText)getView().findViewById(R.id.etNameStudent)).getText().toString();
        int cuenta = Integer.parseInt(((EditText) getView().findViewById(R.id.etNoCuenta)).getText().toString());

        if(MainActivity.classRoom.addStudent(name, cuenta)){
            Toast.makeText(getView().getContext(), "Se Agrego correctamente! " + name, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getView().getContext(), "Codigo ya fue tomado!", Toast.LENGTH_LONG).show();
        }
    }
}
