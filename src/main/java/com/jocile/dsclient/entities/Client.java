package com.jocile.dsclient.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Client model implementation
 * generate the table tb_client
 */
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String cpf;
  private Double income;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant birthDate;

  private Integer children;

  public Client() {}

  public Client(
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

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Client)) {
      return false;
    }
    Client client = (Client) o;
    return (
      Objects.equals(id, client.id) &&
      Objects.equals(name, client.name) &&
      Objects.equals(cpf, client.cpf) &&
      Objects.equals(income, client.income) &&
      Objects.equals(birthDate, client.birthDate) &&
      Objects.equals(children, client.children)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cpf, income, birthDate, children);
  }
}
