package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow",r.getUuid());
        } else if (index > -1) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r);
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Элемента " + uuid + " нет в storage");
        } else {
            deleteResume(uuid);
            size--;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findIndex(String uuid);

    protected abstract void insertResume(Resume r);

    protected abstract void deleteResume(String uuid);


}

