package es.joseljg.recyclerviewmercadona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

import es.joseljg.clases.ListaProductoAdapter;
import es.joseljg.clases.Producto;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_productos;
    private ListaProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_productos = (RecyclerView) findViewById(R.id.rv_productos);
        //-------------------------------------------------------------
        // recuperar los datos
        ArrayList<Producto> productosConsulta = new ArrayList<Producto>();
        productosConsulta.add(new Producto("p1","tomates", 30.0, "tomates de ensalada"));
        productosConsulta.add(new Producto("p2","peras", 10.0, "peras variedad1"));
        productosConsulta.add(new Producto("p3","carne", 20.0, "carne de pollo"));
        productosConsulta.add(new Producto("p4","pescado", 5.0, "pescado azul"));
        productosConsulta.add(new Producto("p5","atun", 2.0, "atun en aceite de oliva"));
        productosConsulta.add(new Producto("p6","papel", 10.0, "papel servilletas"));
        productosConsulta.add(new Producto("p7","latas", 20.0, "latas de mejillones"));
        productosConsulta.add(new Producto("p8","leche", 100.0, "leche pascual"));
        productosConsulta.add(new Producto("p9","zumo", 20.0, "zumo de naranja"));
        productosConsulta.add(new Producto("p10","pan", 20.0, "pan normal"));
        productosConsulta.add(new Producto("p11","huevos", 30.0, "huevos xl"));
        productosConsulta.add(new Producto("p12","platanos", 40.0, "platanos de canarias"));
        // crear un adaptador para mostrar la lista de productos en los correspondientes item
        adapter = new ListaProductoAdapter(this,productosConsulta);
        rv_productos.setAdapter(adapter);
        //-------------------------------------------------------------------
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            rv_productos.setLayoutManager(new GridLayoutManager(this,2));
        } else {
            // In portrait
            rv_productos.setLayoutManager(new LinearLayoutManager(this));
        }
        //-------------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(productosConsulta, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                    // CiudadController.borrarCiudad(c);
                    productosConsulta.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    productosConsulta.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.UP)
                {
                                  }
                if(direction == ItemTouchHelper.DOWN)
                {
                                    }
            }
        });
        helper.attachToRecyclerView(rv_productos);
    }
}