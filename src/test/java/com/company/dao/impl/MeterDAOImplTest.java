package com.company.dao.impl;

import com.company.model.Meter;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MeterDAOImplTest {

    @Test
    void getAllMeter() {
        MeterDAOImpl meterDAO = mock(MeterDAOImpl.class);
        when(meterDAO.getAllMeter()).thenReturn(metersMocData());
        MatcherAssert.assertThat(meterDAO.getAllMeter(), Matchers.hasSize(3));

        List<Meter> meters = meterDAO.getAllMeter();
        assertEquals(meters.get(0).getId(), 2);
        assertEquals(meters.get(0).getValue(), 5);
        assertEquals(meters.get(0).getUser_id(), 9);
    }

    @Test
    void getMeterByID() {
        MeterDAOImpl meterDAO = mock(MeterDAOImpl.class);
        when(meterDAO.getMeterByID(1)).thenReturn(meterMocData());

        Meter meter = meterDAO.getMeterByID(1);
        assertEquals(meter.getId(), 1);
        assertEquals(meter.getValue(), 10);
        assertEquals(meter.getUser_id(), 10);
    }

    @Test
    void getMeterByUserId() {
        MeterDAOImpl meterDAO = mock(MeterDAOImpl.class);
        when(meterDAO.getMeterByUserId(1)).thenReturn(meterMocData());

        Meter meter = meterDAO.getMeterByUserId(1);
        assertEquals(meter.getId(), 1);
        assertEquals(meter.getValue(), 10);
        assertEquals(meter.getUser_id(), 10);

    }

    private List<Meter> metersMocData(){
        List<Meter> meters = new ArrayList<>();
        meters.add(new Meter(2,5,9));
        meters.add(new Meter(3,8, 11));
        meters.add(new Meter(4,9, 12));
        return meters;
    }

    private Meter meterMocData(){
        return new Meter(1, 10, 10);
    }
}