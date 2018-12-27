package ru.itis.repositories;

import ru.itis.models.Admin;

public interface AdminRepository extends CrudRepository<Admin>{
    Admin findByUsername(String name);
}
