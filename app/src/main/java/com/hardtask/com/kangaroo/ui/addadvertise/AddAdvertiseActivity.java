package com.hardtask.com.kangaroo.ui.addadvertise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AdvertiseType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AgeType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.Gender;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddAdvertiseActivity extends AppCompatActivity {


    @BindView(R.id.spin_type)
    SearchableSpinner spinType;
    @BindView(R.id.spin_age)
    SearchableSpinner spinAge;
    @BindView(R.id.spin_gender)
    SearchableSpinner spinGender;
    @BindView(R.id.spin_category)
    SearchableSpinner spinCategory;
    @BindView(R.id.spin_subcategory)
    SearchableSpinner spinSubcategory;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_count)
    EditText etCount;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.btn_add_advertise)
    Button btnAddAdvertise;
    private AddAdvertiseViewModel addAdvertiseViewModel;
    private List<AdvertiseType> advertiseTypes;
    private List<AgeType> ageTypes;
    private List<Gender> gendersTypes;
    private List<MainCategory> mainCategories;
    private String advtype;
    private String ageType;
    private String gender;
    private String mainCategoryId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advertise);
        ButterKnife.bind(this);
        setMainCategory();
        setAllAdvertiseTypes();
        setAllAgeType();
        setAllGenders();
    }

    void setMainCategory(){
        addAdvertiseViewModel = new ViewModelProvider(this).get(AddAdvertiseViewModel.class);
        mainCategories = new ArrayList<>();
        addAdvertiseViewModel.getCategories();
        ArrayAdapter<MainCategory> types = new ArrayAdapter<MainCategory>
                (this, android.R.layout.simple_spinner_item, mainCategories);
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCategory.setAdapter(types);


        spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainCategoryId = String.valueOf(mainCategories.get(i).getMainCategoryId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addAdvertiseViewModel.mainCategoriesMutableLiveData.observe(this, new Observer<List<MainCategory>>() {
            @Override
            public void onChanged(List<MainCategory> mainCategories) {
                types.addAll(mainCategories);
            }
        });
    }

    void setAllAdvertiseTypes() {
        addAdvertiseViewModel = new ViewModelProvider(this).get(AddAdvertiseViewModel.class);
        advertiseTypes = new ArrayList<>();
        addAdvertiseViewModel.getAdvTypes();
        ArrayAdapter<AdvertiseType> types = new ArrayAdapter<AdvertiseType>
                (this, android.R.layout.simple_spinner_item, advertiseTypes);
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinType.setAdapter(types);


        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                advtype = advertiseTypes.get(i).getTypeName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addAdvertiseViewModel.advertiseTypeMutableLiveData.observe(this, new Observer<List<AdvertiseType>>() {
            @Override
            public void onChanged(List<AdvertiseType> advertiseTypes) {
                types.addAll(advertiseTypes);
            }
        });
    }

    void setAllAgeType() {
        addAdvertiseViewModel = new ViewModelProvider(this).get(AddAdvertiseViewModel.class);
        ageTypes = new ArrayList<>();
        addAdvertiseViewModel.getAgeType();
        ArrayAdapter<AgeType> ageTypeArrayAdapter = new ArrayAdapter<AgeType>
                (this, android.R.layout.simple_spinner_item, ageTypes);
        ageTypeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAge.setAdapter(ageTypeArrayAdapter);

        spinAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ageType = ageTypes.get(i).getAgeTypeName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addAdvertiseViewModel.ageTypeMutableLiveData.observe(this, new Observer<List<AgeType>>() {
            @Override
            public void onChanged(List<AgeType> ageTypes) {
                ageTypeArrayAdapter.addAll(ageTypes);
            }
        });
    }

    void setAllGenders() {
        addAdvertiseViewModel = new ViewModelProvider(this).get(AddAdvertiseViewModel.class);
        gendersTypes = new ArrayList<>();
        addAdvertiseViewModel.getGender();
        ArrayAdapter<Gender> genderArrayAdapter = new ArrayAdapter<Gender>
                (this, android.R.layout.simple_spinner_item, gendersTypes);
        genderArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGender.setAdapter(genderArrayAdapter);

        spinGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = gendersTypes.get(i).getGenderName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addAdvertiseViewModel.genderMutableLiveData.observe(this, new Observer<List<Gender>>() {
            @Override
            public void onChanged(List<Gender> genderList) {
                genderArrayAdapter.addAll(genderList);
            }
        });
    }
}
