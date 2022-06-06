package by.tms.sweater.storage;

import by.tms.sweater.model.Comment;
import by.tms.sweater.model.Post;
import by.tms.sweater.model.User;
import by.tms.sweater.model.UserRole;
import by.tms.sweater.service.UserService;

import java.util.ArrayList;
import java.util.List;
import static by.tms.sweater.constants.Constants.*;

public class PostStorage {

    private static final List<Post> posts = new ArrayList<>();

    public int getId() {
        return posts.size() + 1;
    }

    public String save(Post post) {
        posts.add(post);
        return String.valueOf(post);
    }

    public Post find(int idPost, String userName) {
        if (idPost <= 0) { return null; }
        for (Post post : posts) {
            if (post != null && post.getId() == idPost && post.getUserName().equals(userName)) {
                return post;
            }
        }
        return null;
    }

    public List<Post> getAll(String userName) {
        List<Post> postForUser = new ArrayList<>();
        UserService userService = new UserService();
        User user = userService.findUserByUserName(userName);

        if (user.getRole() == UserRole.ADMIN_ROLE) {
            return new ArrayList<>(posts); //все посты
        } else if (user.getRole() == UserRole.USER_ROLE) { //только то что ты сам сделал
            for (Post item : posts) {
                if (item.getUserName().equals(userName) && item.getValue()) {
                    postForUser.add(item);
                }
            }
        }
        return postForUser;
    }

    public String delete(int idPost, String userName) {
        for (Post post : posts) {
            if (idPost <= 0 && userName == null && post == null) {
                System.out.println(PRINT_CHECK_METHOD + "delete post");
            } else if (post.getId() == idPost) {
                posts.remove(idPost - 1);
                int index = 0;
                for (Post item : posts) {
                    posts.set(index, item);
                    index++;
                }
                return PRINT_DELETED;
            }
        }
        return null;
    }

    public void removeCommentByPost(int idPost, Comment comment, String userName) {
        for (Post post : posts) {
            if (idPost <= 0 && userName == null && post == null) {
                System.out.println(PRINT_CHECK_METHOD + "removeCommentByPost");
            } else if (post.getId() == idPost) {
                for (Comment item : post.getComments()) {
                    if (item.getId() == comment.getId() && comment.getId() > 0) {
                        post.getComments().remove(item);
                        return;
                    }
                }
            }
        }
    }

    public void addCommentByPost(int idPost, Comment comment) {
        for (Post post : posts) {
            if (idPost <= 0 && comment == null && post == null) {
                System.out.println("check the method = addCommentByIdInPost");
            } else if (post.getId() == idPost) {
                post.setComments(comment);
            }
        }
    }

    public String addLike(int idPost, User user) {
        for (Post post : posts) {
            if (idPost <= 0 && user == null && post == null) {
                System.out.println("check the method = deletePostById");
                return null;
            } else if (post.getId() == idPost) {
                post.setLike(user.getName());
                return user.getName();
            }
        }
        return null;
    }

    public String deleteLike(int idPost, User user) {
        for (Post post : posts) {
            if (idPost <= 0 && user == null && post == null) {
                System.out.println("check the method = deletePostById");
                return null;
            } else if (post.getId() == idPost) {
                for (String item : post.getLike()) {
                    if (item.equals(user.getName())) {
                        post.getLike().remove(item);
                        return "Deleted";
                    }
                }
            }
        }
        return null;
    }

}
