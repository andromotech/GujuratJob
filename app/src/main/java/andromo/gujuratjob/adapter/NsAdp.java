package andromo.gujuratjob.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import andromo.gujuratjob.NsDisplay;
import andromo.gujuratjob.R;
import andromo.gujuratjob.model.NsModel;


public class NsAdp extends RecyclerView.Adapter<NsAdp.MyViewHolder> {

    private Context mContext;
    private List<NsModel> spllist;

    public NsAdp(Context mContext, List<NsModel> spllist) {
        this.mContext = mContext;
        this.spllist = spllist;
    }

    @Override
    public NsAdp.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cv, viewGroup, false);

        return new NsAdp.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NsAdp.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(spllist.get(i).getName());
        Picasso.with(mContext)
                .load(spllist.get(i).getPic())
                .placeholder(R.drawable.as)
                .into(viewHolder.cpic);

    }

    @Override
    public int getItemCount() {
        return spllist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView cpic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            // count = (TextView) view.findViewById(R.id.count);
//            Typeface ofont = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/odia.ttf");
  //          title.setTypeface(ofont);
            cpic = (ImageView) view.findViewById(R.id.jpic);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        NsModel clickedDataItem = spllist.get(pos);
                        String url = spllist.get(pos).getUrl();
                        Intent intent = new Intent(mContext, NsDisplay.class);
                        intent.putExtra("url", spllist.get(pos).getUrl());
                        intent.putExtra("pic", spllist.get(pos).getPic());
                        intent.putExtra("name", spllist.get(pos).getName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}