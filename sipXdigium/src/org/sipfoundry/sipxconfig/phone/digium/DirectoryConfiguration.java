/*
 * Copyright (c) 2013 SibTelCom, JSC (SIPLABS Communications). All rights reserved.
 * Contributed to SIPfoundry and eZuce, Inc. under a Contributor Agreement.
 *
 * Developed by Konstantin S. Vishnivetsky
 *
 * This library or application is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License (AGPL) as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any later version.
 *
 * This library or application is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License (AGPL) for
 * more details.
 *
 */

package org.sipfoundry.sipxconfig.phone.digium;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.sipfoundry.sipxconfig.device.ProfileContext;
import org.sipfoundry.sipxconfig.phonebook.AddressBookEntry;
import org.sipfoundry.sipxconfig.phonebook.PhonebookEntry;

public class DirectoryConfiguration extends ProfileContext {
  private final Collection<PhonebookEntry> m_phonebookEntries;
  private String phonebookType;

  public DirectoryConfiguration(DigiumPhone device, Collection<PhonebookEntry> phonebookEntries,
    String profileTemplate) {
    super(device, profileTemplate);
    m_phonebookEntries = phonebookEntries;

      phonebookType = device.getPhonebookType();
  }

  /*public Collection<Button> getSpeedDial() {
    DigiumPhone phone = (DigiumPhone) getDevice();
    if (null == phone.getSpeedDial()) {
      return Collections.emptyList();
    } else {
      return phone.getSpeedDial().getButtons();
    }
  }*/

  public Collection<DigiumPhonebookEntry> getRows() {
    int size = getSize();
    if (size == 0) {
      return Collections.emptyList();
    }
    Collection<DigiumPhonebookEntry> digiumEntries = new LinkedHashSet<DigiumPhonebookEntry>(size);
    if (null != m_phonebookEntries) {
      transformPhoneBook(m_phonebookEntries, digiumEntries);
    }
    return digiumEntries;
  }

  public String getPhonebookType(){
    return phonebookType;
  }

  private int getSize() {
    return null != m_phonebookEntries ? m_phonebookEntries.size() : 0;
  }

  void transformPhoneBook(Collection<PhonebookEntry> phonebookEntries,
      Collection<DigiumPhonebookEntry> digiumEntries) {
    for (PhonebookEntry entry : phonebookEntries) {
      digiumEntries.add(new DigiumPhonebookEntry(entry));
    }
    List<DigiumPhonebookEntry> tmp = Collections.list(Collections.enumeration(digiumEntries));
    Collections.sort(tmp);
    digiumEntries.clear();
    for (DigiumPhonebookEntry entry : tmp) {
      digiumEntries.add(entry);
    }
  }

  public static class DigiumPhonebookEntry implements Comparable<DigiumPhonebookEntry> {
    private final String m_firstName;
    private String m_lastName;
    private final String m_contact;
    private String m_mobile;
    private String m_other;

    public DigiumPhonebookEntry(PhonebookEntry entry) {
      AddressBookEntry address = entry.getAddressBookEntry();
      m_contact = entry.getNumber();
      m_lastName = entry.getLastName();
      m_firstName = entry.getFirstName();
      if (address != null){
        m_mobile = address.getCellPhoneNumber();
        m_other = address.getHomePhoneNumber();
      }
      else{
        m_mobile = "";
        m_other = "";
      }
    }

    public String getFirstName() {
      String firstName = m_firstName;
      if (null == firstName && null == m_lastName) {
        return m_contact;
      }
      return firstName;
    }

    public String getLastName() {
      return m_lastName;
    }

    public String getContact() {
      return m_contact;
    }
    public String getMobile() {
      return m_mobile;
    }
    public String getOther() {
      return m_other;
    }
    @Override
    public int hashCode() {
      return new HashCodeBuilder().append(m_contact).toHashCode();
    }

    @Override
    public int compareTo(DigiumPhonebookEntry a) {
      int result = 0;
      if (null == a) {
        return 0;
      }
      if (null != m_lastName && null != a.getLastName()) {
        result = m_lastName.compareTo(a.getLastName());
      }
      if (null != m_firstName && null != a.getFirstName()) {
        return result == 0 ? m_firstName.compareTo(a.getFirstName()) : result;
      } else {
        return result;
      }
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof DigiumPhonebookEntry)) {
        return false;
      }
      if (this == obj) {
        return true;
      }
      DigiumPhonebookEntry rhs = (DigiumPhonebookEntry) obj;
      return new EqualsBuilder().append(m_contact, rhs.m_contact).isEquals();
    }
  }
}
