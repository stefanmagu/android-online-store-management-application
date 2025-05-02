package com.example.app.adapters;

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

import com.example.app.R;
import com.example.app.models.Frigider;

import java.util.List;

public class FrigidereAdapter extends ArrayAdapter<Frigider> {
    private Context context;
    private int layoutId;
    private List<Frigider> frigidereList;
    private LayoutInflater inflater;

    public FrigidereAdapter(@NonNull Context context, int resource, @NonNull List<Frigider> frigidereList, LayoutInflater inflater) {
        super(context, resource, frigidereList);
        this.context = context;
        this.layoutId = resource;
        this.frigidereList = frigidereList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.view_produs, parent, false);
        Frigider frigider = frigidereList.get(position);

        ImageView ivProdus = view.findViewById(R.id.ivProdus);
        TextView tvIdProdus = view.findViewById(R.id.tvIdProdus);
        TextView tvNumeProdus = view.findViewById(R.id.tvNumeProdus);
        TextView tvPretProdus = view.findViewById(R.id.tvPretProdus);
        TextView tvCantitateProdus = view.findViewById(R.id.tvCantitateProdus);


        if (frigider.getPret() > 6000) {
            tvPretProdus.setTextColor(Color.RED);
        } else {
            tvPretProdus.setTextColor(Color.BLACK);
        }

        if (frigider.getNume().toLowerCase().contains("beko") || frigider.getNume().toLowerCase().contains("gorenje")) {
            tvNumeProdus.setTypeface(null, Typeface.BOLD);
        } else {
            tvNumeProdus.setTypeface(null, Typeface.NORMAL);
        }


        if (frigider.getCantitate() <= 10) {
            tvCantitateProdus.setTypeface(null, Typeface.ITALIC);
            tvCantitateProdus.setTextColor(Color.parseColor("#FFA500"));
        } else {
            tvCantitateProdus.setTypeface(null, Typeface.NORMAL);
        }

        ivProdus.setImageResource(frigider.getImageResourceId());
        tvIdProdus.setText("Id: " + frigider.getId());
        tvNumeProdus.setText("Nume: " + frigider.getNume());
        tvPretProdus.setText("Pret: " + frigider.getPret() + " RON");
        tvCantitateProdus.setText("Cantitate: " + frigider.getCantitate());

        return view;
    }
}
