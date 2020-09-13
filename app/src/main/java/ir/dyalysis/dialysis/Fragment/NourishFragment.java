package ir.dyalysis.dialysis.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import ir.dyalysis.dialysis.Activity.InfoActivity;
import ir.dyalysis.dialysis.R;

public class NourishFragment extends Fragment implements View.OnClickListener
{
    //Variables
    private CardView dietCard;
    private CardView foodPyramidCard;
    private CardView calorieCard;
    private CardView thinCard;
    private CardView sweetCard;
    private CardView fatCard;
    private CardView proteinCard;
    private CardView sodiumCard;
    private CardView potassiumCard;
    private CardView potassiumOneCard;
    private CardView potassiumTwoCard;
    private CardView potassiumThreeCard;
    private CardView phosphorusCard;
    private CardView phosphorusOneCard;
    private CardView phosphorusTwoCard;
    private CardView phosphorusThreeCard;
    private CardView waterCard;
    private CardView waterControlCard;
    private CardView vitaminCard;
    private CardView dietDialysisCard;
    private LinearLayout potassiumLayout;
    private LinearLayout phosphorusLayout;
    private ImageView potassiumImage;
    private ImageView phosphorusImage;
    private boolean potassiumFlag = false;
    private boolean phosphorusFlag = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nourish, container, false);

        //Hooks
        dietCard = view.findViewById(R.id.diet);
        foodPyramidCard = view.findViewById(R.id.foodPyramid);
        calorieCard = view.findViewById(R.id.calorie);
        thinCard = view.findViewById(R.id.thin);
        sweetCard = view.findViewById(R.id.sweet);
        fatCard = view.findViewById(R.id.fat);
        proteinCard = view.findViewById(R.id.protein);
        sodiumCard = view.findViewById(R.id.sodium);
        potassiumCard = view.findViewById(R.id.Potassium);
        potassiumOneCard = view.findViewById(R.id.PotassiumWhat);
        potassiumTwoCard = view.findViewById(R.id.lowPotassium);
        potassiumThreeCard = view.findViewById(R.id.highPotassium);
        phosphorusCard = view.findViewById(R.id.phosphorus);
        phosphorusOneCard = view.findViewById(R.id.phosphorusWhat);
        phosphorusTwoCard = view.findViewById(R.id.phosphorusMaterial);
        phosphorusThreeCard = view.findViewById(R.id.highPhosphorus);
        potassiumLayout = view.findViewById(R.id.PotassiumLinearLayout);
        phosphorusLayout = view.findViewById(R.id.phosphorusLinearLayout);
        potassiumImage = view.findViewById(R.id.potassiumArrow);
        phosphorusImage = view.findViewById(R.id.phosphorusArrow);
        waterCard = view.findViewById(R.id.water);
        waterControlCard = view.findViewById(R.id.waterControl);
        vitaminCard = view.findViewById(R.id.vitamin);
        dietDialysisCard = view.findViewById(R.id.dietDialysis);

        //OnClick()
        dietCard.setOnClickListener(this);
        foodPyramidCard.setOnClickListener(this);
        calorieCard.setOnClickListener(this);
        thinCard.setOnClickListener(this);
        sweetCard.setOnClickListener(this);
        fatCard.setOnClickListener(this);
        proteinCard.setOnClickListener(this);
        sodiumCard.setOnClickListener(this);
        potassiumCard.setOnClickListener(this);
        potassiumOneCard.setOnClickListener(this);
        potassiumTwoCard.setOnClickListener(this);
        potassiumThreeCard.setOnClickListener(this);
        phosphorusCard.setOnClickListener(this);
        phosphorusOneCard.setOnClickListener(this);
        phosphorusTwoCard.setOnClickListener(this);
        phosphorusThreeCard.setOnClickListener(this);
        waterCard.setOnClickListener(this);
        waterControlCard.setOnClickListener(this);
        vitaminCard.setOnClickListener(this);
        dietDialysisCard.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        Intent infoIntent = new Intent(Objects.requireNonNull(getActivity()).getApplicationContext(), InfoActivity.class);
        switch (v.getId())
        {
            case R.id.diet:
                infoIntent.putExtra("name", "NourishTextOne");
                startActivity(infoIntent);
                break;
            case R.id.foodPyramid:
                infoIntent.putExtra("name", "NourishTextTwo");
                startActivity(infoIntent);
                break;
            case R.id.calorie:
                infoIntent.putExtra("name", "NourishTextThree");
                startActivity(infoIntent);
                break;
            case R.id.thin:
                infoIntent.putExtra("name", "NourishTextFour");
                startActivity(infoIntent);
                break;
            case R.id.sweet:
                infoIntent.putExtra("name", "NourishTextFive");
                startActivity(infoIntent);
                break;
            case R.id.fat:
                infoIntent.putExtra("name", "NourishTextSix");
                startActivity(infoIntent);
                break;
            case R.id.protein:
                infoIntent.putExtra("name", "NourishTextSeven");
                startActivity(infoIntent);
                break;
            case R.id.sodium:
                infoIntent.putExtra("name", "NourishTextEight");
                startActivity(infoIntent);
                break;
            case R.id.Potassium:
                if(!potassiumFlag)
                {
                    potassiumLayout.setVisibility(View.VISIBLE);
                    potassiumImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less_black_24dp));
                    potassiumFlag = true;
                }
                else
                {
                    potassiumLayout.setVisibility(View.GONE);
                    potassiumImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more_black_24dp));
                    potassiumFlag = false;
                }
                break;
            case R.id.PotassiumWhat:
                infoIntent.putExtra("name", "NourishTextNineOne");
                startActivity(infoIntent);
                break;
            case R.id.lowPotassium:
                infoIntent.putExtra("name", "NourishTextNineTwo");
                startActivity(infoIntent);
                break;
            case R.id.highPotassium:
                infoIntent.putExtra("name", "NourishTextNineThree");
                startActivity(infoIntent);
                break;
            case R.id.phosphorus:
                if(!phosphorusFlag)
                {
                    phosphorusLayout.setVisibility(View.VISIBLE);
                    phosphorusImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less_black_24dp));
                    phosphorusFlag = true;
                }
                else
                {
                    phosphorusLayout.setVisibility(View.GONE);
                    phosphorusImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more_black_24dp));
                    phosphorusFlag = false;
                }
                break;
            case R.id.phosphorusWhat:
                infoIntent.putExtra("name", "NourishTextTenOne");
                startActivity(infoIntent);
                break;
            case R.id.phosphorusMaterial:
                infoIntent.putExtra("name", "NourishTextTenTwo");
                startActivity(infoIntent);
                break;
            case R.id.highPhosphorus:
                infoIntent.putExtra("name", "NourishTextTenThree");
                startActivity(infoIntent);
                break;
            case R.id.water:
                infoIntent.putExtra("name", "NourishTextExtraOne");
                startActivity(infoIntent);
                break;
            case R.id.waterControl:
                infoIntent.putExtra("name", "NourishTextExtraTwo");
                startActivity(infoIntent);
                break;
            case R.id.vitamin:
                infoIntent.putExtra("name", "NourishTextExtraThree");
                startActivity(infoIntent);
                break;
            case R.id.dietDialysis:
                infoIntent.putExtra("name", "NourishTextExtraFour");
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }
}
