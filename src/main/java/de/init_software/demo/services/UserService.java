package de.init_software.demo.services;

import de.init_software.demo.data.UserEntity;
import de.init_software.demo.model.UserModel;
import java.util.List;

public interface UserService {
  UserModel getUser(String userName);
  void addUser(UserModel userName );
  void delUser(String userName);

  List<UserModel> getAllUsers();
}
