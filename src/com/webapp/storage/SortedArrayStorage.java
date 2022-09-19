package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r, int indexStorage) {
        int index = Math.abs((Integer) doSearchKey(r.getUuid())) - 1;
        if (index < size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = r;
        }
        storage[index] = r;
    }

    @Override
    protected void deleteResume(Object searchKey) {
        int index = (int) doSearchKey((String) searchKey);
        storage[index] = null;
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected Integer doSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
