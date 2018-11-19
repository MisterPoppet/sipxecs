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
import org.sipfoundry.sipxconfig.speeddial.SpeedDial;
import org.sipfoundry.sipxconfig.speeddial.Button;
import org.sipfoundry.sipxconfig.phone.digium.DigiumPhone;

public class DirectoryConfiguration extends ProfileContext {
  private DigiumPhone m_device;
  private final Collection<PhonebookEntry> m_phonebookEntries;
  private List<Button> m_buttons;
  private String phonebookType;

  public DirectoryConfiguration(DigiumPhone device, Collection<PhonebookEntry> phonebookEntries, SpeedDial speedDial,
    String profileTemplate) {
    super(device, profileTemplate);
    m_device = device;
    m_phonebookEntries = phonebookEntries;
    if (speedDial != null) {
        m_buttons = speedDial.getButtons();
    }
  }

  public DigiumPhone getDevice() {
    return m_device;
  }

  public Collection<PhonebookEntry> getPhonebook() {
      return m_phonebookEntries;
  }

  public Collection<Button> getSpeedDial() {
    return m_buttons;
  }
}
