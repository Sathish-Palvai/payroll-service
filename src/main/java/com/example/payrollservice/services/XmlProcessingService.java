package com.example.payrollservice.services;

import com.example.payrollservice.FileUploadController;
import com.example.payrollservice.binding.CompanyData;
import com.example.payrollservice.binding.Employee;
import com.example.payrollservice.exceptions.XmlProcessingException;
import com.example.payrollservice.persistence.entities.EmployeeEntity;
import com.example.payrollservice.persistence.repositories.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.InputStream;

@Service
public class XmlProcessingService {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);
    private final EmployeeRepository repository;

    public XmlProcessingService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void validateAndProcess(MultipartFile file) throws XmlProcessingException {
        try (InputStream xmlFileInputStream = file.getInputStream();
                InputStream xsdInputStream = getClass().getResourceAsStream("/payroll.xsd")) {

            validateXml(xmlFileInputStream, xsdInputStream);

            // Reset the stream since it was read during validation
            LOG.info("Before company data unmarshall");
            CompanyData companyData = unmarshal(file.getInputStream());
            LOG.info("Company Data: {}", companyData.toString());
            processCompanyData(companyData);

        } catch (IOException | JAXBException | SAXException e) {
            
            LOG.error("Error processing XML file {}", e.getMessage());
            throw new XmlProcessingException("Error processing XML file", e);
        }
    }

    private void validateXml(InputStream xmlInputStream, InputStream xsdInputStream) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        javax.xml.validation.Schema schema = schemaFactory.newSchema(new StreamSource(xsdInputStream));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(xmlInputStream));
    }

    private CompanyData unmarshal(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CompanyData.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (CompanyData) unmarshaller.unmarshal(inputStream);
    }

    private void processCompanyData(CompanyData companyData) {
        for (Employee employee : companyData.getEmployees()) {
            EmployeeEntity empObj = new EmployeeEntity();
            empObj.setFirstName(employee.getFirstName());
            empObj.setLastName(employee.getLastName());
            empObj.setAddress(employee.getAddress());
            empObj.setDateOfBirth(employee.getDateOfBirth());
            empObj.setCity(employee.getCity());
            empObj.setContactNumber(employee.getContactNumber());
            empObj.setEmail(employee.getEmail());
            empObj.setEmployeeId(employee.getEmployeeID());
            repository.save(empObj);
            LOG.info("After saving to db");
        }
    }
}
