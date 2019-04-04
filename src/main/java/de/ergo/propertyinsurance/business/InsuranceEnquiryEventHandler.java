package de.ergo.propertyinsurance.business;

import de.ergo.propertyinsurance.model.InsuranceEnquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class InsuranceEnquiryEventHandler {

    @Autowired
    private MailService mailService;

    @HandleBeforeCreate
    public void handleInsuranceEnquiryCreate(InsuranceEnquiry insuranceEnquiry) {
        mailService.sendFachbereichMessage(insuranceEnquiry);
        mailService.sendKundenMessage(insuranceEnquiry);
    }
}