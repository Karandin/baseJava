package model.storage;

import model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        int index = (int) searchKey;
        storage.set(index, r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        int index = (int) searchKey;
        storage.add(index, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        int index = (int) searchKey;
        return storage.get(index);
    }

    @Override
    protected void doDelete(Object searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return Collections.sort(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
