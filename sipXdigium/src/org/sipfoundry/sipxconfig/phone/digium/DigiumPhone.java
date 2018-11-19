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

import static java.lang.String.format;

import java.util.Collection;
import java.util.List;

import org.sipfoundry.sipxconfig.common.User;
import org.sipfoundry.sipxconfig.address.Address;
import org.sipfoundry.sipxconfig.address.AddressManager;
import org.sipfoundry.sipxconfig.device.Device;
import org.sipfoundry.sipxconfig.device.DeviceDefaults;
import org.sipfoundry.sipxconfig.device.DeviceVersion;
import org.sipfoundry.sipxconfig.device.Profile;
import org.sipfoundry.sipxconfig.device.ProfileContext;
import org.sipfoundry.sipxconfig.device.ProfileFilter;
import org.sipfoundry.sipxconfig.phone.Line;
import org.sipfoundry.sipxconfig.phone.LineInfo;
import org.sipfoundry.sipxconfig.phone.Phone;
import org.sipfoundry.sipxconfig.phone.PhoneContext;
import org.sipfoundry.sipxconfig.phonebook.PhonebookEntry;
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

  private AddressManager m_addressManager;

  public DigiumPhone() {
    if (null == getSerialNumber()) {
      setSerialNumber(MAC_PREFIX);
    }
  }

  @Override
  public void initialize() {
    SpeedDial speedDial = getPhoneContext().getSpeedDial(this);
    DigiumPhoneDefaults phoneDefaults = new DigiumPhoneDefaults(getPhoneContext().getPhoneDefaults(), speedDial, getModelId());
    addDefaultBeanSettingHandler(phoneDefaults);
  }

  @Override
  public void initializeLine(Line line) {
    DigiumLineDefaults lineDefaults = new DigiumLineDefaults(line, getPhoneContext().getPhoneDefaults());
    line.addDefaultBeanSettingHandler(lineDefaults);
  }

  @Override
  public String getProfileFilename() {
    return getSerialNumber();
  }

  public String getDeviceFilename() {
      return format("%s.cfg", getProfileFilename());
  }
  public String getDirectoryFilename() {
      return format("%s-directory.cfg", getProfileFilename());
  }
  public String getSpeedDialFilename() {
      return format("%s-smartblf.cfg", getProfileFilename());
  }

  @Override
  protected LineInfo getLineInfo(Line line) {
    LineInfo info = new LineInfo();
    return info;
  }

  @Override
  protected void setLineInfo(Line line, LineInfo lineInfo) {
    line.setSettingValue(DISPLAY_NAME_PATH, lineInfo.getDisplayName());
    line.setSettingValue(USER_ID_PATH, lineInfo.getUserId());
    line.setSettingValue(PASSWORD_PATH, lineInfo.getPassword());
    line.setSettingValue(REGISTRATION_PATH, lineInfo.getRegistrationServer());
    line.setSettingValue(REGISTRATION_PORT_PATH, lineInfo.getRegistrationServerPort());
    line.setSettingValue(VOICEMAIL_PATH, lineInfo.getVoiceMail());
  }

  @Override
  public Profile[] getProfileTypes() {
    Profile[] profileTypes;

    profileTypes = new Profile[] {
      new PhoneProfile(getDeviceFilename()),
      new DirectoryProfile(getDirectoryFilename()),
      new SpeedDialProfile(getSpeedDialFilename()),
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
      PhoneContext phoneContext = phone.getPhoneContext();
      DigiumModel model = (DigiumModel) phone.getModel();
      SpeedDial speedDial = phoneContext.getSpeedDial(phone);
      return new PhoneConfiguration(phone, speedDial, model.getProfileTemplate());
    }
  }

  static class DirectoryProfile extends Profile {
    public DirectoryProfile(String name) {
      super(name, MIME_TYPE_PLAIN);
    }

    //@Override
    protected ProfileFilter createFilter(Device device) {
      return null;
    }

    //@Override
    protected ProfileContext createContext(Device device) {
      DigiumPhone phone = (DigiumPhone) device;
      PhoneContext phoneContext = phone.getPhoneContext();
      DigiumModel model = (DigiumModel) phone.getModel();
      SpeedDial speedDial = phoneContext.getSpeedDial(phone);
      Collection<PhonebookEntry> entries = phoneContext.getPhonebookEntries(phone);
      return new DirectoryConfiguration(phone, entries, speedDial, model.getDirectoryTemplate());
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
      PhoneContext phoneContext = phone.getPhoneContext();
      DigiumModel model = (DigiumModel) phone.getModel();
      SpeedDial speedDial = phoneContext.getSpeedDial(phone);
      return new SpeedDialConfiguration(phone, speedDial, model.getSpeedDialTemplate());
    }
  }

  public void setAddressManager(AddressManager addressManager) {
      m_addressManager = addressManager;
  }

  public String getTftpServer() {
      Address serverAddress = m_addressManager.getSingleAddress(FtpManager.TFTP_ADDRESS);
      if (null != serverAddress) {
          return String.format("", serverAddress.getAddress());
      } else {
          return "";
      }
  }
}
