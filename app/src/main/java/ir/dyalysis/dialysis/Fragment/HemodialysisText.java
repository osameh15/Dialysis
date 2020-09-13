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

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.dyalysis.dialysis.AppService.SliderAdapter;
import ir.dyalysis.dialysis.AppService.SliderItem;
import ir.dyalysis.dialysis.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class HemodialysisText extends Fragment
{
    //Variables...
    private SliderView imageView;
    private List<SliderItem> sliderItems;
    private ImageView share;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hemodialysis, container, false);

        //Hooks
        imageView = view.findViewById(R.id.sliderView);
        textView = view.findViewById(R.id.textSlider);
        share = Objects.requireNonNull(getActivity()).findViewById(R.id.shareText);

        //slider
        sliderItems =new ArrayList<>();
        sliderPic();
        sliderShow();

        textView.setText(getResources().getString(R.string.dialysis_text_two));

        //share text method
        share.setOnClickListener(v ->
                shareText());

        return view;
    }

    //Slider image
    private void sliderShow()
    {
        imageView.setSliderAdapter(new SliderAdapter(Objects.requireNonNull(getActivity()).getApplicationContext(), sliderItems));
        imageView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageView.setSliderTransformAnimation(SliderAnimations.FANTRANSFORMATION);
        imageView.startAutoCycle();
    }
    private void sliderPic()
    {
        sliderItems.add(new SliderItem(R.drawable.pump));
        sliderItems.add(new SliderItem(R.drawable.mahlol));
        sliderItems.add(new SliderItem(R.drawable.air_shower));
        sliderItems.add(new SliderItem(R.drawable.heparin_pump));
    }

    //share text for friends
    private void shareText()
    {
        String message;
        message = getResources().getString(R.string.dialysis_machine) + "\n\n"+ getResources().getString(R.string.dialysis_text_two);
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
