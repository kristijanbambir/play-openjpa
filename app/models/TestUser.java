package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestUser {

	@Id
	@GeneratedValue
	public Long id;

	@Column(length = 255)
	public String name;

}
