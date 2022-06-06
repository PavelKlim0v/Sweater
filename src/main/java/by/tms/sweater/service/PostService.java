package by.tms.sweater.service;

import by.tms.sweater.model.Comment;
import by.tms.sweater.model.Post;
import by.tms.sweater.model.User;
import by.tms.sweater.storage.PostStorage;
import java.util.ArrayList;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class PostService {

    private static final PostStorage postStorage = new PostStorage();
    private Post post;

    public int getId() {
        return postStorage.getId();
    }

    public String create(int id, String userName, String text) {
        if (id <= 0 && userName == null && userName.equals("") && text == null && text.equals("")) {
            return null;
        }
        post = new Post(id, userName, text, new ArrayList<>(), new ArrayList<>(), false);
        return postStorage.save(post);
    }

    public Post find(int id, String userName) {
        return postStorage.find(id, userName);
    }

    public List<Post> findAll(String userName) {
        return postStorage.getAll(userName);
    }

    public String delete(int id, String userName) {
        return postStorage.delete(id, userName);
    }

    public void addCommentByPost(int idPost, Comment comment) {
        postStorage.addCommentByPost(idPost, comment);
    }

    public void removeCommentByPost(int idPost, Comment comment, String userName) {
        postStorage.removeCommentByPost(idPost, comment, userName);
    }

    public String addLike(int idPost, User user) {
        return postStorage.addLike(idPost, user);
    }

    public String deleteLike(int idPost, User user) {
        return postStorage.deleteLike(idPost, user);
    }

    public String checkPublish(int idPost, String userName) {
        post = postStorage.find(idPost, userName);
        if (post != null) {
            post.setValue(true);
            return PRINT_PUBLISH;
        }
        return (PRINT_ERROR + PRINT_PUBLISH);
    }

}


