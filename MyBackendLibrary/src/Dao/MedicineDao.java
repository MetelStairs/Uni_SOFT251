/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Medicine;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface MedicineDao {
    
    public List<Medicine> getMedicines();
    public boolean saveMedicine(Medicine medicine);
    public boolean stockMedicine(Medicine medicine);
}
