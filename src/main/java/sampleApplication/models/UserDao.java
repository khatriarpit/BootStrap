package sampleApplication.models;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(User user) {
    getSession().save(user);
    return;
  }
  
  public void delete(User user) {
    getSession().delete(user);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<User> getAll() {
    return getSession().createQuery("from User").list();
  }
  
  public User getByEmail(String email) {
    return (User) getSession().createQuery(
        "from User where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  public User getById(long id) {
    return (User) getSession().load(User.class, id);
  }

  public void update(User user) {
    getSession().update(user);
    return;
  }

  public List<User> getPhoneNumbersByEmployeeName(String userName) {

    Criteria c = getSession().createCriteria(User.class);
    c.add(userName == null ? Restrictions.isNull("userName") : Restrictions.eq("userName", userName));
    List listOfUser = c.list();

    for (Iterator iterator1 =
         listOfUser.iterator(); iterator1.hasNext(); ) {
      User user = (User) iterator1.next();
      System.out.print("Email " + user.getEmail());
      System.out.print("UserName: " + user.getUserName());
      Set phoneDtls = user.getPhoneDtls();
      for (Iterator iterator2 =
           phoneDtls.iterator(); iterator2.hasNext(); ) {
        PhoneDetails phoneDetails = (PhoneDetails) iterator2.next();
        System.out.println("PhoneNUmber: " + phoneDetails.getPhoneNumber());
      }


    }
    return listOfUser;
  }
} // class UserDao
