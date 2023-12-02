package es.joseljg.clases;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.joseljg.recyclerviewmercadona.DetallesProductosActivity;
import es.joseljg.recyclerviewmercadona.R;

public class ProductosViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_PRODUCTO_ITEM = "es.joseljg.clases.productoviewholder.producto";
    private TextView txt_nombre_item_rv_productos;
    private TextView txt_cantidad_item_rv_productos;
    private TextView txt_descripcion_item_rv_productos;
    private ImageView img_item_rv_productos;

    private ListaProductoAdapter lpa;
    public ProductosViewHolder(@NonNull View itemView, ListaProductoAdapter lpa) {
        super(itemView);
        txt_nombre_item_rv_productos = (TextView) itemView.findViewById(R.id.txt_nombre_item_rv_productos);
        txt_cantidad_item_rv_productos = (TextView)  itemView.findViewById(R.id.txt_cantidad_item_rv_productos);
        txt_descripcion_item_rv_productos = (TextView) itemView.findViewById(R.id.txt_descripcion_item_rv_productos);
        img_item_rv_productos = (ImageView) itemView.findViewById(R.id.img_item_rv_productos);
        this.lpa = lpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTxt_nombre_item_rv_productos() {
        return txt_nombre_item_rv_productos;
    }

    public void setTxt_nombre_item_rv_productos(TextView txt_nombre_item_rv_productos) {
        this.txt_nombre_item_rv_productos = txt_nombre_item_rv_productos;
    }

    public TextView getTxt_cantidad_item_rv_productos() {
        return txt_cantidad_item_rv_productos;
    }

    public void setTxt_cantidad_item_rv_productos(TextView txt_cantidad_item_rv_productos) {
        this.txt_cantidad_item_rv_productos = txt_cantidad_item_rv_productos;
    }

    public TextView getTxt_descripcion_item_rv_productos() {
        return txt_descripcion_item_rv_productos;
    }

    public void setTxt_descripcion_item_rv_productos(TextView txt_descripcion_item_rv_productos) {
        this.txt_descripcion_item_rv_productos = txt_descripcion_item_rv_productos;
    }

    public ImageView getImg_item_rv_productos() {
        return img_item_rv_productos;
    }

    public void setImg_item_rv_productos(ImageView img_item_rv_productos) {
        this.img_item_rv_productos = img_item_rv_productos;
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        Producto p = lpa.getProductos().get(posicion);
        Intent intent = new Intent(lpa.getContexto(), DetallesProductosActivity.class);
        intent.putExtra(EXTRA_PRODUCTO_ITEM,p);
        lpa.getContexto().startActivity(intent);

    }
}
