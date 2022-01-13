package com.jocile.dsclient.services;

import com.jocile.dsclient.entities.Client;
import com.jocile.dsclient.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
  @Autowired
  private ClientRepository repository;

  public List<Client> findAll() {
    return repository.findAll();
  }
}
