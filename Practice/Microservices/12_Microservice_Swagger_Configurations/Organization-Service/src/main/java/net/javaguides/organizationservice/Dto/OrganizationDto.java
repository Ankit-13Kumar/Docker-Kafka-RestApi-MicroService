package net.javaguides.organizationservice.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
//For DTO Swagger we use schema here and annoate Annotations
@Schema(
        description = "OrganizationDto Model Information "
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
        private Long id;
        @Schema(
                description = "OrganizationName"
        )
        private String organizationName;
        @Schema(
                description = "organizationDescription"
        )
        private String organizationDescription;
        @Schema(
                description = "organizationCode"
        )
        private String organizationCode;
        @Schema(
                description = "CreatedDate"
        )
        private LocalDateTime createdDate;
}
