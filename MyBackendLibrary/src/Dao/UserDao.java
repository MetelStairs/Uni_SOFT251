/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.User;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface UserDao {
    public List<User> getUsers();
    public User getUser(String username);
    public boolean saveUser(User user);
    public boolean updateUser(User user);
    public boolean approveUser(String username, String by);
    public boolean deleteUser(String username);
    public User loginUser(String username,String password);
}
