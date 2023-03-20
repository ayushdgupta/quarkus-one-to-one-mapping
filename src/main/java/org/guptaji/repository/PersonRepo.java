package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.guptaji.entity.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepo implements PanacheRepositoryBase<Person, Integer> {
}
