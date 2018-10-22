package com.tictactoe2.config;

import com.tictactoe2.model.Setting;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@NoArgsConstructor
public class FileConfig {

  private String configFile = "config.properties";

  public List<Setting> readFromFile() {
    Properties prop = new Properties();
    List<Setting> settings = new ArrayList<>();

    try {
      prop.load(getClass().getClassLoader().getResourceAsStream(configFile));

      for (int i = 0; i < prop.keySet().size(); i++) {
        Setting setting =
            new Setting(
                prop.keySet().toArray()[i].toString(), prop.values().toArray()[i].toString());
        settings.add(setting);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return settings;
  }
}
