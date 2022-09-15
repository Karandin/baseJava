package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object searchKey = doSearchKey(r.getUuid());
        if (isExist(searchKey)) {
            doUpdate(r, searchKey);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public void save(Resume r) {
        Object searchKey = doSearchKey(r.getUuid());
            if (isExist(searchKey)) {
                doSave(r, searchKey);
        } else {
                throw new ExistStorageException(r.getUuid());
        }
    }

    public Resume get(String uuid) {
        Object searchKey = doSearchKey(uuid);
        if (isExist(searchKey)) {
            return doGet(searchKey);
        }else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void delete(String uuid) {
        Object searchKey = doSearchKey(uuid);
        if (isExist(searchKey)) {
            doDelete(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract Object doSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

}
