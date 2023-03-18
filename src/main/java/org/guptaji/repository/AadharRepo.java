package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guptaji.entity.Aadhar;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AadharRepo implements PanacheRepository<Aadhar> {
}
