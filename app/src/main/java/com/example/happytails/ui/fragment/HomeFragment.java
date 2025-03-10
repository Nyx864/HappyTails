package com.example.happytails.ui.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.happytails.R;
import com.example.happytails.adapter.ArticleAdapter;
import com.example.happytails.adapter.CreatorAdapter;
import com.example.happytails.adapter.PostAdapter;
import com.example.happytails.listener.OnItemClickListener;
import com.example.happytails.data.model.Article;
import com.example.happytails.data.model.Comment;
import com.example.happytails.data.model.Like;
import com.example.happytails.data.model.Post;
import com.example.happytails.data.model.Share;
import com.example.happytails.data.model.User;
import com.example.happytails.databinding.FragmentHomeBinding;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        setupArticleList();
        setupPostsList();

        return binding.getRoot();
    }

    private void setupArticleList() {
        List<Article> articles = getArticles();
        ArticleAdapter adapter = new ArticleAdapter(articles);
        adapter.setOnItemClickListener((view, data) -> navigateToTipFragment());
        binding.eventsRV.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.eventsRV.setLayoutManager(layoutManager);
    }

    private List<Article> getArticles() {
        Icon defaultIcon = Icon.createWithResource(getContext(), R.drawable.ic_launcher_background);
        return Arrays.asList(
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null),
                new Article(defaultIcon, "asdasd", "21312312312adasd", null)
        );
    }

    private void setupPostsList() {
        List<Post> posts = getPosts();
        PostAdapter adapter = new PostAdapter(posts);
        binding.postsRV.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.postsRV.setLayoutManager(layoutManager);

        adapter.setOnCreatorsClickListener((view, data) -> {
            Post post = (Post) data;
            if (post.getCreators().size() == 1) {
                navigateToPetFragment();
            } else {
                PopupWindow creatorList = createCreatorListPopup(view);
                setupCreatorList(
                        creatorList.getContentView(),
                        post.getCreators(),
                        (v, d) -> {
                            creatorList.dismiss();
                            navigateToPetFragment();
                        }
                );
            }
        });
        adapter.setOnCommentClickListener((view, data) -> navigateToPostFragment());
    }

    private PopupWindow createCreatorListPopup(View v) {
        View popupView = LayoutInflater.from(v.getContext())
                .inflate(R.layout.popup_creators_list, null);

        PopupWindow creatorList = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true
        );

        creatorList.setElevation(20);
        creatorList.setOutsideTouchable(true);
        creatorList.showAsDropDown(v);

        return creatorList;
    }

    private void setupCreatorList(View v, List<User> creators, OnItemClickListener listener) {
        RecyclerView creatorRV = v.findViewById(R.id.creatorRV);

        CreatorAdapter adapter = new CreatorAdapter(creators);
        adapter.setOnItemClickListener(listener);
        creatorRV.setAdapter(adapter);
        creatorRV.setLayoutManager(new LinearLayoutManager(v.getContext()));
    }

    private List<Post> getPosts() {
        Icon homeImageIcon = Icon.createWithResource(getContext(), R.drawable.home_image_chosen);
        Icon appBgIcon = Icon.createWithResource(getContext(), R.drawable.ic_launcher_background);

        return Arrays.asList(
                createPost(homeImageIcon, appBgIcon),
                createPost(homeImageIcon, appBgIcon),
                createPost(homeImageIcon, appBgIcon),
                createPost(homeImageIcon, appBgIcon)
        );
    }

    private Post createPost(Icon contentIcon, Icon userIcon) {
        List<User> creators = Arrays.asList(
                new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd"),
                new User("bob", contentIcon, "asdasd", "asdad", User.Gender.Male, "asdasd"),
                new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd"),
                new User("bob", userIcon, "asdasd", "asdad", User.Gender.Male, "asdasd"),
                new User("bob", userIcon, "asdasd", "asdad", User.Gender.Female, "asdasd")
        );

        List<Like> likes = Arrays.asList(
                new Like(null, null), new Like(null, null), new Like(null, null), new Like(null, null), new Like(null, null)
        );

        List<Comment> comments = Arrays.asList(
                new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now()),
                new Comment(null, null, null, 0, LocalDateTime.now()), new Comment(null, null, null, 0, LocalDateTime.now())
        );

        List<Share> shares = Arrays.asList(
                new Share(null, null), new Share(null, null), new Share(null, null), new Share(null, null), new Share(null, null)
        );

        return new Post(creators, contentIcon, "sadjasldjasldjal", likes, comments, shares);
    }

    private void navigateToPetFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_homeFragment_to_petFragment2);
    }

    private void navigateToPostFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_homeFragment_to_postFragment);
    }

    private void navigateToTipFragment() {
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_homeFragment_to_tipFragment2);
    }
}