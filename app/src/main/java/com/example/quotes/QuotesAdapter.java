package com.example.quotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quotes.model.Quote;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Ja on 2016-12-16.
 */

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.MyViewHolder> {

    private List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes){
        this.quotes = quotes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Quote quote = quotes.get(position);
        holder.content.setText("\"" + quote.getContent() + "\"");
        holder.author.setText(quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName());
        holder.favorite.setText("Favorite: " + String.valueOf(quote.isFavorite()));
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView content;
        public TextView author;
        public TextView favorite;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.quote_content);
            author = (TextView) itemView.findViewById(R.id.author_of_qoute);
            favorite = (TextView) itemView.findViewById(R.id.is_favorite);
        }
    }
}
