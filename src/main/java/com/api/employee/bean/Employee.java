package com.api.employee.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee")
public class Employee  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Tokyo")
    private Date entrancedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEntrancedate() {
		return entrancedate;
	}
	public void setEntrancedate(Date entrancedate) {
		this.entrancedate = entrancedate;
	}
}
