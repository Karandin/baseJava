package model.storage;

import model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Object get(String uuid);

    void delete(String uuid);

    List<Resume> getAllSorted();

    int size();
}