package com.revolut.moneytransfer;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "OLCM_CLASS_TYPE")
public class Resource implements Serializable {
private String id;
private String name;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
