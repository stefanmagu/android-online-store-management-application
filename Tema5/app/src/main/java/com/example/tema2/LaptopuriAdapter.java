package com.example.tema2;

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

import java.util.List;

public class LaptopuriAdapter extends ArrayAdapter<Laptop> {
    private Context context;
    private int layoutId;
    private List<Laptop> laptopuriList;
    private LayoutInflater inflater;

    public LaptopuriAdapter(@NonNull Context context, int resource, @NonNull List<Laptop> laptopuriList, LayoutInflater inflater) {
        super(context, resource, laptopuriList);
        this.context = context;
        this.layoutId = resource;
        this.laptopuriList = laptopuriList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.view_produs,parent,false);
        Laptop laptop = laptopuriList.get(position);

        ImageView ivProdus = view.findViewById(R.id.ivProdus);
        TextView tvIdProdus = view.findViewById(R.id.tvIdProdus);
        TextView tvNumeProdus = view.findViewById(R.id.tvNumeProdus);
        TextView tvPretProdus = view.findViewById(R.id.tvPretProdus);
        TextView tvCantitateProdus = view.findViewById(R.id.tvCantitateProdus);


        if (laptop.getPret() > 5000) {
            tvPretProdus.setTextColor(Color.RED);
        } else {
            tvPretProdus.setTextColor(Color.BLACK);
        }

        if (laptop.getNume().toLowerCase().contains("gaming") || laptop.getNume().toLowerCase().contains("pro")) {
            tvNumeProdus.setTypeface(null, Typeface.BOLD);
        } else {
            tvNumeProdus.setTypeface(null, Typeface.NORMAL);
        }


        if (laptop.getCantitate() < 5) {
            tvCantitateProdus.setTypeface(null, Typeface.ITALIC);
            tvCantitateProdus.setTextColor(Color.parseColor("#FFA500"));
        } else {
            tvCantitateProdus.setTypeface(null, Typeface.NORMAL);
        }

        ivProdus.setImageResource(laptop.getImageResourceId());
        tvIdProdus.setText("Id: " + laptop.getId());
        tvNumeProdus.setText("Nume: " + laptop.getNume());
        tvPretProdus.setText("Pret: " + laptop.getPret() + " RON");
        tvCantitateProdus.setText("Cantitate: " + laptop.getCantitate());

        return view;
    }

}
