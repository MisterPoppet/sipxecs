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

import org.sipfoundry.sipxconfig.common.User;
import org.sipfoundry.sipxconfig.device.DeviceDefaults;
import org.sipfoundry.sipxconfig.phone.Line;
import org.sipfoundry.sipxconfig.setting.SettingEntry;

public class DigiumLineDefaults {
    private Line m_line;
    private DeviceDefaults m_defaults;

    public DigiumLineDefaults(Line line, DeviceDefaults defaults) {
      m_line = line;
      m_defaults = defaults;
    }

    @SettingEntry(paths = { "account/account_id", "account/username", "account/authname" })
    public String getUserName() {
      String userName = null;
      User user = m_line.getUser();
      if (user != null) {
        userName = user.getUserName();
      }
      return userName;
    }

    @SettingEntry(path = "account/line_label")
    public String getDisplayName() {
      User user = m_line.getUser();
      if (user == null) {
        return null;
      }
      return user.getDisplayName();
    }

    @SettingEntry(path = "account/server_uuid")
    public String getRalm() {
      return m_defaults.getAuthorizationRealm();
    }

    @SettingEntry(paths = { "account.password", "account.passcode" })
    public String getSipPassword() {
      User user = m_line.getUser();
      if (user == null) {
        return null;
      }
      return user.getSipPassword();
    }

    @SettingEntry(paths = "host_primary.server")
    public String getSipProxyServer() {
      return m_defaults.getDomainName();

    }

    @SettingEntry(paths = "host_primary.port")
    public String getSipProxyPort() {
      return String.valueOf(m_defaults.getProxyAddress().getPort());
    }
}
