package dao;

import bean.People;

import java.util.List;

public interface PeopleDao {
    People findByName(String name);
    List<People> findAll();
}
