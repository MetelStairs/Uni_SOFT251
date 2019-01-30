/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Feedback;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface FeedbackDao {
    public List<Feedback> getFeedBack();
    public boolean saveFeedBack(Feedback feedback);
}
