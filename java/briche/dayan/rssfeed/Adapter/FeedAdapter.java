package briche.dayan.rssfeed.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import briche.dayan.rssfeed.Interface.ItemClickListener;
import briche.dayan.rssfeed.Model.RSSObject;
import briche.dayan.rssfeed.R;

/**
 * Created by Dayan on 18/10/2017.
 */

class FeedViewHoler extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

    public TextView txtTitle, txtPubDate, txtContent;
    private ItemClickListener itemClickListener;

    public FeedViewHoler(View itemView) {
        super(itemView);

        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        txtPubDate = (TextView)itemView.findViewById(R.id.txtPubDate);
        txtContent = (TextView)itemView.findViewById(R.id.txtContent);

        // Set Event
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition(), false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);

        return true;
    }
}

public class FeedAdapte extends RecyclerView.Adapter<FeedViewHoler> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;


    public FeedAdapte(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHoler holder, int position) {

        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.txtContent.setText(rssObject.getItems().get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
