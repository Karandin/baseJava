package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Object doSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if(listStorage.get(i).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object searchKey) {
            return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        int index = (int) searchKey;
        listStorage.set(index,r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        int index = (int) searchKey;
        listStorage.set(index,r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        int index = (int) searchKey;
        return listStorage.get(index);
    }

    @Override
    protected void doDelete(Object searchKey) {
        int index = (int) searchKey;
        listStorage.remove(index);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}
