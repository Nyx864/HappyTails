package com.example.happytails.UI;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.R;
import com.example.happytails.adapter.EventAdapter;
import com.example.happytails.adapter.PostAdapter;
import com.example.happytails.data.Comment;
import com.example.happytails.data.Event;
import com.example.happytails.data.Like;
import com.example.happytails.data.Post;
import com.example.happytails.data.Share;
import com.example.happytails.databinding.FragmentHomeBinding;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        List<Event> list = Arrays.asList(
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()),
                new Event(null, "asdasd", "21312312312adasd", LocalDateTime.now()));
        binding.eventsRV.setAdapter(new EventAdapter(list));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.eventsRV.setLayoutManager(layoutManager);

        List<Post> posts = Arrays.asList(
                new Post(null,
                Icon.createWithResource(getContext(), R.drawable.home_image_chosen),
                "sadjasldjasldjal",
                Arrays.asList(new Like(null, null),
                        new Like(null, null),
                        new Like(null, null),
                        new Like(null, null),
                        new Like(null, null)),
                Arrays.asList(new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0),
                        new Comment(null, null, null, 0)),
                Arrays.asList(new Share(null, null),
                        new Share(null, null),
                        new Share(null, null),
                        new Share(null, null),
                        new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))),

                new Post(null,
                        Icon.createWithResource(getContext(), R.drawable.profile_image_chosen),
                        "sadjasldjasldjal",
                        Arrays.asList(new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null),
                                new Like(null, null)),
                        Arrays.asList(new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0),
                                new Comment(null, null, null, 0)),
                        Arrays.asList(new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null),
                                new Share(null, null))));
        binding.postsRV.setAdapter(new PostAdapter(posts));
        binding.postsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }
}