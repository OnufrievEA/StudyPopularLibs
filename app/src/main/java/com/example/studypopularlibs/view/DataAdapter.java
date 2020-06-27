package com.example.studypopularlibs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studypopularlibs.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

        public void setOnClickListener(final Listener listener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Получаем позицию адаптера
                    int adapterPosition = getAbsoluteAdapterPosition();
                    // Проверяем ее на корректность
                    if (adapterPosition == RecyclerView.NO_POSITION) return;
                    listener.onClick(adapterPosition);
                }
            });
        }
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_card, parent, false);
        ViewHolder vh = new ViewHolder(cv);
        if (listener != null) {
            vh.setOnClickListener(listener);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        ((ImageView) holder.cardView.findViewById(R.id.picture)).setImageResource(R.drawable.sunset);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
