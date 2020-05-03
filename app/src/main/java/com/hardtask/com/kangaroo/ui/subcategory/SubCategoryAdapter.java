package com.hardtask.com.kangaroo.ui.subcategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder> {


    private List<SubCategoriesModel> subCategoriesModels = new ArrayList<>();


    @NonNull
    @Override
    public SubCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubCategoryHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_category_recycler_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryHolder holder, int position) {

        SubCategoriesModel currentItem = subCategoriesModels.get(position);
        String subCategoryName = currentItem.getCategoryName();
        holder.txtSubcategory.setText(subCategoryName);
        String subCategoryImage = currentItem.getPhotoPath();
        if (subCategoryImage != null && subCategoryImage.length() != 0)
            Picasso.get().load("http://nahasass06-001-site1.btempurl.com/" + subCategoryImage)
                    .fit().centerInside().into(holder.imgSubcategory);


    }

    @Override
    public int getItemCount() {
        return subCategoriesModels.size();
    }

    public void setList(List<SubCategoriesModel> list) {
        this.subCategoriesModels = list;
        notifyDataSetChanged();

    }

    public class SubCategoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_subcategory)
        CircleImageView imgSubcategory;
        @BindView(R.id.txt_subcategory)
        TextView txtSubcategory;

        public SubCategoryHolder(@NonNull View itemView) {
            super(itemView);
//            imgSubcategory = itemView.findViewById(R.id.img_subcategory);
//            txtSubcategory = itemView.findViewById(R.id.txt_subcategory);
        }
    }
}
