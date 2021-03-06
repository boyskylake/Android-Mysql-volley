package site.skylake.project_cs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adepter extends RecyclerView.Adapter<Adepter.viewHolder> {

    private Context mContext;
    private ArrayList<Item> mExList;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setmListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    public Adepter (Context context, ArrayList<Item> exlist){
        mContext = context;
        mExList = exlist;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        Item currentItem = mExList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorname = currentItem.getMname();
        String sumscore = currentItem.getmScore();
//        String mid = currentItem.getMid();

        holder.mname.setText(creatorname);
        holder.mscore.setText("Score : "+sumscore);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mExList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mname;
        public TextView mscore;

        public viewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.img_view);
            mname = itemView.findViewById(R.id.name);
            mscore = itemView.findViewById(R.id.score);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
