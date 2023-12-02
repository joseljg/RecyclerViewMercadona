package es.joseljg.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import es.joseljg.recyclerviewmercadona.R;

public class ListaProductoAdapter   extends RecyclerView.Adapter<ProductosViewHolder> {

    private ArrayList<Producto> productos;
    private Context contexto;

    private LayoutInflater inflate;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ListaProductoAdapter(Context contexto, ArrayList<Producto> productos) {
        this.productos = productos;
        this.contexto = contexto;
        this.inflate = LayoutInflater.from(this.contexto);
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myItemView = inflate.inflate(R.layout.item_rv_productos,parent,false);
       ProductosViewHolder pvh = new ProductosViewHolder(myItemView, this);
       return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
    Producto p = this.productos.get(position);
    holder.getTxt_nombre_item_rv_productos().setText("nombre: " + p.getNombre());
    holder.getTxt_cantidad_item_rv_productos().setText("cantidad: " + String.valueOf(p.getCantidad()));
    holder.getTxt_descripcion_item_rv_productos().setText("descripcion: " + p.getDescripcion());
    holder.getImg_item_rv_productos().setImageResource(R.drawable.producto);
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
