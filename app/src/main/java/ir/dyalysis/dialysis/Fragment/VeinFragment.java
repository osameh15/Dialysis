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

public class VeinFragment extends Fragment implements View.OnClickListener
{
    //Variables
    private CardView veinCard;
    private CardView shaldonCard;
    private CardView fistulaCard;
    private CardView fistulaLearnCard;
    private CardView graphtCard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vein, container, false);

        //Hooks
        veinCard = view.findViewById(R.id.veinAccess);
        shaldonCard = view.findViewById(R.id.shaldon);
        fistulaCard = view.findViewById(R.id.fistula);
        fistulaLearnCard = view.findViewById(R.id.fistulaLearn);
        graphtCard = view.findViewById(R.id.grapht);

        //OnClick()
        veinCard.setOnClickListener(this);
        shaldonCard.setOnClickListener(this);
        fistulaCard.setOnClickListener(this);
        fistulaLearnCard.setOnClickListener(this);
        graphtCard.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        Intent infoIntent = new Intent(Objects.requireNonNull(getActivity()).getApplicationContext(), InfoActivity.class);
        switch (v.getId())
        {
            case R.id.veinAccess:
                infoIntent.putExtra("name", "VeinTextOne");
                startActivity(infoIntent);
                break;
            case  R.id.shaldon:
                infoIntent.putExtra("name", "VeinTextTwo");
                startActivity(infoIntent);
                break;
            case R.id.fistula:
                infoIntent.putExtra("name", "VeinTextThree");
                startActivity(infoIntent);
                break;
            case R.id.fistulaLearn:
                infoIntent.putExtra("name", "VeinTextFour");
                startActivity(infoIntent);
                break;
            case R.id.grapht:
                infoIntent.putExtra("name", "VeinTextFive");
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }
}
