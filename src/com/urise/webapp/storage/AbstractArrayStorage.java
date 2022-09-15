package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import com.urise.webapp.exception.StorageException;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected boolean isExist(Object searchKey) {
        int index = (int) doSearchKey(searchKey);
        if (index >= 0) {
            return true;
        }
        return false;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        int index = (int) doSearchKey(searchKey);
        storage[index] = r;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        int index = (int) doSearchKey(searchKey);
        insertResume(r, index);
        size++;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        int index = (int) doSearchKey(searchKey);
        return storage[index];
    }

    @Override
    protected void doDelete(Object searchKey) {
        int index = (int) doSearchKey(searchKey);
        deleteResume(index);
        size--;
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

    protected abstract Object doSearchKey(Object searchKey);

    protected abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(Object searchKey);

    public abstract void deleteResume(String uuid);
}

/*
    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
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
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(uuid);
            size--;
        }
    }

}



 */