package com.jocile.dsclient.dto;

import com.jocile.dsclient.entities.Client;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object DTO - Data Transfer Object -
 * access the Client entity,
 * used to load only the necessary data.
 *
 * @param entity client
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
