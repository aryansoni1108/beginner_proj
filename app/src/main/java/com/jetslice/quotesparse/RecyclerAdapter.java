package com.jetslice.quotesparse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements View.OnClickListener {
    private List<Quotes> QuoteList;
    private Context mContext;

    public static final String ARG_FROM_MAIN = "arg";
    public RecyclerAdapter(Context context, ArrayList<Quotes> arrayList) {
        this.mContext=context;
        this.QuoteList=arrayList;


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.MyViewHolder holder, final int position) {
        Quotes quotes = QuoteList.get(position);

        holder.quote.setText(quotes.getQuote());
        holder.quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("pos","psp"+position);
                Intent sendquote=new Intent(mContext,QuotesPlacer.class);
                sendquote.putExtra(ARG_FROM_MAIN,holder.quote.getText());
                mContext.startActivity(sendquote);

            }
        });



    }


    @Override
    public int getItemCount() {
        return QuoteList.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView quote;
        public MyViewHolder(View view){
            super(view);
            quote = (TextView) view.findViewById(R.id.quote_text_item);

        }
    }

}
