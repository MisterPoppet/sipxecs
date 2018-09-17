/*
 *
 *
 * Copyright (C) 2018 Qubit Networks LLC., certain elements licensed under a Contributor Agreement.
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the LGPL license.
 *
 * $
 */
package org.sipfoundry.sipxconfig.phone.digium;

import org.sipfoundry.sipxconfig.common.User;
import org.sipfoundry.sipxconfig.device.DeviceDefaults;
import org.sipfoundry.sipxconfig.device.DeviceVersion;
import org.sipfoundry.sipxconfig.phone.Line;
import org.sipfoundry.sipxconfig.phone.LineInfo;
import org.sipfoundry.sipxconfig.phone.Phone;
import org.sipfoundry.sipxconfig.setting.SettingEntry;
import org.sipfoundry.sipxconfig.speeddial.SpeedDial;

public class DigiumPhone extends Phone {
  public static final String BEAN_ID = "digium";
  public static final String MIME_TYPE_PLAIN = "text/plain";
  public static final String MAC_PREFIX = "000FD3";
  public static final String DISPLAY_NAME_PATH = "account/line_label";
  public static final String USER_ID_PATH = "account/account_id";
  public static final String PASSWORD_PATH = "account/password";
  public static final String VOICEMAIL_PATH = "account/voicemail";
  public static final String REGISTRATION_PATH = "host_primary/server";
  public static final String REGISTRATION_PORT_PATH = "host_primary/port";

  public DigiumPhone() {
    if (null == getSerialNumber()) {
      setSerialNumber(MAC_PREFIX);
    }
  }

  @Override
  public void initialize() {
    SpeedDial speedDial = getPhoneContext().getSpeedDial(this);
    DigiumPhoneDefaults phoneDefaults = new DigiumPhoneDefaults(getPhoneContext().getPhoneDefaults(), speedDial, this);
    addDefaultBeanSettingHandler(phoneDefaults);
  }

  @Override
  public void initializeLine(Line line) {
    DigiumLineDefaults lineDefaults = new DigiumLineDefaults(getPhoneContext().getPhoneDefaults(), line);
    line.addDefaultBeanSettingHandler(lineDefaults);
  }

  @Override
  public String getProfileFilename() {
    return getSerialNumber();
  }

  public String getDeviceFilename() {
      return format("%s.xml", getProfileFilename());
  }
  public String getDirectoryFilename() {
      return format("%s-directory.xml", getProfileFilename());
  }
  public String getSpeedDialFilename() {
      return format("%s-smartblf.xml", getProfileFilename());
  }

  @Override
  protected LineInfo getLineInfo(Line line) {
    LineInfo info = new LineInfo();
    return info;
  }

  @Override
  protected void setLineInfo(Line line, LineInfo lineInfo) {
    line.setSettingValue(DISPLAY_NAME_PATH, info.getDisplayName());
    line.setSettingValue(USER_ID_PATH, info.getUserId());
    line.setSettingValue(PASSWORD_PATH, info.getPassword());
    line.setSettingValue(REGISTRATION_PATH, info.getRegistrationServer());
    line.setSettingValue(REGISTRATION_PORT_PATH, info.getRegistrationServerPort());
    line.setSettingValue(VOICEMAIL_PATH, info.getVoiceMail());
  }

  @Override
  public Profile[] getProfileTypes() {
    DigiumModel model = (DigiumModel) phone.getModel();
    Profile[] profileTypes;

    profileTypes = new Profile[] {
      new PhoneProfile(getDeviceFilename()),
      new DirectoryProfile(getDirectoryFilename()),
      new SppedDialProfile(getSpeedDialFilename()),
    };

    return profileTypes;
  }

  static class PhoneProfile extends Profile {
    public PhoneProfile(String name) {
      super(name, MIME_TYPE_PLAIN);
    }

    //@Override
    protected ProfileFilter createFilter(Device device) {
      return null;
    }

    //@Override
    protected ProfileContext createContext(Device device) {
      DigiumPhone phone = (DigiumPhone) device;
      DigiumModel model = (DigiumModel) phone.getModel();
      return new PhoneConfiguration(phone, model.getProfileTemplate());
    }
  }

  static class DirectoryProfile extends Profile {
    private Phonebook m_phonebook;

    public DirectoryProfile(String name, Phonebook phonebook) {
      super(name, MIME_TYPE_PLAIN);
      m_phonebook = phonebook;
    }

    //@Override
    protected ProfileFilter createFilter(Device device) {
      return null;
    }

    //@Override
    protected ProfileContext createContext(Device device) {
      DigiumPhone phone = (DigiumPhone) device;
      DigiumModel model = (DigiumModel) phone.getModel();
      Collection<PhonebookEntry> entries = phone.getPhonebookManager().getEntries(m_phonebook);
      return new DirectoryConfiguration(phone, entries, model.getDirectoryTemplate());
    }
  }

  static class SpeedDialProfile extends Profile {
    public SpeedDialProfile(String name) {
      super(name, MIME_TYPE_PLAIN);
    }

    //@Override
    protected ProfileFilter createFilter(Device device) {
      return null;
    }

    //@Override
    protected ProfileContext createContext(Device device) {
      DigiumPhone phone = (DigiumPhone) device;
      DigiumModel model = (DigiumModel) phone.getModel();
      SpeedDial speedDial = phoneContext.getSpeedDial(phone);
      return new SpeedDialConfiguration(phone, model.getSpeedDialTemplate());
    }
  }
}
