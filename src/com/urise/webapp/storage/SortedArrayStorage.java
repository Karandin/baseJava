package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveValue(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < size) {
            for (int i = size - 1; i >= index; i--) {
                storage[i + 1] = storage[i];
            }
        }
        storage[index] = r;
    }

    @Override
    public void deleteValue(String uuid) {
        int index = findIndex(uuid);
        storage[index] = null;
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        if (Math.abs(Arrays.binarySearch(storage, 0, size, searchKey)) != 0) {
            return Math.abs(Arrays.binarySearch(storage, 0, size, searchKey)) - 1;
        }
        return Math.abs(Arrays.binarySearch(storage, 0, size, searchKey));
    }
}
