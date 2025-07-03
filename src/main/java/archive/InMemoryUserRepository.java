package archive;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class InMemoryUserRepository implements UserRepository{
    public HashMap<String, User> repository = new HashMap<>();

    @Override
    public void save(User user){
        System.out.println("User saved: " + user);
        repository.put(user.getEmail(), user);
    }

    @Override
    public boolean contains(User user){
        return repository.containsKey(user.getEmail());
    }

    @Override
    public void showUsersList(){
        repository.forEach((k, v) -> System.out.println(v.toString()));
    }
}
