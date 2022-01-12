package com.jocile.dsclient.resources;

import com.jocile.dsclient.entities.Client;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

  @GetMapping
  public ResponseEntity<List<Client>> findAll() {
    List<Client> list = new ArrayList<>();
    list.add(
      new Client(
        1L,
        "Fulano",
        "12345678901",
        2500.0,
        Instant.parse("1994-07-20T10:30:00Z"),
        2
      )
    );
    list.add(
      new Client(
        2L,
        "Ciclano",
        "12345678901",
        3500.0,
        Instant.parse("1984-08-10T10:30:00Z"),
        3
      )
    );
    list.add(
      new Client(
        3L,
        "João",
        "12345678901",
        4500.0,
        Instant.parse("1974-01-05T10:30:00Z"),
        2
      )
    );
    return ResponseEntity.ok().body(list);
  }
}
