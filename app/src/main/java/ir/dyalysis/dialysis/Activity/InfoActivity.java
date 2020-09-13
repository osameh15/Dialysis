package ir.dyalysis.dialysis.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Objects;

import ir.dyalysis.dialysis.Fragment.DialysisText;
import ir.dyalysis.dialysis.Fragment.HemodialysisText;
import ir.dyalysis.dialysis.R;

public class InfoActivity extends AppCompatActivity
{
    //Variables ...
    Toolbar toolbar;
    TextView toolbarName;
    FrameLayout frameLayout;
    private String fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Hooks
        toolbar = findViewById(R.id.infoToolbar);
        toolbarName = findViewById(R.id.toolbarNameInfo);
        frameLayout = findViewById(R.id.fragment_info_container);

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
        Bundle bundle = new Bundle();
        DialysisText dialysisText = new DialysisText();
        HemodialysisText hemodialysisText = new HemodialysisText();

        switch (Objects.requireNonNull(fragment))
        {
            case "kidneyText":
                toolbarName.setText(getResources().getString(R.string.kidney));
                bundle.putString("fragment", "kidneyText");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "kidneyTextTwo":
                toolbarName.setText(getResources().getString(R.string.kidney_function));
                bundle.putString("fragment", "kidneyTextTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "kidneyTextThree":
                toolbarName.setText(getResources().getString(R.string.kidney_failure));
                bundle.putString("fragment", "kidneyTextThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "kidneyTextFour":
                toolbarName.setText(getResources().getString(R.string.kidney_failure_more));
                bundle.putString("fragment", "kidneyTextFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "dialysisText":
                toolbarName.setText(getResources().getString(R.string.hemodialysis));
                bundle.putString("fragment", "dialysisText");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "dialysisTextTwo":
                toolbarName.setText(getResources().getString(R.string.dialysis_machine));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, hemodialysisText).commit();
                break;
            case "dialysisTextThree":
                toolbarName.setText(getResources().getString(R.string.filter));
                bundle.putString("fragment", "dialysisTextThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "dialysisTextFour":
                toolbarName.setText(getResources().getString(R.string.dialysis_lotion));
                bundle.putString("fragment", "dialysisTextFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "VeinTextOne":
                toolbarName.setText(getResources().getString(R.string.vein));
                bundle.putString("fragment", "VeinTextOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "VeinTextTwo":
                toolbarName.setText(getResources().getString(R.string.shaldon));
                bundle.putString("fragment", "VeinTextTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "VeinTextThree":
                toolbarName.setText(getResources().getString(R.string.fistula));
                bundle.putString("fragment", "VeinTextThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "VeinTextFour":
                toolbarName.setText(getResources().getString(R.string.fistula_learn));
                bundle.putString("fragment", "VeinTextFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "VeinTextFive":
                toolbarName.setText(getResources().getString(R.string.grapht));
                bundle.putString("fragment", "VeinTextFive");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextOne":
                toolbarName.setText(getResources().getString(R.string.diet));
                bundle.putString("fragment", "NourishTextOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextTwo":
                toolbarName.setText(getResources().getString(R.string.food_pyramid));
                bundle.putString("fragment", "NourishTextTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextThree":
                toolbarName.setText(getResources().getString(R.string.calorie));
                bundle.putString("fragment", "NourishTextThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextFour":
                toolbarName.setText(getResources().getString(R.string.thin));
                bundle.putString("fragment", "NourishTextFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextFive":
                toolbarName.setText(getResources().getString(R.string.sweet));
                bundle.putString("fragment", "NourishTextFive");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextSix":
                toolbarName.setText(getResources().getString(R.string.fat));
                bundle.putString("fragment", "NourishTextSix");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextSeven":
                toolbarName.setText(getResources().getString(R.string.protein));
                bundle.putString("fragment", "NourishTextSeven");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextEight":
                toolbarName.setText(getResources().getString(R.string.sodium));
                bundle.putString("fragment", "NourishTextEight");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextNineOne":
                toolbarName.setText(getResources().getString(R.string.potassium_what));
                bundle.putString("fragment", "NourishTextNineOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextNineTwo":
                toolbarName.setText(getResources().getString(R.string.low_potassium));
                bundle.putString("fragment", "NourishTextNineTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextNineThree":
                toolbarName.setText(getResources().getString(R.string.high_potassium));
                bundle.putString("fragment", "NourishTextNineThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextTenOne":
                toolbarName.setText(getResources().getString(R.string.phosphorus_what));
                bundle.putString("fragment", "NourishTextTenOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextTenTwo":
                toolbarName.setText(getResources().getString(R.string.phosphorus_material));
                bundle.putString("fragment", "NourishTextTenTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextTenThree":
            toolbarName.setText(getResources().getString(R.string.high_phosphorus));
            bundle.putString("fragment", "NourishTextTenThree");
            dialysisText.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
            break;
            case "NourishTextExtraOne":
                toolbarName.setText(getResources().getString(R.string.water));
                bundle.putString("fragment", "NourishTextExtraOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextExtraTwo":
                toolbarName.setText(getResources().getString(R.string.water_control));
                bundle.putString("fragment", "NourishTextExtraTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextExtraThree":
                toolbarName.setText(getResources().getString(R.string.vitamin));
                bundle.putString("fragment", "NourishTextExtraThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "NourishTextExtraFour":
                toolbarName.setText(getResources().getString(R.string.diet_dialysis));
                bundle.putString("fragment", "NourishTextExtraFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "DrugTextOne":
                toolbarName.setText(getResources().getString(R.string.calcitrol));
                bundle.putString("fragment", "DrugTextOne");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "DrugTextTwo":
                toolbarName.setText(getResources().getString(R.string.eritropotin));
                bundle.putString("fragment", "DrugTextTwo");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "DrugTextThree":
                toolbarName.setText(getResources().getString(R.string.renazhel));
                bundle.putString("fragment", "DrugTextThree");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "DrugTextFour":
                toolbarName.setText(getResources().getString(R.string.venufer));
                bundle.putString("fragment", "DrugTextFour");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "DrugTextFive":
                toolbarName.setText(getResources().getString(R.string.carbon_calcium));
                bundle.putString("fragment", "DrugTextFive");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "labValue":
                toolbarName.setText(getResources().getString(R.string.lab_value));
                bundle.putString("fragment", "labValue");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            case "sport":
                toolbarName.setText(getResources().getString(R.string.sport_dialysis));
                bundle.putString("fragment", "sport");
                dialysisText.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_info_container, dialysisText).commit();
                break;
            default:
                break;
        }
    }
}
