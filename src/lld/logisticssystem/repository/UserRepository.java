package lld.logisticssystem.repository;

import lld.logisticssystem.exceptions.InvalidInputException;
import lld.logisticssystem.model.User;

import java.util.Map;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Map<String, User> repository) {
        super(repository);
    }

    public void saveUser(User user) {
        if (user == null) {
            throw new InvalidInputException("Null user cannot be stored in repository");
        }
        this.addData(user.getId().toString(), user);
    }
}
