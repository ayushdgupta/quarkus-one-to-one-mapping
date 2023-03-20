package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.guptaji.entity.Simcard;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimcardRepo implements PanacheRepositoryBase<Simcard, Integer> {
}
