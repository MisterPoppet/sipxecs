/*
 *
 *
 * Copyright (C) 2007 Pingtel Corp., certain elements licensed under a Contributor Agreement.
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the LGPL license.
 *
 * $
 */
package org.sipfoundry.sipxconfig.phone.digium;

import org.sipfoundry.sipxconfig.address.Address;
import org.sipfoundry.sipxconfig.common.SipUri;
import org.sipfoundry.sipxconfig.device.DeviceDefaults;
import org.sipfoundry.sipxconfig.device.DeviceTimeZone;
import org.sipfoundry.sipxconfig.phonelog.PhoneLog;
import org.sipfoundry.sipxconfig.setting.SettingEntry;
import org.sipfoundry.sipxconfig.speeddial.SpeedDial;

public class DigiumPhoneDefaults {
  private final DeviceDefaults m_defaults;
  private final SpeedDial m_speedDial;
  private final String m_model;
  private final boolean m_presenceEnabled;
  
  DigiumPhoneDefaults(DeviceDefaults defaults, SpeedDial speedDial, String model, boolean presenceEnabled) {
      m_defaults = defaults;
      m_speedDial = speedDial;
      m_model = model;
      m_presenceEnabled = presenceEnabled;
  }

  @SettingEntry(path = "time/ntp_server")
  public String getNtpServer() {
      return m_defaults.getNtpServer();
  }

  @SettingEntry(path = "feature/call_pickup_code")
  public String getDirectedCallPickupString() {
      return m_defaults.getDirectedCallPickupCode();
  }
}
