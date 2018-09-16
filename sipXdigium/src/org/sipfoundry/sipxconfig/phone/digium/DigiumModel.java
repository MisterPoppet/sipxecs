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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sipfoundry.sipxconfig.device.DeviceVersion;
import org.sipfoundry.sipxconfig.phone.PhoneModel;

/**
 * Static differences in polycom phone models
 */
public final class DigiumModel extends PhoneModel {

  public static final DeviceVersion VER_2_7_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.7.0");
  public static final DeviceVersion VER_2_6_6 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.6.6");
  public static final DeviceVersion VER_2_6_5 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.6.5");
  public static final DeviceVersion VER_2_6_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.6.1");
  public static final DeviceVersion VER_2_4_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.4.2");
  public static final DeviceVersion VER_2_4_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.4.1");
  public static final DeviceVersion VER_2_3_8 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.3.8");
  public static final DeviceVersion VER_2_3_7 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.3.7");
  public static final DeviceVersion VER_2_3_4 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.3.4");
  public static final DeviceVersion VER_2_2_2_3 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.2.3");
  public static final DeviceVersion VER_2_2_2_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.2.2");
  public static final DeviceVersion VER_2_2_1_8 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.8");
  public static final DeviceVersion VER_2_2_1_7 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.7");
  public static final DeviceVersion VER_2_2_1_4 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.4");
  public static final DeviceVersion VER_2_2_1_3 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.3");
  public static final DeviceVersion VER_2_2_1_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.2");
  public static final DeviceVersion VER_2_2_1_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.1.1");
  public static final DeviceVersion VER_2_2_0_8 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.0.8");
  public static final DeviceVersion VER_2_2_0_5 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.0.5");
  public static final DeviceVersion VER_2_2_0_4 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.0.4");
  public static final DeviceVersion VER_2_2_0_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.2.0.0");
  public static final DeviceVersion VER_2_1_0_3 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.1.0.3");
  public static final DeviceVersion VER_2_1_0_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.1.0.0");
  public static final DeviceVersion VER_2_0_3_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.0.3.2");
  public static final DeviceVersion VER_2_0_3_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.0.3.0");
  public static final DeviceVersion VER_2_0_2_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.0.2.0");
  public static final DeviceVersion VER_2_0_1_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "2.0.1.0");
  public static final DeviceVersion VER_1_8_8 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.8.8");
  public static final DeviceVersion VER_1_8_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.8.2");
  public static final DeviceVersion VER_1_8_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.8.1");
  public static final DeviceVersion VER_1_7_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.7.1");
  public static final DeviceVersion VER_1_6_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.6.2");
  public static final DeviceVersion VER_1_5_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.5.2");
  public static final DeviceVersion VER_1_4_6 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.6");
  public static final DeviceVersion VER_1_4_3 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.3");
  public static final DeviceVersion VER_1_4_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.2");
  public static final DeviceVersion VER_1_4_2_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.2.1");
  public static final DeviceVersion VER_1_4_2_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.2.0");
  public static final DeviceVersion VER_1_4_1 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.1");
  public static final DeviceVersion VER_1_4_1_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.1.0");
  public static final DeviceVersion VER_1_4_0_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.4.0.0");
  public static final DeviceVersion VER_1_3_3_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.3.3.0");
  public static final DeviceVersion VER_1_3_2 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.3.2");
  public static final DeviceVersion VER_1_3_2_3 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.3.2.3");
  public static final DeviceVersion VER_1_3_2_0 = new DeviceVersion(DigiumPhone.BEAN_ID, "1.3.2.0");

  public static final DeviceVersion[] SUPPORTED_VERSIONS = new DeviceVersion[] {
    VER_6X, VER_2_7_0, VER_2_6_6, VER_2_6_5, VER_2_6_1, VER_2_4_2, VER_2_4_1, VER_2_3_8, VER_2_3_7, VER_2_3_4,
    VER_2_2_2_3, VER_2_2_2_2, VER_2_2_1_8, VER_2_2_1_7, VER_2_2_1_4, VER_2_2_1_3, VER_2_2_1_2, VER_2_2_1_1,
    VER_2_2_0_8, VER_2_2_0_5, VER_2_2_0_4, VER_2_2_0_0, VER_2_1_0_3, VER_2_1_0_0, VER_2_0_3_2, VER_2_0_3_0,
    VER_2_0_2_0, VER_2_0_1_0, VER_1_8_8, VER_1_8_2, VER_1_8_1, VER_1_7_1, VER_1_6_2, VER_1_5_2, VER_1_4_6,
    VER_1_4_3, VER_1_4_2, VER_1_4_2_1, VER_1_4_2_0, VER_1_4_1, VER_1_4_1_0, VER_1_4_0_0, VER_1_3_3_0,
    VER_1_3_2, VER_1_3_2_3, VER_1_3_2_0
  };

  private DeviceVersion m_deviceVersion;
  private String m_directoryTemplate;
  private String m_speedDialTemplate;

  public DigiumModel() {
      super(DigiumPhone.BEAN_ID);
      setEmergencyConfigurable(false);
  }

  public static DeviceVersion getPhoneDeviceVersion(String version) {
      for (DeviceVersion deviceVersion : SUPPORTED_VERSIONS) {
          if (deviceVersion.getName().contains(version)) {
              return deviceVersion;
          }
      }
      return VER_2_7_0;
  }

  public void setDefaultVersion(DeviceVersion value) {
      LOG.debug("DigiumModel:setDefaultVersion");
      m_deviceVersion = value;
  }

  public DeviceVersion getDefaultVersion() {
      LOG.debug("DigiumModel:getDefaultVersion");
      if(m_deviceVersion != null)
      {
          return m_deviceVersion;
      } else {
          return VER_2_7_0;
      }
  }

  public void setDirectoryTemplate(String value) {
      m_directoryTemplate = value;
  }

  public String getDirectoryTemplate() {
      return m_directoryTemplate;
  }

  public void setSpeedDialTemplate(String value) {
      m_speedDialTemplate = value;
  }

  public String getSpeedDialTemplate() {
      return m_speedDialTemplate;
  }
}
