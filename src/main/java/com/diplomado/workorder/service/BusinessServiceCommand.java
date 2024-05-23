package com.diplomado.workorder.service;

import java.util.List;
import java.util.Optional;

public interface BusinessServiceCommand<T, U> {

  T save(T t);
  List<T> getAll();
  Optional<T> findById(U u);
  T update(T t);

}
