/**
 * 
 */
package com.rohith.spring.dao;

import java.util.List;

import com.rohith.spring.model.Contact;

/**
 * @author Rohith Srivardhan Reballi
 *
 */
public interface ContactDAO {
   public void saveOrUpdate(Contact contact);
   public void delete(int contactId);
   public Contact get(int contactId);
   public List<Contact> list();
   
}
