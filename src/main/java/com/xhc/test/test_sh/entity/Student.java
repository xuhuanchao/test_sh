package com.xhc.test.test_sh.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;


/**
 *
 * 类说明 : 学生.
 * 
 * <pre>
 * 修改记录：
 * 修改日期　　　修改人　　　修改原因
 * 2017-05-18   T008672　　　新建
 * </pre>
 */
@Entity
@Table(name = "STUDENT")
public class Student implements java.io.Serializable {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 170518091956987L;

	// Fields
	
	/**
	 * .
	 */
	private String id;
	/**
	 * .
	 */
	private String name;
	/**
	 * .
	 */
	private Integer age;
	/**
	 * .
	 */
	private String address;
	/**
	 * .
	 */
	private String hobby;
	/**
	 * .
	 */
	private String classname;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String id) {
	    this.id = id;
	}

	/** full constructor */
	public Student(String id, String name, Integer age, String address, String hobby, String classname) {
	    this.id = id;
	    this.name = name;
	    this.age = age;
	    this.address = address;
	    this.hobby = hobby;
	    this.classname = classname;
	}

	// Property accessors
	
	/**
	 * 取得.
	 *
	 * @return id 
	 */
	@Id
	@Column(name = "ID", nullable = false, length = 40)
	public String getId() {
		return this.id;
	}
	
	/**
	 * 设置.
	 *
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 取得.
	 *
	 * @return name 
	 */
	@Column(name = "NAME", length = 40)
	public String getName() {
		return this.name;
	}
	
	/**
	 * 设置.
	 *
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 取得.
	 *
	 * @return age 
	 */
	@Column(name = "AGE", precision = 3, scale = 0)
	public Integer getAge() {
		return this.age;
	}
	
	/**
	 * 设置.
	 *
	 * @param age 
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * 取得.
	 *
	 * @return address 
	 */
	@Column(name = "ADDRESS", length = 300)
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * 设置.
	 *
	 * @param address 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 取得.
	 *
	 * @return hobby 
	 */
	@Column(name = "HOBBY", length = 500)
	public String getHobby() {
		return this.hobby;
	}
	
	/**
	 * 设置.
	 *
	 * @param hobby 
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	/**
	 * 取得.
	 *
	 * @return class 
	 */
	@Column(name = "CLASSNAME", length = 30)
	public String getClassname() {
		return this.classname;
	}
	
	/**
	 * 设置.
	 *
	 * @param class 
	 */
	public void setClass(String classname) {
		this.classname = classname;
	}
	
}