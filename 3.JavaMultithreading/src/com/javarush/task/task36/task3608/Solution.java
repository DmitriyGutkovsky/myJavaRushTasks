package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();
        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        usersView.fireEventShowAllUsers();
        editUserView.setController(controller);
        controller.setEditUserView(editUserView);
        usersView.fireEventOpenUserEditForm(126l);
        editUserView.fireEventUserDeleted(124l);
        editUserView.fireEventUserChanged("Dima", 126, 10);
        usersView.fireEventShowDeletedUsers();
    }
}