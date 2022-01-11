package com.company.services;

import com.company.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    boolean addInvoice (Invoice invoice);
    List<Invoice> getInvoicesByMeterId(int meterId);
}
