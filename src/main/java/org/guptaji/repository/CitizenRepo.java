package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guptaji.entity.Citizen;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CitizenRepo implements PanacheRepository<Citizen> {
}
