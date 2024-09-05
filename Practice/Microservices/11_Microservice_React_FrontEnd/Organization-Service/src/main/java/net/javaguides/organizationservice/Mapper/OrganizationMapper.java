package net.javaguides.organizationservice.Mapper;

import net.javaguides.organizationservice.Dto.OrganizationDto;
import net.javaguides.organizationservice.Model.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto organizationDto=new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationCode(),
                organization.getOrganizationName(),
                organization.getCreatedDate()
        );
        return organizationDto;
    }


    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization=new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getCreatedDate()
        );
    return organization;
    }
}
