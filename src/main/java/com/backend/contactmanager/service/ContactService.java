package com.backend.contactmanager.service;

import com.backend.contactmanager.dto.request.ContactRequest;
import com.backend.contactmanager.dto.response.ContactResponse;
import com.backend.contactmanager.entity.ContactEntity;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    List<ContactEntity> findAllContact();
    Optional<ContactEntity> findById(Long id);
    ContactEntity saveContact(ContactEntity contactEntity);
    ContactEntity updateContact(ContactEntity contactEntity);
    void deleteContact(Long id);

//    Using Request for Save and Update Contact
    ContactResponse saveContact(ContactRequest contactRequest);
    ContactResponse updateContact(ContactRequest contactRequest, Long id);
}
