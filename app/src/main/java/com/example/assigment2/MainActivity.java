package com.example.assigment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView t;
    CardView cv;
    ImageView imageView;

    public RecyclerView recycler;
    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t = (TextView) findViewById(R.id.info_text);
        imageView = (ImageView) findViewById(R.id.image);
        setContentView(R.layout.activity_main);

        List<Vegetables> items = new ArrayList<Vegetables>();

        items.add(new Vegetables(R.drawable.batata2, getString(R.string.batata)));
        items.add(new Vegetables(R.drawable.repollo_morado, getString(R.string.repollo)));

        adapter = new vegetablesAdapter(items);
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.myrecycler);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador

        recycler.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {




        return super.onCreateView(name, context, attrs);
    }
}

class Vegetables {
    private int imagen = 0;
    private String description = "";

    public Vegetables(int imagen, String description) {
        this.imagen = imagen;
        this.description = description;
    }

    public String getdescription() {
        return description;
    }

    public int getImagen() {
        return imagen;
    }
}

class vegetablesAdapter extends RecyclerView.Adapter<vegetablesAdapter.VegetablesViewHolder> {
    private List<Vegetables> items;

    public static class VegetablesViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView description;

        public VegetablesViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.image2);
            description = (TextView) itemView.findViewById(R.id.info_text);
        }
    }

    public vegetablesAdapter(List<Vegetables> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public VegetablesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.customcardview, viewGroup, false);
        return new VegetablesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VegetablesViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.description.setText(items.get(i).getdescription());
    }

}