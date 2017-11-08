package com.rf.com.rf.learning.profilesspringbootapp.impl;

import com.rf.com.rf.learning.profilesspringbootapp.api.SystemPrinter;

public class SystemPrinterDevImpl implements SystemPrinter
{
  @Override
  public void print()
  {
    System.out.println("******** THIS IS THE DEV IMPLEMENTATION ********");
  }
}
