package de.init_software.demo.services;

import de.init_software.demo.data.UserEntity;
import de.init_software.demo.data.UserRepository;
import de.init_software.demo.mappers.EntityMapper;
import de.init_software.demo.model.UserModel;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

  private final TimeService timeService;
  private UserRepository userRepository;
  private final EntityMapper<UserEntity, UserModel> entityMapper;
  // private Map<String, UserModel> userMap = new HashMap<>();

  public UserServiceImpl( TimeService timeService, UserRepository userRepository, EntityMapper<UserEntity, UserModel> entityMapper ) {
    this.timeService = timeService;
    this.userRepository = userRepository;
    //  userMap.put( "John", new UserModel( "John", "Doe", 1234 ) );
    //  userMap.put( "Jane", new UserModel( "Jane", "Doe", 4444 ) );
    this.entityMapper = entityMapper;
  }

  public UserModel getUser( String userName ) {
    return entityMapper.map( userRepository.findByFirstName( userName ) );
    // return userMap.get(userName);
  }

  public void addUser( UserModel user ) {
    user.setCreationTime( timeService.getCurrentTime( "Amsterdam" ) );
    userRepository.save( entityMapper.reverseMap( user ) );
//    userMap.put( user.getFirstName(), user );
  }

  @Transactional
  public void delUser( String userName ) {
    userRepository.deleteByFirstName( userName );
    // userMap.remove( userName );
  }

  public List<UserModel> getAllUsers( ) {
    return userRepository.findAll()
            .stream()
            .map( entityMapper::map )
            .toList();
    // userMap.remove( userName );
  }

}
