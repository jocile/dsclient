package com.jocile.dsclient.dto;

import com.jocile.dsclient.entities.Client;
import java.io.Serializable;
import java.time.Instant;

/**
 * Object DTO - Data Transfer Object -
 * access the Client entity,
 * used to load only the necessary data.
 *
 * @param entity client
 */

public class ClientDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String cpf;
  private Double income;
  private Instant birthDate;
  private Integer children;

  /**
   * this constructor creates a data transfer object
   *  from a object client entity
   *
   * @param entity category
   */
  public ClientDTO(Client entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.cpf = entity.getCpf();
    this.income = entity.getIncome();
    this.birthDate = entity.getBirthDate();
    this.children = entity.getChildren();
  }

  public ClientDTO() {}

  public ClientDTO(
    Long id,
    String name,
    String cpf,
    Double income,
    Instant birthDate,
    Integer children
  ) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Double getIncome() {
    return this.income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public Instant getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(Instant birthDate) {
    this.birthDate = birthDate;
  }

  public Integer getChildren() {
    return this.children;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }
}
