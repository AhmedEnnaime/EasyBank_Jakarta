package com.youcode.easybank_jee.dao;

import java.util.List;
import java.util.Optional;

public interface IData<Entity, Identifier> {
    public Optional<Entity> create(Entity entity);

    public Optional<Entity> update(Entity entity);

    public Optional<Entity> findByID(Identifier id);

    public List<Entity> getAll();

    public boolean delete(Identifier id);
}