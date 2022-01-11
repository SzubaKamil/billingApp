package com.company.services.impl;

import com.company.dao.IMeterDAO;
import com.company.model.Meter;
import com.company.services.IMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMeterServiceImpl implements IMeterService {

    @Autowired
    IMeterDAO meterDAO;

    @Override
    public boolean addMeter(Meter meter) {
        return this.meterDAO.addMeter(meter);
    }

    @Override
    public boolean updateValue(Meter meter) {
        return this.meterDAO.updateValue(meter);
    }

    @Override
    public List<Meter> getAllMeter() {
        return this.meterDAO.getAllMeter();
    }

    @Override
    public Meter getMeterByID(int id) {
        return meterDAO.getMeterByID(id);
    }

    @Override
    public Meter getMeterByUserId(int id) {
        return this.meterDAO.getMeterByUserId(id);
    }
}
