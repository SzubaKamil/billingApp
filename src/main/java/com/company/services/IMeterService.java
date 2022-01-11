package com.company.services;

import com.company.model.Meter;
import java.util.List;

public interface IMeterService {
    boolean addMeter (Meter meter);
    boolean updateValue (Meter meter);
    List<Meter> getAllMeter ();
    public Meter getMeterByID(int id);
    Meter getMeterByUserId (int id);
}
