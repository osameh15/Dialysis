package ir.dyalysis.dialysis.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import ir.dyalysis.dialysis.Activity.InfoActivity;
import ir.dyalysis.dialysis.R;

public class DialysisFragment extends Fragment implements View.OnClickListener
{
    //Variables...
    private CardView hemodialysis;
    private CardView dialysisMachine;
    private CardView dialysisFilter;
    private CardView dialysisLotion;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialysis, container, false);

        //Hooks
        hemodialysis = view.findViewById(R.id.hemodialysis);
        dialysisMachine = view.findViewById(R.id.dialysisMachine);
        dialysisFilter = view.findViewById(R.id.dialysisFilter);
        dialysisLotion = view.findViewById(R.id.dialysisLotion);

        //OnClick()
        hemodialysis.setOnClickListener(this);
        dialysisMachine.setOnClickListener(this);
        dialysisFilter.setOnClickListener(this);
        dialysisLotion.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        Intent infoIntent = new Intent(Objects.requireNonNull(getActivity()).getApplicationContext(), InfoActivity.class);
        switch (v.getId())
        {
            case R.id.hemodialysis:
                infoIntent.putExtra("name", "dialysisText");
                startActivity(infoIntent);
                break;
            case  R.id.dialysisMachine:
                infoIntent.putExtra("name", "dialysisTextTwo");
                startActivity(infoIntent);
                break;
            case R.id.dialysisFilter:
                infoIntent.putExtra("name", "dialysisTextThree");
                startActivity(infoIntent);
                break;
            case R.id.dialysisLotion:
                infoIntent.putExtra("name", "dialysisTextFour");
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }
}
