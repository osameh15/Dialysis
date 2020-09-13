package ir.dyalysis.dialysis.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Objects;

import ir.dyalysis.dialysis.Fragment.DialysisFragment;
import ir.dyalysis.dialysis.Fragment.DrugFragment;
import ir.dyalysis.dialysis.Fragment.KidneyFragment;
import ir.dyalysis.dialysis.Fragment.NourishFragment;
import ir.dyalysis.dialysis.Fragment.VeinFragment;
import ir.dyalysis.dialysis.R;

public class BaseActivity extends AppCompatActivity
{
    //Variables ...
    TextView toolbarName;
    Toolbar toolbar;
    FrameLayout frameLayout;
    private String fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //Hooks
        toolbarName = findViewById(R.id.toolbarName);
        toolbar = findViewById(R.id.baseToolbar);
        frameLayout = findViewById(R.id.fragment_base_container);

        //Toolbar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Bundle extra data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            fragment = bundle.getString("name");
        }

        //Show fragment
        showFragments();
    }

    //OnBackPressed
    @Override
    public void onBackPressed()
    {
        finish();
    }
    //back Button method ...
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

    //show fragments function to switch Between fragments
    private void showFragments()
    {
        switch (Objects.requireNonNull(fragment))
        {
            case "kidney":
                toolbarName.setText(getResources().getString(R.string.kidney));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base_container, new KidneyFragment()).commit();
                break;
            case "dialysis":
                toolbarName.setText(getResources().getString(R.string.app_name_farC));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base_container, new DialysisFragment()).commit();
                break;
            case "vein":
                toolbarName.setText(getResources().getString(R.string.vein_toolbar));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base_container, new VeinFragment()).commit();
                break;
            case "drug":
                toolbarName.setText(getResources().getString(R.string.drug_store));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base_container, new DrugFragment()).commit();
                break;
            case "nourish":
                toolbarName.setText(getResources().getString(R.string.nourish));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_base_container, new NourishFragment()).commit();
                break;
        }
    }
}
