package de.ergo.propertyinsurance.rest;

import de.ergo.propertyinsurance.model.InsuranceEnquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "insuranceEnquiries", path = "/insuranceEnquiries")
public interface InsuranceEnquiryRepository extends MongoRepository<InsuranceEnquiry, String> {

}
