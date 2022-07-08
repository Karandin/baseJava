package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveValue(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < size) {
            System.out.println("Элемент " + r + " уже есть в storage");
        } else {
            storage[size] = r;
        }
    }

    @Override
    public void deleteValue(String uuid) {
        int index = findIndex(uuid);
        storage[index] = storage[size - 1];
        storage[size] = null;
        size--;
    }

    protected int findIndex(String s) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(s)) {
                return i;
            }
        }
        return size + 1;
    }
}
