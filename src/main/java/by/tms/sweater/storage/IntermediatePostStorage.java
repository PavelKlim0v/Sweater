package by.tms.sweater.storage;

import by.tms.sweater.model.Post;
import by.tms.sweater.model.User;
import by.tms.sweater.service.PostService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class IntermediatePostStorage {

    private static final HashMap<String, List<Post>> hashMap = new HashMap<>();
    private final PostService postService = new PostService();
    private List<Post> posts;

    public String addPostIntermediateStorage(User user, Post post) {
        if (user == null && post == null) {
            System.out.println(PRINT_CHECK_METHOD + "addPostIntermediateStorage");
            return null;
        }
        posts = hashMap.get(user.getName());

        if (posts == null) {
            posts = new ArrayList<>();
            post.setId(BEGINNING_VALUE);
            hashMap.put(user.getName(), posts);
            hashMap.get(user.getName()).add(post);
        } else {
            post.setId(posts.size() + 1);
            hashMap.get(user.getName()).add(post);
        }
        return String.valueOf(post);
    }

    public String editPostIntermediateStorage(int idPost, String text, String userName) {
        posts = hashMap.get(userName);
        if (idPost <= 0 && text == null && userName == null && posts == null) {
            System.out.println(PRINT_CHECK_METHOD + "editPostIntermediateStorage");
            return null;
        }
        for (Post item : posts) {
            if (item != null && item.getId() == idPost) {
                item.setText(text);
                return String.valueOf(item);
            }
        }
        return null;
    }

    public String deletePostIntermediateStorage(int idPost, String userName) {
        posts = hashMap.get(userName);
        if (idPost <= 0 && userName == null && posts == null) {
            System.out.println(PRINT_CHECK_METHOD + "deletePostIntermediateStorage");
            return null;
        }
        for (Post item : posts) {
            if (item != null && item.getId() == idPost) {
                postService.delete(idPost, userName);
                hashMap.get(userName).remove(item);
                return PRINT_DELETED;
            }
        }
        return null;
    }

}
