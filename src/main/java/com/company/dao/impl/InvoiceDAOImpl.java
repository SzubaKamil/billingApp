package com.company.dao.impl;

import com.company.dao.IInvoiceDAO;
import com.company.model.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceDAOImpl  extends UpgradeDb implements IInvoiceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addInvoice(Invoice invoice) {
        return save(invoice);
    }

    @Override
    public List<Invoice> getInvoicesByMeterId(int meter_id) {
        Session session = this.sessionFactory.openSession();
        Query<Invoice> query = session.createQuery("FROM com.company.model.Invoice WHERE meter_id = :meter_id");
        query.setParameter("meter_id", meter_id );
        List<Invoice> invoices = query.getResultList();
        session.close();
        return invoices;
    }
}
