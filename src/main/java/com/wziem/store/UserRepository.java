package com.wziem.store;

public interface UserRepository {
    public void save(User user);
    public boolean contains(User user);
    public void showUsersList();
}
