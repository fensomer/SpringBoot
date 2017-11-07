package com.rf.learning.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDbTypePropertyCondition implements Condition
{

  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
  {
    final String dbType = conditionContext.getEnvironment().getProperty("app.dbType");
    return "MONGODB".equalsIgnoreCase(dbType);
  }
}
