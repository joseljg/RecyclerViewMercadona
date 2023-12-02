package es.joseljg.recyclerviewmercadona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import es.joseljg.clases.Producto;
import es.joseljg.clases.ProductosViewHolder;

public class DetallesProductosActivity extends AppCompatActivity {

    private Producto p;
    private TextView txt_detalles_cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);
        txt_detalles_cantidad = (TextView) findViewById(R.id.txt_detalles_cantidad);

        Intent intent = getIntent();
        if(intent != null)
        {
            p= (Producto)intent.getSerializableExtra(ProductosViewHolder.EXTRA_PRODUCTO_ITEM);
            txt_detalles_cantidad.setText("cantidad:" + String.valueOf(p.getCantidad()));
        }
    }
}