package com.jocile.dsclient.services;

import com.jocile.dsclient.dto.ClientDTO;
import com.jocile.dsclient.entities.Client;
import com.jocile.dsclient.repositories.ClientRepository;
import java.util.List;
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
}
