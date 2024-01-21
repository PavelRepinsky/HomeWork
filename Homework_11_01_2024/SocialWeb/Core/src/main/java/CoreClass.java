import java.util.HashMap;
import java.util.List;

public class CoreClass implements CoreInterface, FriendsInterface {

    @Override
    public HashMap<String, String> userProfile() {
        return null;
    }

    @Override
    public HashMap<String, String> updateProfile() {
        return null;
    }

    @Override
    public void deleteProfile() {

    }

    @Override
    public void addFriend(String name) {
        System.out.println(name + " добавлен в ваш список друзей!");
    }

    @Override
    public void removeFriend(String name) {
        System.out.println(name + " удалён из вашего списка друзей!");
    }

    @Override
    public List<String> getFriends() {
        return null;
    }
}
