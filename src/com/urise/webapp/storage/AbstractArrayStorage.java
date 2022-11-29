package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import com.urise.webapp.exception.StorageException;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    public static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected boolean isExist(Integer searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storage[(int) searchKey] = r;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        insertResume(r, (int) searchKey);
        size++;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void doDelete(Integer searchKey) {
        deleteResume((int) searchKey);
        size--;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public int size() {
        return size;
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(int searchKey);
}
