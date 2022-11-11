package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertResume(Resume r, int indexStorage) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int searchKey) {
        storage[searchKey] = storage[size - 1];
        storage[size] = null;
    }
}
