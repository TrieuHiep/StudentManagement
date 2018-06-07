package com.studentmgmt.tatsuya.studentmanagement.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.studentmgmt.tatsuya.studentmanagement.R;
import com.studentmgmt.tatsuya.studentmanagement.model.BangDiem;

import java.util.List;

public class BDAdapter extends ArrayAdapter<BangDiem> {
    private Context context;
    private List<BangDiem> listBD;

    public BDAdapter(@NonNull Context context, int resource, @NonNull List<BangDiem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listBD = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.context).inflate(R.layout.bd_line, parent, false);
        TextView txtInfo = convertView.findViewById(R.id.txtInfoScore);
        txtInfo.setText(this.listBD.get(position).toString());
        return convertView;
    }
}
