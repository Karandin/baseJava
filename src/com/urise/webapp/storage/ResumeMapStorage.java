package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeMapStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> storage = new HashMap<>();


    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void doDelete(Resume searchKey) {
        storage.remove((searchKey).getUuid());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<Resume>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }
}