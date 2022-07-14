package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r) {
            storage[size] = r;
    }

    @Override
    public void deleteResume(String uuid) {
        int index = findIndex(uuid);
        storage[index] = storage[size - 1];
        storage[size] = null;
    }

    protected int findIndex(String s) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
