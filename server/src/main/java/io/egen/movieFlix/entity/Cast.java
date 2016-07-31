package io.egen.movieFlix.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table
public class Cast {

	private String castName;
	private String castType;

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public String getCastType() {
		return castType;
	}

	public void setCastType(String castType) {
		this.castType = castType;
	}

}
