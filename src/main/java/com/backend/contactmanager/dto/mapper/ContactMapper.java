package com.backend.contactmanager.dto.mapper;

import com.backend.contactmanager.dto.request.ContactRequest;
import com.backend.contactmanager.dto.response.ContactResponse;
import com.backend.contactmanager.entity.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper MAPPER = Mappers.getMapper(ContactMapper.class);
    ContactEntity fromRequestToEntity(ContactRequest contactRequest);
    ContactResponse fromEntityToResponse(ContactEntity contactEntity);
}
