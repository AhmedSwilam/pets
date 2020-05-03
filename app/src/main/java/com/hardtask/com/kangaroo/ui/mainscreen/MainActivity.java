package com.hardtask.com.kangaroo.ui.mainscreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.ui.addadvertise.AddAdvertiseActivity;
import com.hardtask.com.kangaroo.ui.localeapplanguage.LocaleHelper;
import com.hardtask.com.kangaroo.ui.loginscreen.LoginActivity;
import com.hardtask.com.kangaroo.ui.subcategory.SubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        CategoryAdapter.ItemClickListener {


    private String categoryId = "";
    private String categoryName = "";
    private List<MainCategory> mainCategories;
    private MainCategoryViewModel mainCategoryViewModel;
    private CategoryAdapter categoryAdapter;
    public static final String MyPREFERENCES = "MyPrefs";

    @BindView(R.id.rec_category)
    RecyclerView recCategory;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupNavMenu();
        setCategories();
        loadLanguage();

    }

    private void setCategories() {
        mainCategoryViewModel = ViewModelProviders.of(this).get(MainCategoryViewModel.class);
        mainCategoryViewModel.getCategories();
        categoryAdapter = new CategoryAdapter();
        GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL,
                false);
        recCategory.setLayoutManager(manager);
        recCategory.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClicked(this);

        mainCategoryViewModel.mainCategoriesMutableLiveData.observe(this, new Observer<List<MainCategory>>() {
            @Override
            public void onChanged(List<MainCategory> categories) {
                mainCategories = new ArrayList<>(categories);
                categoryAdapter.setList(categories);
                categoryAdapter.notifyDataSetChanged();

            }

        });
    }

    @Override
    public void onItemClicked(int position) {
        MainCategory mainCategory = mainCategories.get(position);
        categoryId = mainCategory.getMainCategoryId().toString();
        categoryName = mainCategory.getManinCategoryName();
        Intent intent = new Intent(this, SubCategoryActivity.class);
        intent.putExtra("categoryId", categoryId);
        intent.putExtra("categoryName", categoryName);
        startActivity(intent);


    }

    public void setupNavMenu() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(Color.RED);
        navView.setNavigationItemSelectedListener(this);
        getSupportActionBar();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.drawerLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.drawerAddNow:
                startActivity(new Intent(this, AddAdvertiseActivity.class));
                break;
            case R.id.drawerLanguage:
//                startActivity(new Intent(this, LoginActivity.class));
                showChangeLanguageDialog();
                drawerLayout.closeDrawers();
                break;
            case R.id.drawerAboutUs:
//                startActivity(new Intent(this, LoginActivity.class));
                break;
        }

        return true;
    }



    public void setLocaleLanguage(String language) {

        LocaleHelper.setLocale(this,language);
        SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE).edit();
        editor.putString("my Lang", language);
        editor.apply();
    }

    public void showChangeLanguageDialog(){
        final String[] listItems = {"English","Arabic"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("choose Language...");
        builder.setSingleChoiceItems(listItems, -1, (dialogInterface, i) -> {

            if (i == 0){
                Toast.makeText(this, "you choose English", Toast.LENGTH_SHORT).show();
                setLocaleLanguage("en_US");
                startActivity(new Intent(this,MainActivity.class));
            }
            else if (i == 1){
                Toast.makeText(this, "لقد اخترت اللغة العربية", Toast.LENGTH_SHORT).show();
                setLocaleLanguage("ar_EG");
                startActivity(new Intent(this,MainActivity.class));
            }
            dialogInterface.dismiss();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void loadLanguage(){
        SharedPreferences sharedLanguage = getSharedPreferences(MyPREFERENCES, Activity.MODE_PRIVATE);
        String language = sharedLanguage.getString("my Lang","");
        setLocaleLanguage(language);
    }

}
