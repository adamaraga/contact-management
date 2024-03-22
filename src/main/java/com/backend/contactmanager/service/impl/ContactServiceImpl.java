package com.backend.contactmanager.service.impl;

import com.backend.contactmanager.dto.mapper.ContactMapper;
import com.backend.contactmanager.dto.request.ContactRequest;
import com.backend.contactmanager.dto.response.ContactResponse;
import com.backend.contactmanager.entity.ContactEntity;
import com.backend.contactmanager.repository.ContactRepository;
import com.backend.contactmanager.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactEntity> findAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<ContactEntity> findById(UUID id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactEntity saveContact(ContactEntity contactEntity) {
        return contactRepository.save(contactEntity);
    }

    @Override
    public ContactEntity updateContact(ContactEntity contactEntity) {
        return contactRepository.save(contactEntity);
    }



    @Override
    public void deleteContact(UUID id) {
        contactRepository.deleteById(id);
    }

//    Using Request and Response with save and update contact

    @Override
    public ContactResponse saveContact(ContactRequest contactRequest) {
        ContactEntity contactEntity = ContactMapper.MAPPER.fromRequestToEntity(contactRequest);
        contactRepository.save(contactEntity);
        return ContactMapper.MAPPER.fromEntityToResponse(contactEntity);
    }

    @Override
    public ContactResponse updateContact(ContactRequest contactRequest, UUID id) {

        Optional<ContactEntity> checkExistingContact = findById(id);
        if (! checkExistingContact.isPresent())
            throw new RuntimeException("Contact Id "+ id + " Not Found!");

        ContactEntity contactEntity = ContactMapper.MAPPER.fromRequestToEntity(contactRequest);
        contactEntity.setId(id);
        contactRepository.save(contactEntity);
        return ContactMapper.MAPPER.fromEntityToResponse(contactEntity);
    }

}