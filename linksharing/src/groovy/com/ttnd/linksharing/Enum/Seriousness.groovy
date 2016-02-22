package com.ttnd.linksharing.Enum

enum Seriousness {
  SERIOUS ,VERY_SERIOUS,CASUAL

  static Seriousness convert(String s)
  {
    if(s=="SERIOUS"||s=="serious")
      Seriousness.SERIOUS
    else if(s=="VERY_SERIOUS"||s=="very_serious")
      Seriousness.VERY_SERIOUS
    else
      Seriousness.CASUAL
  }

}