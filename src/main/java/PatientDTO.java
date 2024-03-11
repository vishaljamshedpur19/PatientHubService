package com.patienthub.patienthub.dto;

import jakarta.annotation.Nonnull;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
	@JsonProperty("patient_id")
	@Nonnull
	
	   private Long id;
	@JsonProperty("patient_name")

	    private String name;
	@JsonProperty("patient_age")
	    private int age;

}
