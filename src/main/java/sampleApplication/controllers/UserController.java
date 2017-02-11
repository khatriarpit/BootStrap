package sampleApplication.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import sampleApplication.models.StatusModel;
import sampleApplication.models.User;
import sampleApplication.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.QueryParam;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserDao _userDao;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getUserId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }
  /*UrlConstants.FEED_USER_REGISTER*/
  @RequestMapping(value = "/api/v1/getPhoneNumberByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public final ResponseEntity<StatusModel> Register(@QueryParam("userName") final String userName) throws ServiceException {
    StatusModel addStatus=new StatusModel();

    List<User> listOfUserwithPhoneDtlsByUsername = _userDao.getPhoneNumbersByEmployeeName(userName);
    addStatus.setData(listOfUserwithPhoneDtlsByUsername);

    return new ResponseEntity<StatusModel>(addStatus, HttpStatus.OK);
  }


} // class UserController
