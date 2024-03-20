package com.backend.contactmanager.controller;

import com.backend.contactmanager.dto.request.ContactRequest;
import com.backend.contactmanager.dto.response.ContactResponse;
import com.backend.contactmanager.entity.ContactEntity;
import com.backend.contactmanager.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactEntity> findAllContact() {
        return contactService.findAllContact();
    }

    @GetMapping("/{id}")
    public Optional<ContactEntity> findContactById(@PathVariable("id") Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public ContactEntity saveContact(@RequestBody ContactEntity contactEntity) {
        return contactService.saveContact(contactEntity);
    }

    @PutMapping
    public ContactEntity updateContact(@RequestBody ContactEntity contactEntity) {
        return contactService.updateContact(contactEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
    }

//    Using Request and Response with save and update contact

    @PostMapping("/res")
    public ContactResponse saveEmpResponse(@RequestBody ContactRequest contactRequest) {
        return contactService.saveContact(contactRequest);
    }

    @PutMapping("/res/{id}")
    public ContactResponse updateEmpResponse(@RequestBody ContactRequest contactRequest, @PathVariable("id") Long id) {
        return contactService.updateContact(contactRequest, id);
    }
}
