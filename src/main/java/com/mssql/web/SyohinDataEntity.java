package com.mssql.web;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SyohinDataPojo")
public class SyohinDataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NumId", columnDefinition = "int", nullable = false)
	private Integer _NumId;

	@Column(name = "SyohinNum", columnDefinition = "smallint", nullable = false)
	private Short _SyohinCode;

	@Column(name = "SyohinName", columnDefinition = "char(50)", length = 50)
	private String _SyohinName;

	@Column(name = "EditDate", columnDefinition = "decimal(8, 0)", precision = 8, scale = 0, nullable = false)
	private BigDecimal _EditDate;

	@Column(name = "EditTime", columnDefinition = "decimal(6, 0)", precision = 6, scale = 0, nullable = false)
	private BigDecimal _EditTime;

	@Column(name = "Note", columnDefinition = "varchar(255)", length = 50)
	private String _Note;

	public SyohinDataEntity() {
		super();
	}

	public SyohinDataEntity(Short Code, String Name, BigDecimal Date, BigDecimal Time, String Note) {
		super();
		_SyohinCode = Code;
		_SyohinName = Name;
		_EditDate = Date;
		_EditTime = Time;
		this._Note = Note;
	}

	public Integer getNumId() {
		return _NumId;
	}

	public Short getSyohinCode() {
		return _SyohinCode;
	}
	public void setSyohinCode(Short value) {
		_SyohinCode = value;
	}

	public String getSyohinName() {
		return _SyohinName;
	}
	public void setSyohinName(String value) {
		_SyohinName = value;
	}

	public BigDecimal getEditDate() {
		return _EditDate;
	}
	public void setEditDate(BigDecimal value) {
		_EditDate = value;
	}

	public BigDecimal getEditTime() {
		return _EditTime;
	}
	public void setEditTime(BigDecimal value) {
		_EditTime = value;
	}

	public String getNote() {
		return _Note;
	}
	public void setNote(String value) {
		_Note = value;
	}
}
