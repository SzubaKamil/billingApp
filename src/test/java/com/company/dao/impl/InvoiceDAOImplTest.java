package com.company.dao.impl;

import com.company.model.Invoice;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvoiceDAOImplTest {

    @Test
    void getInvoicesByMeterId() {
        InvoiceDAOImpl invoiceDAO = mock(InvoiceDAOImpl.class);
        when(invoiceDAO.getInvoicesByMeterId(2)).thenReturn(invoiceMocData_Id_2());
        MatcherAssert.assertThat(invoiceDAO.getInvoicesByMeterId(2), Matchers.hasSize(2));

        List<Invoice> invoices = invoiceDAO.getInvoicesByMeterId(2);
        assertEquals(invoices.get(0).getPrice(), 10);
    }

    private List<Invoice> invoiceMocData_Id_2(){
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setPrice(10);
        invoiceList.add(invoice);

        Invoice invoice2 = new Invoice();
        invoice2.setPrice(20);
        invoiceList.add(invoice2);
        return invoiceList;
    }
}