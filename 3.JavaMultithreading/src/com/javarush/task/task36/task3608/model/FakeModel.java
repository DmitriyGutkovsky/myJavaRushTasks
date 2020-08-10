package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> loadUsers = new ArrayList<>();
        loadUsers.add(new User("A", 1, 1));
        loadUsers.add(new User("B", 2, 1));
        modelData.setUsers(loadUsers);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();

    }
}
