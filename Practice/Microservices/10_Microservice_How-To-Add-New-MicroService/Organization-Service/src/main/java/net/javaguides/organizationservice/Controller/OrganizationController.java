package net.javaguides.organizationservice.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.Dto.OrganizationDto;
import net.javaguides.organizationservice.Model.Organization;
import net.javaguides.organizationservice.Service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //Build save organization REST Api
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    //Build getByCode Rest Api By using query
    //step-4
    //http://localhost:8083/api/organizations/AB01
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
    OrganizationDto organizationDto=organizationService.getOrganizationByCode(organizationCode);
    return ResponseEntity.ok(organizationDto);
    }

}
