package ir.dyalysis.dialysis.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import ir.dyalysis.dialysis.Activity.InfoActivity;
import ir.dyalysis.dialysis.R;

public class KidneyFragment extends Fragment implements View.OnClickListener
{
    //Variables
    private CardView kidney;
    private CardView kidneyFunction;
    private CardView kidneyFailure;
    private CardView kidneyFailureMore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kidney, container, false);

        //Hooks
        kidney = view.findViewById(R.id.kidney);
        kidneyFunction = view.findViewById(R.id.kidneyFunction);
        kidneyFailure = view.findViewById(R.id.kidneyFailure);
        kidneyFailureMore = view.findViewById(R.id.kidneyFailureMore);

        //OnClick()
        kidney.setOnClickListener(this);
        kidneyFunction.setOnClickListener(this);
        kidneyFailure.setOnClickListener(this);
        kidneyFailureMore.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        Intent infoIntent = new Intent(Objects.requireNonNull(getActivity()).getApplicationContext(), InfoActivity.class);
        switch (v.getId())
        {
            case R.id.kidney:
                infoIntent.putExtra("name", "kidneyText");
                startActivity(infoIntent);
                break;
            case  R.id.kidneyFunction:
                infoIntent.putExtra("name", "kidneyTextTwo");
                startActivity(infoIntent);
                break;
            case R.id.kidneyFailure:
                infoIntent.putExtra("name", "kidneyTextThree");
                startActivity(infoIntent);
                break;
            case R.id.kidneyFailureMore:
                infoIntent.putExtra("name", "kidneyTextFour");
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }
}
