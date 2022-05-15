package random;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * To implement use of gson
 */
public class JsonParsingSample {
    public static void main(String[] args) {
        Gson gson = new Gson();
        User user1 = new User("1", "neha");
        User user2 = new User("2", "parth");

        String jsonStr1 = gson.toJson(user1);
        String jsonStr2 = gson.toJson(user2);

        System.out.println(jsonStr1);
        System.out.println(jsonStr2);

        user1.setName("neha dua");
        user2.setName("parth savjani");

        user1 = gson.fromJson(gson.toJson(user1), User.class);
        user2 = gson.fromJson(gson.toJson(user2), User.class);

        System.out.println(user1);
        System.out.println(user2);
    }

}

@Getter
@Setter
@ToString
//@NoArgsConstructor
class User {

    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
