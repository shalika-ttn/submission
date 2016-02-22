package com.ttnd.linksharing.Enum

enum Visiblity {
  PUBLIC,PRIVATE

  static Visiblity convert(String s)
  {
    if(s=="PUBLIC")
      Visiblity.PUBLIC
    else
      Visiblity.PRIVATE
  }

}

