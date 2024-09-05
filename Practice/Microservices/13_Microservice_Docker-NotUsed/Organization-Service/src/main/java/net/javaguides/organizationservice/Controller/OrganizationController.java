package net.javaguides.organizationservice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.Dto.OrganizationDto;
import net.javaguides.organizationservice.Service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "    Organization-Controller",
        description = "Crud Operation for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //Build save organization REST Api
    @Operation(
            summary = "Post request to create Organization-Service",
            description = "Creating Organization and saved it to database"
    )
    //Provide RestAPI Response
    @ApiResponse(
            responseCode = "201 created",
            description = "Created status 201 Employee"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    //Build getByCode Rest Api By using query
    //step-4
    //http://localhost:8083/api/organizations/AB01
    @Operation(
            summary = "Get request to Fetch Organization",
            description = "Get Organization From database"
    )
//Provide RestAPI Response
    @ApiResponse(
            responseCode = "200 Success",
            description = "HTTP status 200 Success"
    )

    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
    OrganizationDto organizationDto=organizationService.getOrganizationByCode(organizationCode);
    return ResponseEntity.ok(organizationDto);
    }

}
