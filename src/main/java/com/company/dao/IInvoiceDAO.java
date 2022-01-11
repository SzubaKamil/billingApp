package com.company.dao;

import com.company.model.Invoice;

import java.util.List;

public interface IInvoiceDAO {
    boolean addInvoice (Invoice invoice);
    List<Invoice> getInvoicesByMeterId(int meter_Id);
}
