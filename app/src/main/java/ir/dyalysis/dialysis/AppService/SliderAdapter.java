package ir.dyalysis.dialysis.AppService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import ir.dyalysis.dialysis.R;

public class SliderAdapter extends SliderViewAdapter<SliderViewHolder>
{

    //Variables
    private Context context;
    private List<SliderItem> sliderItemsList;

    //Constructor
    public SliderAdapter(Context context, List<SliderItem> sliderItemsList)
    {
        this.context = context;
        this.sliderItemsList = sliderItemsList;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position)
    {
        viewHolder.imageView.setImageResource(sliderItemsList.get(position).getImage());
    }

    @Override
    public int getCount()
    {
        return sliderItemsList.size();
    }
}

//Get Item in layout
class SliderViewHolder extends SliderViewAdapter.ViewHolder
{
    ImageView imageView;
    SliderViewHolder(View itemView)
    {
        super(itemView);
        imageView = itemView.findViewById(R.id.hemodialysis_image_slider);
    }
}
