package net.javaguides.organizationservice.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.Dto.OrganizationDto;
import net.javaguides.organizationservice.Mapper.OrganizationMapper;
import net.javaguides.organizationservice.Model.Organization;
import net.javaguides.organizationservice.Repository.OrganizationRepository;
import net.javaguides.organizationservice.Service.OrganizationService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        //Convert OrganizationDto into organization jpa entity
        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);

        //save into database
        Organization savedOrganization=organizationRepository.save(organization);

        //convert Organization JPA entity into organization Dto
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    //step-3
    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        //Convert
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
