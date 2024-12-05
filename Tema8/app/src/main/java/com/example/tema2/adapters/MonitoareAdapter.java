package com.example.tema2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tema2.R;
import com.example.tema2.models.Frigider;
import com.example.tema2.models.Monitor;

import java.util.ArrayList;
import java.util.List;

public class MonitoareAdapter extends ArrayAdapter<Monitor> {
    private Context context;
    private int layoutId;
    private List<Monitor> monitoareList;
    private LayoutInflater inflater;

    public MonitoareAdapter(@NonNull Context context, int resource, @NonNull List<Monitor> monitoareList, LayoutInflater inflater) {
        super(context, resource, monitoareList);
        this.context = context;
        this.layoutId = resource;
        this.monitoareList = monitoareList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.view_produs, parent, false);
        Monitor monitor = monitoareList.get(position);

        ImageView ivProdus = view.findViewById(R.id.ivProdus);
        TextView tvIdProdus = view.findViewById(R.id.tvIdProdus);
        TextView tvNumeProdus = view.findViewById(R.id.tvNumeProdus);
        TextView tvPretProdus = view.findViewById(R.id.tvPretProdus);
        TextView tvCantitateProdus = view.findViewById(R.id.tvCantitateProdus);


        if (monitor.getPret() > 5000) {
            tvPretProdus.setTextColor(Color.RED);
        } else {
            tvPretProdus.setTextColor(Color.BLACK);
        }

        if (monitor.getNume().toLowerCase().contains("acer") || monitor.getNume().toLowerCase().contains("benq")) {
            tvNumeProdus.setTypeface(null, Typeface.BOLD);
        } else {
            tvNumeProdus.setTypeface(null, Typeface.NORMAL);
        }


        if (monitor.getCantitate() <= 10) {
            tvCantitateProdus.setTypeface(null, Typeface.ITALIC);
            tvCantitateProdus.setTextColor(Color.parseColor("#FFA500"));
        } else {
            tvCantitateProdus.setTypeface(null, Typeface.NORMAL);
        }

        ivProdus.setImageResource(monitor.getImageResourceId());
        tvIdProdus.setText("Id: " + monitor.getId());
        tvNumeProdus.setText("Nume: " + monitor.getNume());
        tvPretProdus.setText("Pret: " + monitor.getPret() + " RON");
        tvCantitateProdus.setText("Cantitate: " + monitor.getCantitate());

        return view;
    }
}
