package ir.dyalysis.dialysis.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.Objects;
import ir.dyalysis.dialysis.R;
import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class DialysisText extends Fragment
{
    //Variables...
    private ImageView imageView;
    private ImageView share;
    private TextView textView;
    private String subject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialysis_text, container, false);

        //Hooks
        imageView = view.findViewById(R.id.imageInfo);
        textView = view.findViewById(R.id.textInfo);
        share = Objects.requireNonNull(getActivity()).findViewById(R.id.shareText);

        //Bundle
        subject = Objects.requireNonNull(this.getArguments()).getString("fragment");

        //Justify TextView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            textView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        //Show Fragment
        showFragment(Objects.requireNonNull(subject));

        //share text method
        share.setOnClickListener(v ->
                shareText(subject));

        return view;
    }

    private void showFragment(String s)
    {
        switch (s)
        {
            case "kidneyText":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kidney_text_one));
                textView.setText(getResources().getString(R.string.kidney_text_one));
                break;
            case "kidneyTextTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kidney_func));
                textView.setText(getResources().getString(R.string.kidney_text_two));
                break;
            case "kidneyTextThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kidney_failure));
                textView.setText(getResources().getString(R.string.kidney_text_three));
                break;
            case "kidneyTextFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kidney_failure_more));
                textView.setText(getResources().getString(R.string.kidney_text_four));
                break;
            case "dialysisText":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hemodialysis_one));
                textView.setText(getResources().getString(R.string.dialysis_text_one));
                break;
            case "dialysisTextThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.filter));
                textView.setText(getResources().getString(R.string.dialysis_text_three));
                break;
            case "dialysisTextFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dialysis_lotion));
                textView.setText(getResources().getString(R.string.dialysis_text_four));
                break;
            case "VeinTextOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.vein));
                textView.setText(getResources().getString(R.string.vein_text_one));
                break;
            case "VeinTextTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.shaldon));
                textView.setText(getResources().getString(R.string.vein_text_two));
                break;
            case "VeinTextThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fistula_one));
                textView.setText(getResources().getString(R.string.vein_text_three));
                break;
            case "VeinTextFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fistula));
                textView.setText(getResources().getString(R.string.vein_text_four));
                break;
            case "VeinTextFive":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.grapht));
                textView.setText(getResources().getString(R.string.vein_text_five));
                break;
            case "NourishTextOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.food_pyramid));
                textView.setText(getResources().getString(R.string.nourish_text_one));
                break;
            case "NourishTextTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.food_pyramid_one));
                textView.setText(getResources().getString(R.string.nourish_text_two));
                break;
            case "NourishTextThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.basket));
                textView.setText(getResources().getString(R.string.nourish_text_three));
                break;
            case "NourishTextFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fat));
                textView.setText(getResources().getString(R.string.nourish_text_four));
                break;
            case "NourishTextFive":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.candy));
                textView.setText(getResources().getString(R.string.nourish_text_five));
                break;
            case "NourishTextSix":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.fat_one));
                textView.setText(getResources().getString(R.string.nourish_text_six));
                break;
            case "NourishTextSeven":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.meat));
                textView.setText(getResources().getString(R.string.nourish_text_seven));
                break;
            case "NourishTextEight":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.salt));
                textView.setText(getResources().getString(R.string.nourish_text_eight));
                break;
            case "NourishTextNineOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.potassium));
                textView.setText(getResources().getString(R.string.nourish_text_nine_one));
                break;
            case "NourishTextNineTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.apple));
                textView.setText(getResources().getString(R.string.nourish_text_nine_two));
                break;
            case "NourishTextNineThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.orange));
                textView.setText(getResources().getString(R.string.nourish_text_nine_three));
                break;
            case "NourishTextTenOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bone));
                textView.setText(getResources().getString(R.string.nourish_text_ten_one));
                break;
            case "NourishTextTenTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dinner));
                textView.setText(getResources().getString(R.string.nourish_text_ten_two));
                break;
            case "NourishTextTenThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.chocolate));
                textView.setText(getResources().getString(R.string.nourish_text_ten_three));
                break;
            case "NourishTextExtraOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.water_drink_two));
                textView.setText(getResources().getString(R.string.nourish_text_extra_one));
                break;
            case "NourishTextExtraTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.water));
                textView.setText(getResources().getString(R.string.nourish_text_extra_two));
                break;
            case "NourishTextExtraThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.vitamin));
                textView.setText(getResources().getString(R.string.nourish_text_extra_three));
                break;
            case "NourishTextExtraFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.salad));
                textView.setText(getResources().getString(R.string.nourish_text_extra_four));
                break;
            case "DrugTextOne":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.calcitriol));
                textView.setText(getResources().getString(R.string.drug_text_one));
                break;
            case "DrugTextTwo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eprex));
                textView.setText(getResources().getString(R.string.drug_text_two));
                break;
            case "DrugTextThree":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.renazhel));
                textView.setText(getResources().getString(R.string.drug_text_three));
                break;
            case "DrugTextFour":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.venofer));
                textView.setText(getResources().getString(R.string.drug_text_four));
                break;
            case "DrugTextFive":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.carbon_calcium));
                textView.setText(getResources().getString(R.string.drug_text_five));
                break;
            case "labValue":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.scientist));
                textView.setText(getResources().getString(R.string.lab_text));
                break;
            case "sport":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bike));
                textView.setText(getResources().getString(R.string.sport_text));
                break;
        }
    }

    //share text for friends
    private void shareText(String s)
    {
        String message;
        switch (s)
        {
            case "kidneyText":
                message = getResources().getString(R.string.kidney) +"\n\n"+ getResources().getString(R.string.kidney_text_one);
                break;
            case "kidneyTextTwo":
                message = getResources().getString(R.string.kidney_function) +"\n\n"+ getResources().getString(R.string.kidney_text_two);
                break;
            case "kidneyTextThree":
                message = getResources().getString(R.string.kidney_failure) + "\n\n"+ getResources().getString(R.string.kidney_text_three);
                break;
            case "kidneyTextFour":
                message = getResources().getString(R.string.kidney_failure_more) + "\n\n" + getResources().getString(R.string.kidney_text_four);
                break;
            case "dialysisText":
                message = getResources().getString(R.string.hemodialysis) + "\n\n"+ getResources().getString(R.string.dialysis_text_one);
                break;
            case "dialysisTextTwo":
                message = getResources().getString(R.string.dialysis_machine) + "\n\n"+ getResources().getString(R.string.dialysis_text_two);
                break;
            case "dialysisTextThree":
                message = getResources().getString(R.string.filter) + "\n\n"+ getResources().getString(R.string.dialysis_text_three);
                break;
            case "dialysisTextFour":
                message = getResources().getString(R.string.dialysis_lotion) + "\n\n"+ getResources().getString(R.string.dialysis_text_four);
                break;
            case "VeinTextOne":
                message = getResources().getString(R.string.vein) + "\n\n"+ getResources().getString(R.string.vein_text_one);
                break;
            case "VeinTextTwo":
                message = getResources().getString(R.string.shaldon) + "\n\n"+ getResources().getString(R.string.vein_text_two);
                break;
            case "VeinTextThree":
                message = getResources().getString(R.string.fistula) + "\n\n"+ getResources().getString(R.string.vein_text_three);
                break;
            case "VeinTextFour":
                message = getResources().getString(R.string.fistula_learn) + "\n\n"+ getResources().getString(R.string.vein_text_four);
                break;
            case "VeinTextFive":
                message = getResources().getString(R.string.grapht) + "\n\n"+ getResources().getString(R.string.vein_text_five);
                break;
            case "NourishTextOne":
                message = getResources().getString(R.string.diet) + "\n\n"+  getResources().getString(R.string.nourish_text_one);
                break;
            case "NourishTextTwo":
                message = getResources().getString(R.string.food_pyramid) + "\n\n"+  getResources().getString(R.string.nourish_text_two);
                break;
            case "NourishTextThree":
                message = getResources().getString(R.string.calorie) + "\n\n"+  getResources().getString(R.string.nourish_text_three);
                break;
            case "NourishTextFour":
                message = getResources().getString(R.string.thin) + "\n\n"+  getResources().getString(R.string.nourish_text_four);
                break;
            case "NourishTextFive":
                message = getResources().getString(R.string.sweet) + "\n\n"+  getResources().getString(R.string.nourish_text_five);
                break;
            case "NourishTextSix":
                message = getResources().getString(R.string.fat) + "\n\n"+  getResources().getString(R.string.nourish_text_six);
                break;
            case "NourishTextSeven":
                message = getResources().getString(R.string.protein) + "\n\n"+  getResources().getString(R.string.nourish_text_seven);
                break;
            case "NourishTextEight":
                message = getResources().getString(R.string.sodium) + "\n\n"+  getResources().getString(R.string.nourish_text_eight);
                break;
            case "NourishTextNineOne":
                message = getResources().getString(R.string.potassium_what) + "\n\n"+  getResources().getString(R.string.nourish_text_nine_one);
                break;
            case "NourishTextNineTwo":
                message = getResources().getString(R.string.low_potassium) + "\n\n"+  getResources().getString(R.string.nourish_text_nine_two);
                break;
            case "NourishTextNineThree":
                message = getResources().getString(R.string.high_potassium) + "\n\n"+  getResources().getString(R.string.nourish_text_nine_three);
                break;
            case "NourishTextTenOne":
                message = getResources().getString(R.string.phosphorus_what) + "\n\n"+  getResources().getString(R.string.nourish_text_ten_one);
                break;
            case "NourishTextTenTwo":
                message = getResources().getString(R.string.phosphorus_material) + "\n\n"+  getResources().getString(R.string.nourish_text_ten_two);
                break;
            case "NourishTextTenThree":
                message = getResources().getString(R.string.high_phosphorus) + "\n\n"+  getResources().getString(R.string.nourish_text_ten_three);
                break;
            case "NourishTextExtraOne":
                message = getResources().getString(R.string.water) + "\n\n"+  getResources().getString(R.string.nourish_text_extra_one);
                break;
            case "NourishTextExtraTwo":
                message = getResources().getString(R.string.water_control) + "\n\n"+  getResources().getString(R.string.nourish_text_extra_two);
                break;
            case "NourishTextExtraThree":
                message = getResources().getString(R.string.vitamin) + "\n\n"+  getResources().getString(R.string.nourish_text_extra_three);
                break;
            case "NourishTextExtraFour":
                message = getResources().getString(R.string.diet_dialysis) + "\n\n"+  getResources().getString(R.string.nourish_text_extra_four);
                break;
            case "DrugTextOne":
                message = getResources().getString(R.string.calcitrol) + "\n\n"+  getResources().getString(R.string.drug_text_one);
                break;
            case "DrugTextTwo":
                message = getResources().getString(R.string.eritropotin) + "\n\n"+  getResources().getString(R.string.drug_text_two);
                break;
            case "DrugTextThree":
                message = getResources().getString(R.string.renazhel) + "\n\n"+  getResources().getString(R.string.drug_text_three);
                break;
            case "DrugTextFour":
                message = getResources().getString(R.string.venufer) + "\n\n"+  getResources().getString(R.string.drug_text_four);
                break;
            case "DrugTextFive":
                message = getResources().getString(R.string.carbon_calcium) + "\n\n"+  getResources().getString(R.string.drug_text_five);
                break;
            case "labValue":
                message = getResources().getString(R.string.lab_value) + "\n\n"+ getResources().getString(R.string.lab_text);
                break;
            case "sport":
                message = getResources().getString(R.string.sport_dialysis) + "\n\n"+ getResources().getString(R.string.sport_text);
                break;
            default:
                message = "دیالیز";
                break;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");

        Intent chooser = Intent.createChooser(intent, "به اشتراک گذاری:");
        if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null)
        {
            startActivity(chooser);
        }
    }
}
