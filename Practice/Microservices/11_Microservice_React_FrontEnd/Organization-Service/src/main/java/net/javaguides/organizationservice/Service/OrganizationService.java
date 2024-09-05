package net.javaguides.organizationservice.Service;

import net.javaguides.organizationservice.Dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    //Step-2
    OrganizationDto getOrganizationByCode(String organizationCode);


}
