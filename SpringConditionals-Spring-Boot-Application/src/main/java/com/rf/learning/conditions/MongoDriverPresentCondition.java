package com.rf.learning.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDriverPresentCondition implements Condition
{
  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
  {
    try
    {
      Class.forName("com.mongodb.Server");
      return true;
    }
    catch (ClassNotFoundException ex)
    {
      return false;
    }
  }
}
