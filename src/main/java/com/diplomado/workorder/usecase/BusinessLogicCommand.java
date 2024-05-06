package com.diplomado.workorder.usecase;

public interface BusinessLogicCommand<T, S> {
  
  T execute(S s);
}
