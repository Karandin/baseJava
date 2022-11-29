package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        int index = searchKey;
        storage.set(index, r);
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        int index = searchKey;
        storage.add(index, r);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        int index = searchKey;
        return storage.get(index);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return storage;
    }

    @Override
    public int size() {
        return storage.size();
    }
}
