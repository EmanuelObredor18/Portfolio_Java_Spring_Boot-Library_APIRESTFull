package com.obredor.library.utils;

public class CityCodeGenerator {

  public static String generateCityCode(String cityName, String stateOrProvinceName) {
    return cityName.substring(0, Math.min(cityName.length(), 3)).toUpperCase() + "-" + stateOrProvinceName;
  }

}
