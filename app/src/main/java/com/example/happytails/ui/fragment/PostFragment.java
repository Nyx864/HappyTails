package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happytails.R;
import com.example.happytails.adapter.CommentAdapter;
import com.example.happytails.adapter.PostAdapter;
import com.example.happytails.data.model.Comment;
import com.example.happytails.data.model.Like;
import com.example.happytails.data.model.Post;
import com.example.happytails.data.model.Share;
import com.example.happytails.data.model.User;
import com.example.happytails.databinding.FragmentPostBinding;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PostFragment extends Fragment {

    private FragmentPostBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostBinding.inflate(inflater, container, false);

        setupCommentList();
        setupPost();

        return binding.getRoot();
    }

    private void setupCommentList() {
        List<Comment> comments = getComments();

        CommentAdapter adapter = new CommentAdapter(comments);
        adapter.setOnItemClickListener((view, data) -> {

        });
        binding.commentRV.setAdapter(adapter);
        binding.commentRV.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupPost() {
        Post post = getComment().getPost();
        PostAdapter.PostViewHolder holder
                = new PostAdapter.PostViewHolder(binding.post.getRoot());
        holder.bind(post);
    }

    private List<Comment> getComments() {
        return Arrays.asList(
                getComment(),
                getComment(),
                getComment(),
                getComment()
        );
    }

    private Comment getComment() {
        Icon userIcon = Icon.createWithResource(getContext(), R.drawable.ic_launcher_background);
        return new Comment(new User(
                "bob",
                Icon.createWithResource(getContext(), R.drawable.ic_launcher_background),
                null,
                null,
                null,
                null),
                new Post(Arrays.asList(
                        new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd"),
                        new User("bob", userIcon, "asdasd", "asdad", User.Gender.Male, "asdasd"),
                        new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd"),
                        new User("bob", userIcon, "asdasd", "asdad", User.Gender.Male, "asdasd"),
                        new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd")
                ),
                        Icon.createWithResource(getContext(), R.drawable.home_image_chosen), "sadjasldjasldjal", Arrays.asList(
                        new Like(null, null), new Like(null, null), new Like(null, null), new Like(null, null), new Like(null, null)
                ), Arrays.asList(
                        new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                        new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                        new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                        new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                        new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now())
                ), Arrays.asList(
                        new Share(null, null), new Share(null, null), new Share(null, null), new Share(null, null), new Share(null, null)
                )),
                "sjdlasjldjsalkdjasljdlsajldjasldjasljdlaskjdlsakjdlaj",
                32,
                LocalDateTime.now()
        );
    }
}