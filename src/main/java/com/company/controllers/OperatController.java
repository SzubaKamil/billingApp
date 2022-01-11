package com.company.controllers;

import com.company.model.Invoice;
import com.company.model.Meter;
import com.company.services.IInvoiceService;
import com.company.services.IMeterService;
import com.company.services.IUserService;
import com.company.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OperatController {

    @Autowired
    IUserService userService;
    @Autowired
    IMeterService meterService;
    @Autowired
    IInvoiceService invoiceService;
    @Resource
    SessionObject sessionObject;

    @GetMapping("/operator")
    public String showMenu (){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        return "/operat/operat";
    }

    @GetMapping("/operator/list")
    public String listMeter (Model theModel){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        List<Meter> meterList = meterService.getAllMeter();
        theModel.addAttribute("meters", meterList);
        return "/operat/operat-list-meter";
    }

    @RequestMapping("/operator/read")
    public String addMeterRead (Model theModel){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        Meter meter = new Meter();
        theModel.addAttribute("meter", meter);
        return "/operat/operat-read";
    }

    @RequestMapping("/operator/addRead")
    public String addRead(@ModelAttribute("meter") Meter meter){
        Meter meterFromDb = meterService.getMeterByID(meter.getId());
        int endValue = meter.getValue();
        int initValue =  meterFromDb.getValue();

        if (meterFromDb == null || endValue < initValue ){
            System.out.println("ID licznika niepoprawne lub wprowadzony odczyt jest mniejszy od stanu licznika");
        }
        else {
            Invoice invoice = new Invoice();
            invoice.setInitialValue(initValue);
            invoice.setEndValue(endValue);
            int price = userService.getPriceById(meterFromDb.getUser_id());
            price = price * (endValue - initValue);
            invoice.setPrice(price);
            invoice.setMeter_id(meterFromDb.getId());

            if (invoiceService.addInvoice(invoice)){
                meterFromDb.setValue(endValue);
                meterService.updateValue(meterFromDb);
                System.out.println("Zaktualizowano stan licznika i wystawiono nową FV");
            }
        }
        return "/operat/operat";
    }
}