package com.jocile.dsclient.services;

import com.jocile.dsclient.dto.ClientDTO;
import com.jocile.dsclient.entities.Client;
import com.jocile.dsclient.repositories.ClientRepository;
import com.jocile.dsclient.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
  @Autowired
  private ClientRepository repository;

  @Transactional(readOnly = true)
  public List<ClientDTO> findAll() {
    List<Client> list = repository.findAll();
    return list
      .stream()
      .map(x -> new ClientDTO(x))
      .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Optional<Client> obj = repository.findById(id);
    Client entity = obj.orElseThrow(
      () -> new ResourceNotFoundException("Entity not found")
    );
    return new ClientDTO(entity);
  }

  @Transactional
  public ClientDTO insert(ClientDTO dto) {
    Client entity = new Client();
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setIncome(dto.getIncome());
    entity.setBirthDate(dto.getBirthDate());
    entity.setChildren(dto.getChildren());
    entity = repository.save(entity);
    return new ClientDTO(entity);
  }

  @Transactional
  public ClientDTO update(Long id, ClientDTO dto) {
    try {
      Client entity = repository.getOne(id);
      entity.setName(dto.getName());
      entity.setName(dto.getName());
      entity.setCpf(dto.getCpf());
      entity.setIncome(dto.getIncome());
      entity.setBirthDate(dto.getBirthDate());
      entity.setChildren(dto.getChildren());
      entity = repository.save(entity);
      return new ClientDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }
}
