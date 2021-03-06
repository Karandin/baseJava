package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r) {
        int index = Math.abs(findIndex(r.getUuid())) - 1;
        if (index < size) {
            System.arraycopy(storage, index, storage, index+1, size - index);
            storage[index] = r;
        }
        storage[index] = r;
    }

    @Override
    public void deleteResume(String uuid) {
        int index = findIndex(uuid);
        storage[index] = null;
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
