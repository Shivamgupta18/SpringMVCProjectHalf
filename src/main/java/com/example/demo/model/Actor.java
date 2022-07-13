package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

	private Integer actorid;
	private String actorname;
	private String category;
	private Long mobileNo;
}
