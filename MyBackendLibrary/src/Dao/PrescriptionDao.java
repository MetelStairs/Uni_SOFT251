/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Prescription;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface PrescriptionDao {
    public List<Prescription> getPrescriptions();
    public boolean savePrescription(Prescription prescription);
}
