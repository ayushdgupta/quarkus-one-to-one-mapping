package org.guptaji.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.guptaji.entity.Bank;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankRepo implements PanacheRepositoryBase<Bank, Integer> {
}
