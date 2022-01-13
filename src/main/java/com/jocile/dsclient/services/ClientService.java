package com.jocile.dsclient.services;

import com.jocile.dsclient.dto.ClientDTO;
import com.jocile.dsclient.entities.Client;
import com.jocile.dsclient.repositories.ClientRepository;
import com.jocile.dsclient.services.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
      () -> new EntityNotFoundException("Entity not found")
    );
    return new ClientDTO(entity);
  }
}
