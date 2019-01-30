/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Rating;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface RatingDao {
    public List<Rating> getRatings();
    public boolean saveRating(Rating rating);
    public boolean deletRating(String user, String doctor);
}
