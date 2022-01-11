package com.company.services.impl;

import com.company.dao.IInvoiceDAO;
import com.company.model.Invoice;
import com.company.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IInvoiceServiceImpl implements IInvoiceService {

    @Autowired
    IInvoiceDAO invoiceDAO;

    @Override
    public boolean addInvoice(Invoice invoice) {
        return this.invoiceDAO.addInvoice(invoice);
    }

    @Override
    public List<Invoice> getInvoicesByMeterId(int meterId) {
        return this.invoiceDAO.getInvoicesByMeterId(meterId);
    }
}
