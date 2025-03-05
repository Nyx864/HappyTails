package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.data.Pet;

import java.util.List;

import lombok.Setter;


public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.PetPreviewVewHolder> {

    List<Pet> pets;
    @Setter
    View.OnClickListener onItemClickListener;

    public PetListAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetPreviewVewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pet, parent, false);
        return new PetPreviewVewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetPreviewVewHolder holder, int position) {
        Pet pet = pets.get(position);

        holder.bind(pet);
        holder.container.setOnClickListener(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetPreviewVewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout container;
        ImageView petImage;
        TextView petName;

        public PetPreviewVewHolder(@NonNull View itemView) {
            super(itemView);

            container       = itemView.findViewById(R.id.petPreview);
            petImage        = itemView.findViewById(R.id.petPreviewImage);
            petName         = itemView.findViewById(R.id.petPreviewText);
        }

        public void bind(Pet pet) {
            petImage.setImageIcon(pet.getPfp());
            petName.setText(pet.getName());
        }
    }
}
