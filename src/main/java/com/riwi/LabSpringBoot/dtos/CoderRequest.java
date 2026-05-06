package com.riwi.LabSpringBoot.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Datos necesarios para crear o actualizar un coder")
public class CoderRequest {

    @Schema(description = "ID unico asignado al coder", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del coder", example = "Jainer Pabòn")
    private String name;

    @Schema(description = "Clan al que pertenece el coder", example = "Hamilton")
    private String clan;
}
