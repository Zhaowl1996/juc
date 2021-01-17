package cn.zhao.stream;

import cn.zhao.pojo.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zhaowl
 * @Date 2021/1/17 18:14
 * @Version 1.0
 * @Description Stream
 */
public class StreamDemo {

    public static void main(String[] args) {
        User user1 = new User("yuwl", 28, "003");
        User user2 = new User("wuyz", 22, "002");
        User user3 = new User("chengx", 32, "001");
        User user4 = new User("zhouxc", 37, "004");

        List<User> users = Arrays.asList(user1, user2, user3, user4);
        users.stream()
                .filter(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user.getAge() <= 50;
                })
                .sorted(Comparator.comparing(User::getNo))
                .limit(4)
                .forEach(System.out::println);
    }
}
