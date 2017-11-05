package com.rf.learning.impl;

import com.rf.learning.api.SystemPrinter;

public class SystemPrinterDevImpl implements SystemPrinter
{
  @Override
  public void print()
  {
    System.out.println("******** THIS IS THE DEV IMPLEMENTATION ********");
  }
}
