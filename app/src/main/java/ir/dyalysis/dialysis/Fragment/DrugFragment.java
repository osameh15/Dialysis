package ir.dyalysis.dialysis.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import ir.dyalysis.dialysis.Activity.InfoActivity;
import ir.dyalysis.dialysis.R;

public class DrugFragment extends Fragment implements View.OnClickListener
{
    //Variables
    private CardView calcitrol;
    private CardView eprex;
    private CardView renazhel;
    private CardView venofer;
    private CardView carbonCalcium;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drug, container, false);

        //Hooks
        calcitrol = view.findViewById(R.id.calcitrol);
        eprex = view.findViewById(R.id.eritropotin);
        renazhel = view.findViewById(R.id.renazhel);
        venofer = view.findViewById(R.id.venufer);
        carbonCalcium = view.findViewById(R.id.carbonCalcium);

        //OnClick()
        calcitrol.setOnClickListener(this);
        eprex.setOnClickListener(this);
        renazhel.setOnClickListener(this);
        venofer.setOnClickListener(this);
        carbonCalcium.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        Intent infoIntent = new Intent(Objects.requireNonNull(getActivity()).getApplicationContext(), InfoActivity.class);
        switch (v.getId())
        {
            case R.id.calcitrol:
                infoIntent.putExtra("name", "DrugTextOne");
                startActivity(infoIntent);
                break;
            case  R.id.eritropotin:
                infoIntent.putExtra("name", "DrugTextTwo");
                startActivity(infoIntent);
                break;
            case R.id.renazhel:
                infoIntent.putExtra("name", "DrugTextThree");
                startActivity(infoIntent);
                break;
            case R.id.venufer:
                infoIntent.putExtra("name", "DrugTextFour");
                startActivity(infoIntent);
                break;
            case R.id.carbonCalcium:
                infoIntent.putExtra("name", "DrugTextFive");
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }
}
