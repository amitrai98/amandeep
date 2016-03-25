package android.com.michaleproject.adapters;

import android.com.michaleproject.R;
import android.com.michaleproject.modals.CategoryModal;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitrai on 17/3/16.
 */
public class CategoriesAdapter extends  RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>{

    List<CategoryModal> list_categories = new ArrayList<>();

    public CategoriesAdapter(List<CategoryModal> list_categories){
        this.list_categories = list_categories;
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_categories,parent ,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list_categories.size();
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        CategoryModal modal = list_categories.get(position);
        if(modal.getTxt_name() != null)
            holder.txt_optionitem.setText(modal.getTxt_name());

        holder.img_menuoption.setImageResource(modal.getImg_source());

    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView txt_optionitem;
        ImageView img_menuoption;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            txt_optionitem = (TextView) itemView.findViewById(R.id.txt_itemname);
            img_menuoption = (ImageView) itemView.findViewById(R.id.img_menuoption);
        }
    }
}
