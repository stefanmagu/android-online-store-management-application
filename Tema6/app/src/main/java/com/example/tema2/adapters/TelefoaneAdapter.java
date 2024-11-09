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
import com.example.tema2.models.Telefon;

import java.util.List;

public class TelefoaneAdapter extends ArrayAdapter<Telefon> {

    private Context context;
    private int layoutId;
    private List<Telefon> telefoaneList;
    private LayoutInflater inflater;

    public TelefoaneAdapter(@NonNull Context context, int resource, @NonNull List<Telefon> telefoaneList, LayoutInflater inflater) {
        super(context, resource, telefoaneList);
        this.context = context;
        this.layoutId = resource;
        this.telefoaneList = telefoaneList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.view_produs,parent,false);
        Telefon telefon = telefoaneList.get(position);

        ImageView ivProdus = view.findViewById(R.id.ivProdus);
        TextView tvIdProdus = view.findViewById(R.id.tvIdProdus);
        TextView tvNumeProdus = view.findViewById(R.id.tvNumeProdus);
        TextView tvPretProdus = view.findViewById(R.id.tvPretProdus);
        TextView tvCantitateProdus = view.findViewById(R.id.tvCantitateProdus);

        ivProdus.setImageResource(telefon.getImageResourceId());
        tvIdProdus.setText("Id: " + telefon.getId());
        tvNumeProdus.setText("Nume: " + telefon.getNume());
        tvPretProdus.setText("Pret: " + telefon.getPret() + " RON");
        tvCantitateProdus.setText("Cantitate: " + telefon.getCantitate());

        if (telefon.getPret() > 300) {
            tvPretProdus.setTextColor(Color.RED);
        } else {
            tvPretProdus.setTextColor(Color.BLACK);
        }

        if (telefon.getNume().toLowerCase().contains("premium")) {
            tvNumeProdus.setTypeface(null, Typeface.BOLD);
        } else {
            tvNumeProdus.setTypeface(null, Typeface.NORMAL);
        }

        if (telefon.getCantitate() < 10) {
            tvCantitateProdus.setTypeface(null, Typeface.ITALIC);
        } else {
            tvCantitateProdus.setTypeface(null, Typeface.NORMAL);
        }

        return view;
    }
}
