package com.example.tema2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RecenziiAdapter extends ArrayAdapter<Recenzie> {

    private Context context;
    private int layoutId;
    private List<Recenzie> recenzieList;
    private LayoutInflater inflater;


    public RecenziiAdapter(@NonNull Context context, int resource, @NonNull List<Recenzie> recenziiList, LayoutInflater inflater) {
        super(context, resource, recenziiList);

        this.context = context;
        this.layoutId = resource;
        this.recenzieList = recenziiList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.view_recenzie,parent,false);
        Recenzie recenzie = recenzieList.get(position);

        TextView tvSubmitedNumeRecenzie = view.findViewById(R.id.tvSubmitedNumeRecenzie);
        TextView tvSubmitedTextRecenzie = view.findViewById(R.id.tvSubmitedTextRecenzie);
        TextView tvSubmitedRatingRecenzie = view.findViewById(R.id.tvSubmitedRatingRecenzie);


        tvSubmitedNumeRecenzie.setText(recenzie.getNume());
        tvSubmitedTextRecenzie.setText(recenzie.getRecenzie());
        tvSubmitedRatingRecenzie.setText(String.format("%s/5.0", recenzie.getRating()));

        //validari & costumizari

        if (recenzie.getRating() >= 4.5) {
            tvSubmitedRatingRecenzie.setTextColor(Color.parseColor("#008000"));
            tvSubmitedRatingRecenzie.setTypeface(null, Typeface.BOLD);
        } else if (recenzie.getRating() < 2.0) {
            tvSubmitedRatingRecenzie.setTextColor(Color.RED);
            tvSubmitedRatingRecenzie.setTypeface(null, Typeface.ITALIC);
        } else{
            tvSubmitedRatingRecenzie.setTextColor(Color.parseColor("#E4D00A"));
        }


        String reviewText = recenzie.getRecenzie().toLowerCase();
        if (reviewText.contains("misto") || reviewText.contains("excelent") || reviewText.contains("excelenta")) {
            tvSubmitedTextRecenzie.setTextColor(Color.parseColor("#008080"));
            tvSubmitedTextRecenzie.setTypeface(null, Typeface.BOLD);
        }

        if (recenzie.getNume().length() > 10) {
            tvSubmitedNumeRecenzie.setTypeface(null, Typeface.ITALIC);
            tvSubmitedNumeRecenzie.setTextColor(Color.parseColor("#1702fa"));
        }



        return view;
    }
}
