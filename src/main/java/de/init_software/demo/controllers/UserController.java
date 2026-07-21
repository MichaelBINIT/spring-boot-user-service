package de.init_software.demo.controllers;

import de.init_software.demo.data.UserEntity;
import de.init_software.demo.model.UserModel;
import de.init_software.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/getUsers")
public class UserController {

  private UserService service;

  public UserController( UserService service ) {
    this.service = service;
  }

  @GetMapping("/getUser/{userName}")
  public ResponseEntity<UserModel> getUser( @PathVariable String userName ) {
    return ResponseEntity.of( Optional.ofNullable( service.getUser( userName ) ) );
  }

  @PostMapping("/addUser")
  public ResponseEntity<HttpStatus> createUser( @RequestBody UserModel user ) {
    service.addUser( user );
    return ResponseEntity.accepted().build();
  }

  @DeleteMapping("/delUser/{userName}")
  public ResponseEntity<HttpStatus> removeUser( @PathVariable String userName ) {
    service.delUser( userName );
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/all")
  public List<UserModel> getAllUsers() {
    return service.getAllUsers();
  }
}
