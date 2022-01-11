package com.company.dao;

import com.company.model.Meter;

import java.util.List;

public interface IMeterDAO {
    boolean addMeter (Meter meter);
    boolean updateValue (Meter meter);
    List<Meter> getAllMeter ();
    Meter getMeterByID (int id);
    Meter getMeterByUserId (int id);
}
