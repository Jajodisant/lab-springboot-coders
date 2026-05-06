package com.riwi.LabSpringBoot.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa a un coder registrado en memoria")
public class Coder {

    @Schema(description = "ID unico del coder", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del coder", example = "Jainer Pabòn")
    private String name;

    @Schema(description = "Clan al que pertenece el coder", example = "Hamilton")
    private String clan;
}
