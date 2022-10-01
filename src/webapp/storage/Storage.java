package webapp.storage;

import model.Resume;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Object get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}