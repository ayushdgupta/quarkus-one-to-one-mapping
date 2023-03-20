package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.guptaji.entity.Citizen2;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Citizen2Repo implements PanacheRepositoryBase<Citizen2, Integer> {
}
