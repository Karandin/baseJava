package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> MapStorage = new HashMap<>();


    @Override
    protected Object doSearchKey(String uuid) {
        if (MapStorage.containsKey(uuid)) {
            return MapStorage.keySet();
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return MapStorage.containsKey(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        MapStorage.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        MapStorage.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return MapStorage.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        MapStorage.remove(searchKey);
    }

    @Override
    public void clear() {
        MapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return MapStorage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return MapStorage.size();
    }
}
