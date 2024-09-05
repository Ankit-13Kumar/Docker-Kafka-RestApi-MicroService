package net.javaguides.organizationservice.Repository;

import net.javaguides.organizationservice.Model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    //ByCode repository query
    //Step-1
    Organization findByOrganizationCode(String organizationCode);

}
