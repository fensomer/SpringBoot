package com.rf.learning.conditionalspringbootapp.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySQLDatabaseTypeCondition implements Condition
{
  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
  {
    final String dbType = System.getProperty("dbType");
    return dbType != null
        && dbType.equalsIgnoreCase("MYSQL");
  }
}
