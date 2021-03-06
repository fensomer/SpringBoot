package com.rf.learning.conditionalspringbootapp.conditions;

import com.rf.learning.conditionalspringbootapp.domain.UserDAO;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UserDAOBeanNotPresentCondition implements Condition
{
  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
  {
    UserDAO userDAO = conditionContext.getBeanFactory().getBean(UserDAO.class);
    return userDAO == null;
  }
}
