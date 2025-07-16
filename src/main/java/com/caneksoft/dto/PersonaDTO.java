package com.caneksoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    Long id;
    String ubicacion;
    String position;
    String fullname;
    String image;
}
