package com.example.softexpertdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.softexpertdemo.Model.Car;

import java.util.List;

public class Adapter extends
        RecyclerView.Adapter<Adapter.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final List<Car> cars;
    private final Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView brand;
        public TextView year;
        public TextView isUsed;
        public ImageView carImage;
        public ConstraintLayout constraintLayout;
        public View layout;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            layout = itemView;
            brand = itemView.findViewById(R.id.brand);
            year = itemView.findViewById(R.id.year);
            isUsed = itemView.findViewById(R.id.isUsed);
            carImage = itemView.findViewById(R.id.imageView);

        }
    }
    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    public Adapter (Context _context,List<Car> _cars){
        cars = _cars;
        context = _context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.car_row,recyclerView,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
        }
        else {
            LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
            View v = inflater.inflate(R.layout.item_loading,recyclerView,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            holder.brand.setText(cars.get(position).getBrand());
            String constractionYear = cars.get(position).getConstractionYear();
            if (constractionYear == null) {
                holder.year.setText("Not Determined");
            } else {
                holder.year.setText(cars.get(position).getConstractionYear());

            }
            boolean ifUsed = cars.get(position).getUsed();
            if (ifUsed) {
                holder.isUsed.setText("Used");
            } else {
                holder.isUsed.setText("Not Used");

            }

            Glide.with(context).load(cars.get(position).getImageUrl()).apply(new RequestOptions().override(130, 90)
                    .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)).into(holder.carImage);
        }

    }
    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
        //ProgressBar would be displayed

    }


    @Override
    public int getItemCount() {
        return cars == null ? 0 : cars.size();

    }

    public int getItemViewType(int position) {
        return cars.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
}
