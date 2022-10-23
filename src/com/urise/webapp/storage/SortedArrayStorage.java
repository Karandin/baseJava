package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r, int indexStorage) {
        int index = Math.abs((Integer) getSearchKey(r.getUuid())) - 1;
        if (index < size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = r;
        }
        storage[index] = r;
    }

    @Override
    protected void deleteResume(int searchKey) {
        storage[searchKey] = null;
        System.arraycopy(storage, searchKey + 1, storage, searchKey, size - searchKey);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
