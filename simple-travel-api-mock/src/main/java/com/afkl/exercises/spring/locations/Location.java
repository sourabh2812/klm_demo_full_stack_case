package com.afkl.exercises.spring.locations;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Value
public class Location {

    private String code, name, description;
    private Coordinates coordinates;
    private Location parent;
    private Set<Location> children;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public Location getParent() {
		return parent;
	}
	public void setParent(Location parent) {
		this.parent = parent;
	}
	public Set<Location> getChildren() {
		return children;
	}
	public void setChildren(Set<Location> children) {
		this.children = children;
	}
    
    

}
