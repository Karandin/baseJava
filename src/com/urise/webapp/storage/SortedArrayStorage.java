package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {



    @Override
    public void insertResume(Resume r, int indexStorage) {
        int index = Math.abs(doSearchKey(r.getUuid())) - 1;
        if (index < size) {
            System.arraycopy(storage, index, storage, index+1, size - index);
            storage[index] = r;
        }
        storage[index] = r;
    }

    @Override
    public void deleteResume(String uuid) {
        int index = doSearchKey(uuid);
        storage[index] = null;
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected Integer doSearchKey(Object searchKey) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
