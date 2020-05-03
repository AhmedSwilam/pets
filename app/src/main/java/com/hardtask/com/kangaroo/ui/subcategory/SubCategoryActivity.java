package com.hardtask.com.kangaroo.ui.subcategory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;
import com.hardtask.com.kangaroo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryActivity extends AppCompatActivity {

    @BindView(R.id.txt_subcategory_name)
    TextView txtSubcategoryName;
    @BindView(R.id.rec_subCategory)
    RecyclerView recSubCategory;
    private String mainCategoryId = "";
    private String categoryName = "";
    private List<SubCategoriesModel> subCategoriesModels;
    private SubCategoryAdapter subCategoryAdapter;
    private SubCategoryViewModel subCategoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mainCategoryId = intent.getStringExtra("categoryId");
        categoryName = intent.getStringExtra("categoryName");
        txtSubcategoryName.setText(categoryName);
        setAllSubCategories();

    }

    void setAllSubCategories(){
        subCategoryViewModel = new ViewModelProvider(this).get(SubCategoryViewModel.class);
        subCategoryViewModel.getSubCategoriesById(mainCategoryId);
        subCategoryAdapter = new SubCategoryAdapter();
        GridLayoutManager manager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recSubCategory.setAdapter(subCategoryAdapter);
        recSubCategory.setLayoutManager(manager);

        subCategoryViewModel.subCategoriesMutableData.observe(this, new Observer<List<SubCategoriesModel>>() {
            @Override
            public void onChanged(List<SubCategoriesModel> subCategoriesModels) {
                subCategoryAdapter.setList(subCategoriesModels);
            }
        });
    }
}
