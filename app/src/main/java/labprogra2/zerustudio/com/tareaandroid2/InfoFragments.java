package labprogra2.zerustudio.com.tareaandroid2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zerokull on 03-13-15.
 */
public class InfoFragments extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_layout,
                container, false);
        return view;
    }
}
