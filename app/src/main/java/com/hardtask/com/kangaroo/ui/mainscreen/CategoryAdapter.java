package com.hardtask.com.kangaroo.ui.mainscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    private List<MainCategory> mainCategories = new ArrayList<>();
    private ItemClickListener mListener;

//    public CategoryAdapter(Context context, List<MainCategory> mainCategories) {
//        this.context = context;
//        this.mainCategories = mainCategories;
//    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_categories_recycler_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        MainCategory currentItem = mainCategories.get(position);
        String categoryName = currentItem.getManinCategoryName();
        holder.txtCategory.setText(categoryName);
        String image = currentItem.getPhotoPath();
        if (image != null && image.length() != 0)
            Picasso.get().load("http://nahasass06-001-site1.btempurl.com/" + image)
                    .fit().centerInside().into(holder.imgCategory);

    }

    @Override
    public int getItemCount() {
        return mainCategories.size();
    }

    public void setList(List<MainCategory> list) {

        this.mainCategories = list;
        notifyDataSetChanged();

    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_category)
        ImageView imgCategory;
        @BindView(R.id.txt_category)
        TextView txtCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClicked(getAdapterPosition());

                    }
                }
            });

        }

    }

    public interface ItemClickListener {
        void onItemClicked(int position);
    }

    public void setOnItemClicked(ItemClickListener itemClickListener) {
        this.mListener = itemClickListener;
    }
}
