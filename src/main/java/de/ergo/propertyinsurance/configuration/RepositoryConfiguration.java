package de.ergo.propertyinsurance.configuration;

import de.ergo.propertyinsurance.business.InsuranceEnquiryEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    InsuranceEnquiryEventHandler insuranceEnquiryEventHandler() {
        return new InsuranceEnquiryEventHandler();
    }
}